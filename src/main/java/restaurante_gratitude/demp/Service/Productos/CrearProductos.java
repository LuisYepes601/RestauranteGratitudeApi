/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.Productos;

import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.DTOS.Request.Productos.CrearProductoDto;
import restaurante_gratitude.demp.DTOS.Response.Productos.ObtnerProductoDto;
import restaurante_gratitude.demp.Entidades.Productos.Producto;

/**
 *
 * @author Usuario
 */
public interface CrearProductos {

    public Map<String, String> crearProducto(CrearProductoDto crearProductoDto, MultipartFile file);


}
