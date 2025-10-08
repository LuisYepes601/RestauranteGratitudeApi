/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.DTOS.Request.Productos.CrearProductoDto;
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
import restaurante_gratitude.demp.Service.Productos.CrearProductos;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivos.CargarImagenesService;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class CrearProductoService implements CrearProductos {

    private ProductoRepository productoRepo;
    private ContenidoProducto contenidoProductoRepo;
    private TipoContenidoProductoRepository tipoContenidoProductoRepository;
    private CategoriaProductoRepository categoriaProductoRepository;
    private StockProductoRepository stockProductoRepository;
    private CargarImagenesService caragarImagenesService;

    public CrearProductoService() {
    }

    @Autowired
    public CrearProductoService(ProductoRepository productoRepo, ContenidoProducto contenidoProductoRepo, TipoContenidoProductoRepository tipoContenidoProductoRepository, CategoriaProductoRepository categoriaProductoRepository, StockProductoRepository stockProductoRepository, CargarImagenesService caragarImagenesService) {
        this.productoRepo = productoRepo;
        this.contenidoProductoRepo = contenidoProductoRepo;
        this.tipoContenidoProductoRepository = tipoContenidoProductoRepository;
        this.categoriaProductoRepository = categoriaProductoRepository;
        this.stockProductoRepository = stockProductoRepository;
        this.caragarImagenesService = caragarImagenesService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, String> crearProducto(CrearProductoDto crearProductoDto, MultipartFile file) {

        ValidacionesGlobales.validarExistencia(
                productoRepo
                        .findByNombre(crearProductoDto.getNombre()),
                "Error. El producto: " + crearProductoDto.getNombre() + " ya se encuentra en el sistema."
                + " Le invitamos a crear un producto que no exista.");

        Producto producto = new Producto();

        producto.setNombre(crearProductoDto.getNombre());
        producto.setDescripcion(crearProductoDto.getDescripcion());
        producto.setPrecio(crearProductoDto.getPrecio());

        Categoria categoria = ValidacionesGlobales.obtenerSiExiste(
                categoriaProductoRepository.findBynobre(crearProductoDto.getCategoria()),
                "La categoria: " + crearProductoDto.getCategoria() + " no se encuentra disponible en el sistema."
                + " Le invitamos a ingresar una categoria valida. ");

        producto.setCategoria(categoria);

        Contenido contenidoProducto = new Contenido();

        contenidoProducto.setValor(crearProductoDto.getValorcontenido());

        TipoContenidoProducto tipoContenidoProducto = ValidacionesGlobales
                .obtenerSiExiste(
                        tipoContenidoProductoRepository.findByNombre(crearProductoDto.getTipoContenido()),
                        "El tipo de contenido: " + crearProductoDto.getTipoContenido() + " no existe en el sistema."
                        + "");

        contenidoProducto.setTipo(tipoContenidoProducto);

        contenidoProductoRepo.save(contenidoProducto);

        producto.setContenido(contenidoProducto);

        String imagen;

        imagen = caragarImagenesService.agregarFotoDeProdcuto(file, producto);
        producto.setImagen(imagen);

        productoRepo.save(producto);

        StockProducto stockProducto = new StockProducto();

        stockProducto.setCantidad(crearProductoDto.getCantidad());
        stockProducto.setCantidadMin(crearProductoDto.getCantidadMin());
        stockProducto.setCantidadMax(crearProductoDto.getCantidadMax());
        stockProducto.setFecha_ingreso(crearProductoDto.getFecha_ingreso());
        stockProducto.setProducto(producto);

        stockProductoRepository.save(stockProducto);

        Map<String, String> respuesta = new HashMap<>();

        respuesta.put("mensaje", "El producto: " + crearProductoDto.getNombre() + " ha sido agregado con exito al sistema.");

        return respuesta;
    }

}
