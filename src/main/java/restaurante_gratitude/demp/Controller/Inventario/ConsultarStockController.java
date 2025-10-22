/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Inventario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Response.Inventario.inventarioDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Inventario.ConsultarInventarioService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "consultarStock")
public class ConsultarStockController {
    
    private ConsultarInventarioService consultarInventarioService;
    
    @Autowired
    public ConsultarStockController(ConsultarInventarioService consultarInventarioService) {
        this.consultarInventarioService = consultarInventarioService;
    }
    
    @GetMapping(value = "/")
    public ResponseEntity<List<inventarioDto>> consultarInventario() {
        
        return ResponseEntity.status(HttpStatus.OK)
                .body(consultarInventarioService.getProductos());
    }
    
}
