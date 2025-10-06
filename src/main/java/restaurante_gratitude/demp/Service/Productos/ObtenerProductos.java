/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Productos;

import java.util.List;
import restaurante_gratitude.demp.DTOS.Response.Productos.ObtnerProductoDto;
import restaurante_gratitude.demp.Entidades.Productos.Producto;

/**
 *
 * @author User
 */
public interface ObtenerProductos {

    public List<ObtnerProductoDto> productosDatosBasicos();

}
