/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.DTOS.Request.Productos.EditarDatosBasicProductDto;
import restaurante_gratitude.demp.Entidades.Productos.Categoria;
import restaurante_gratitude.demp.Entidades.Productos.Contenido;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
import restaurante_gratitude.demp.Entidades.Productos.TipoContenidoProducto;
import restaurante_gratitude.demp.Repositorys.Productos.CategoriaProductoRepository;
import restaurante_gratitude.demp.Repositorys.Productos.ContenidoProducto;
import restaurante_gratitude.demp.Repositorys.Productos.ProductoRepository;
import restaurante_gratitude.demp.Repositorys.Productos.TipoContenidoProductoRepository;
import restaurante_gratitude.demp.Service.Productos.EditarProductos;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class EditarProductosService implements EditarProductos {

    private ProductoRepository productoRepository;
    private CategoriaProductoRepository categoriaProdcutoRepo;
    private ContenidoProducto contenidoProducto;
    private TipoContenidoProductoRepository tipoContenidoRepo;

    @Autowired
    public EditarProductosService(ProductoRepository productoRepository, CategoriaProductoRepository categoriaProdcutoRepo, ContenidoProducto contenidoProducto, TipoContenidoProductoRepository tipoContenidoRepo) {
        this.productoRepository = productoRepository;
        this.categoriaProdcutoRepo = categoriaProdcutoRepo;
        this.contenidoProducto = contenidoProducto;
        this.tipoContenidoRepo = tipoContenidoRepo;
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

}
