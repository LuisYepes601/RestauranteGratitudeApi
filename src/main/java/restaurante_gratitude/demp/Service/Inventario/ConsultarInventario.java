/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Inventario;

import java.util.List;
import restaurante_gratitude.demp.DTOS.Response.Inventario.inventarioDto;

/**
 *
 * @author Usuario
 */
public interface ConsultarInventario {

    public List<inventarioDto> getProductos();

}
