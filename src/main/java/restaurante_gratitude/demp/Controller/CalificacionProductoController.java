/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.Entidades.RangoCalificacion.CalficacionProducto;
import restaurante_gratitude.demp.Service.ServiceImplement.CalificacionProductoImplement;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/productosCalificados")
public class CalificacionProductoController {

    @Autowired
    private CalificacionProductoImplement impl;
    
    @GetMapping("/all")
    public List<CalficacionProducto> calficacionProductos (){
        
        return impl.calficacionProductos();
    }
}
