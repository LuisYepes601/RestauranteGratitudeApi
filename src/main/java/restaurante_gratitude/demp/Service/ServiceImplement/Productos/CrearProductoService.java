/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
import restaurante_gratitude.demp.Service.Productos.GestionarProductos;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class CrearProductoService implements GestionarProductos {

    private ProductoRepository productoRepo;
    private ContenidoProducto contenidoProductoRepo;
    private TipoContenidoProductoRepository tipoContenidoProductoRepository;
    private CategoriaProductoRepository categoriaProductoRepository;
    private StockProductoRepository stockProductoRepository;

    @Autowired
    public CrearProductoService(ProductoRepository productoRepo, ContenidoProducto contenidoProductoRepo, TipoContenidoProductoRepository tipoContenidoProductoRepository, CategoriaProductoRepository categoriaProductoRepository, StockProductoRepository stockProductoRepository) {
        this.productoRepo = productoRepo;
        this.contenidoProductoRepo = contenidoProductoRepo;
        this.tipoContenidoProductoRepository = tipoContenidoProductoRepository;
        this.categoriaProductoRepository = categoriaProductoRepository;
        this.stockProductoRepository = stockProductoRepository;
    }

    public CrearProductoService() {
    }

    @Override
    public Map<String, String> crearProducto(CrearProductoDto crearProductoDto) {

        ValidacionesGlobales.validarExistencia(
                productoRepo
                        .findByName(crearProductoDto.getNombre()),
                "Error. El producto: " + crearProductoDto.getNombre() + " ya se encuentra en el sistema."
                + " Le invitamos a crear un producto que no exista.");

        Producto producto = new Producto();

        producto.setNombre(crearProductoDto.getNombre());
        producto.setDescripcion(crearProductoDto.getDescripcion());
        producto.setPrecio(crearProductoDto.getPrecio());

        Categoria categoria = ValidacionesGlobales.obtenerSiExiste(
                categoriaProductoRepository.findBynobre(crearProductoDto.getNombre()),
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

        productoRepo.save(producto);

        StockProducto stockProducto = new StockProducto();

        stockProducto.setCantidad(crearProductoDto.getCantidad());
        stockProducto.setCantidadMin(crearProductoDto.getCantidadMin());
        stockProducto.setCantidadMax(crearProductoDto.getCantidadMax());
        stockProducto.setFecha_ingreso(crearProductoDto.getFecha_ingreso());
        stockProducto.setProducto(producto);

        stockProductoRepository.save(stockProducto);

        Map<String, String> respuesta = new HashMap<>();

        return respuesta;
    }

}
