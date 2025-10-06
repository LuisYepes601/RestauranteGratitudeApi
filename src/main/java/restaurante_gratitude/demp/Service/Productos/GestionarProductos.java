/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.Productos;

import java.util.Map;
import restaurante_gratitude.demp.DTOS.Request.Productos.CrearProductoDto;

/**
 *
 * @author Usuario
 */
public interface GestionarProductos {
    
    public Map<String,String>crearProducto(CrearProductoDto crearProductoDto);
    
}
