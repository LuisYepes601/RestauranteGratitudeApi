/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoNoExistenteEcxeption;
import restaurante_gratitude.demp.DTOS.Response.Calificaciones.ObtenerCalificacionesDto;
import restaurante_gratitude.demp.DTOS.Response.Productos.ObtnerProductoDto;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
import restaurante_gratitude.demp.Entidades.RangoCalificacion.CalficacionProducto;
import restaurante_gratitude.demp.Repositorys.Productos.ProductoRepository;
import restaurante_gratitude.demp.Service.Productos.ObtenerProductos;

/**
 *
 * @author User
 */
@Service
public class ObtenerProductosService implements ObtenerProductos {
    
    private ProductoRepository productoRepository;
    
    @Autowired
    public ObtenerProductosService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    
    @Override
    public List<ObtnerProductoDto> productosDatosBasicos() {
        
        List<Producto> productos = productoRepository.findAll();
        
        List<Producto> productosExistentes = new ArrayList<>();
        
        productosExistentes = productos.stream()
                .filter(producto -> producto.isIsDelete() != true)
                .collect(Collectors.toList());
        
        if (productosExistentes.isEmpty()) {
            throw new DatoNoExistenteEcxeption("Error, no hay productos disponibles en el sistema actualmente.");
        }
        
        List<ObtnerProductoDto> productoDtos = new ArrayList<>();
        
        for (Producto producto : productosExistentes) {
            
            ObtnerProductoDto productoDto = new ObtnerProductoDto();

            //DATOS BASICOS PRODUCTO
            productoDto.setNombre(producto.getNombre());
            productoDto.setPrecio(producto.getPrecio());
            productoDto.setDescripcion(producto.getDescripcion());
            productoDto.setImagen(producto.getImagen());

            //DATOS DE CATEGORIA
            productoDto.setCategoria(producto.getCategoria().getNobre());
            productoDto.setId_categoria(producto.getCategoria().getId());

            //DATOS DE CONTENIDO DEL PRODCUTO
            productoDto.setTipoContenido(producto.getContenido().getTipo().getNombre());
            productoDto.setValorContenido(producto.getContenido().getValor());
            productoDto.setIdTipoContenido(producto.getContenido().getTipo().getId());

            //DATOS DE PROMOCION
            if (producto.getPromocion() != null) {
                productoDto.setIdtipoPromocion(producto.getPromocion().getTipoPromocion().getId());
                productoDto.setTipoPromocion(producto.getPromocion().getTipoPromocion().getName());
                productoDto.setValorPromocion(producto.getPromocion().getValor());
                productoDto.setDescripcionPromocion(producto.getPromocion().getDescripcion());
                productoDto.setFechaFin(producto.getPromocion().getFechaFin());
                
            }
            List<ObtenerCalificacionesDto> calificacionesDtos = new ArrayList<>();
            for (CalficacionProducto calficacionProducto : producto.getCalficacionProductos()) {
                
                ObtenerCalificacionesDto calificacionesDto = new ObtenerCalificacionesDto();
                
                calificacionesDto.setIdRango(calficacionProducto.getRangoCalificacion().getId());
                calificacionesDto.setNombreRango(calficacionProducto.getRangoCalificacion().getNombre());
                
                calificacionesDto.setDescripcion(calficacionProducto.getDescripcion());
                calificacionesDto.setEvidencia(calficacionProducto.getEvidencia());
                calificacionesDto.setIdRango(calficacionProducto.getUsuario().getId());
                calificacionesDto.setNombreUsario(calficacionProducto.getUsuario().getPrimerNombre());
                
                calificacionesDtos.add(calificacionesDto);
                
            }
            productoDto.setCalificacionesDtos(calificacionesDtos);
            
            productoDtos.add(productoDto);
        }
        
        return productoDtos;
        
    }
    
}
