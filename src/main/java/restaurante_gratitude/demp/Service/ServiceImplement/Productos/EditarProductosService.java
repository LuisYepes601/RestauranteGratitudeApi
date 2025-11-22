/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos;

import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.DTOS.Request.Productos.CrearProductoDto;
import restaurante_gratitude.demp.DTOS.Request.Productos.EditarDatosBasicProductDto;
import restaurante_gratitude.demp.Entidades.InventarioStockProducto.StockProducto;
import restaurante_gratitude.demp.Entidades.Productos.Categoria;
import restaurante_gratitude.demp.Entidades.Productos.Contenido;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
import restaurante_gratitude.demp.Entidades.Productos.TipoContenidoProducto;
import restaurante_gratitude.demp.Repositorys.Inventario.StockProductoRepository;
import restaurante_gratitude.demp.Repositorys.Productos.CategoriaProductoRepository;
import restaurante_gratitude.demp.Repositorys.Productos.ContenidoProducto;
import restaurante_gratitude.demp.Repositorys.Productos.ProductoRepository;
import restaurante_gratitude.demp.Repositorys.Productos.TipoContenidoProductoRepository;
import restaurante_gratitude.demp.Service.Productos.EditarProductos;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivosCloudiny.CargarImagenesService;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class EditarProductosService implements EditarProductos {

    private ProductoRepository productoRepository;
    private CategoriaProductoRepository categoriaProdcutoRepo;
    private ContenidoProducto contenidoProductoRepo;
    private TipoContenidoProductoRepository tipoContenidoRepo;
    private CargarImagenesService imagenService;
    private StockProductoRepository stockProductoRepository;

    @Autowired
    public EditarProductosService(ProductoRepository productoRepository, CategoriaProductoRepository categoriaProdcutoRepo, ContenidoProducto contenidoProductoRepo, TipoContenidoProductoRepository tipoContenidoRepo, CargarImagenesService imagenService, StockProductoRepository stockProductoRepository) {
        this.productoRepository = productoRepository;
        this.categoriaProdcutoRepo = categoriaProdcutoRepo;
        this.contenidoProductoRepo = contenidoProductoRepo;
        this.tipoContenidoRepo = tipoContenidoRepo;
        this.imagenService = imagenService;
        this.stockProductoRepository = stockProductoRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String editarProductoByid(EditarDatosBasicProductDto datosBasicProductDto) {

        Producto producto = ValidacionesGlobales.obtenerSiExiste(
                productoRepository.findById(datosBasicProductDto.getId_producto()),
                "El producto seleccionado no se encuentra en el sistema."
                + "Le invitamos a ingresar un producto existente");

        producto.setNombre(datosBasicProductDto.getNombre());
        producto.setDescripcion(datosBasicProductDto.getDescripcion());
        producto.setPrecio(datosBasicProductDto.getPrecio());

        Categoria categoria = ValidacionesGlobales.obtenerSiExiste(categoriaProdcutoRepo.
                findById(datosBasicProductDto.getId_categoria()),
                "El tipo de categoria ingresado no se encuentra en el sistema."
                + " Le invitamos a ingresar una categoria valida.");

        producto.setCategoria(categoria);

        Contenido contenido = producto.getContenido();

        TipoContenidoProducto tipoContenidoProducto = ValidacionesGlobales.obtenerSiExiste(
                tipoContenidoRepo.findById(datosBasicProductDto.getId_tipo_contenido()),
                "El tipo de contenido ingresado no se encuentra en el sistema."
                + " Le invitamos ingresar un tipo de contenido valido ");

        contenido.setTipo(tipoContenidoProducto);

        producto.setContenido(contenido);

        Map<String, String> respuesta = new HashMap<>();

        respuesta.put("mensaje", "El producto: " + producto.getNombre() + "se ha editado con exito.");

        return respuesta.get("mensaje");

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String, String> editarProdcuto(CrearProductoDto crearProductoDto, MultipartFile file) {

        Producto producto = ValidacionesGlobales.obtenerSiExiste(
                productoRepository
                        .findByNombre(crearProductoDto.getNombre()),
                "Error. El producto: " + crearProductoDto.getNombre() + " no se encuentra en el sistema."
                + " Le invitamos a editar un producto que exista.");

        producto.setNombre(crearProductoDto.getNombre());
        producto.setDescripcion(crearProductoDto.getDescripcion());
        producto.setPrecio(crearProductoDto.getPrecio());

        Categoria categoria = ValidacionesGlobales.obtenerSiExiste(
                categoriaProdcutoRepo.findBynobre(crearProductoDto.getCategoria()),
                "La categoria: " + crearProductoDto.getCategoria() + " no se encuentra disponible en el sistema."
                + " Le invitamos a ingresar una categoria valida. ");

        producto.setCategoria(categoria);

        Contenido contenidoProducto = new Contenido();

        contenidoProducto.setValor(crearProductoDto.getValorcontenido());

        TipoContenidoProducto tipoContenidoProducto = ValidacionesGlobales
                .obtenerSiExiste(
                        tipoContenidoRepo.findByNombre(crearProductoDto.getTipoContenido()),
                        "El tipo de contenido: " + crearProductoDto.getTipoContenido() + " no existe en el sistema."
                        + "");

        contenidoProducto.setTipo(tipoContenidoProducto);

        contenidoProductoRepo.save(contenidoProducto);

        producto.setContenido(contenidoProducto);

        String imagen;

        imagen = imagenService.cargarFoto(
                file,
                "La imagen no se pudo cargar.",
                ObjectUtils.asMap("public_id", "productos/" + producto.getNombre(),
                        "transformation", new Transformation<>()
                                .quality("auto")
                                .fetchFormat("auto")
                                .width(300)
                                .height(300)
                                .crop("limit")
                ),
                producto.getNombre());

        producto.setImagen(imagen);

        productoRepository.save(producto);

        StockProducto stockProducto = ValidacionesGlobales.obtenerSiExiste(
                stockProductoRepository.findByProductoId(
                        producto.getId()),
                "Error el prodcuto no se encuentra en el inventario");

        stockProducto.setCantidad(crearProductoDto.getCantidad());
        stockProducto.setCantidadMin(crearProductoDto.getCantidadMin());
        stockProducto.setCantidadMax(crearProductoDto.getCantidadMax());
        

        stockProductoRepository.save(stockProducto);

        Map<String, String> respuesta = new HashMap<>();

        respuesta.put("mensaje", "El producto: " + crearProductoDto.getNombre() + " ha sido agregado con exito al sistema.");

        return respuesta;
    }

}
