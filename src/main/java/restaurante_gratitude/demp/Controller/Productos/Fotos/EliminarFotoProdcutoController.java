/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Productos.Fotos;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.EliminarFotoProductoService;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value = "elminar")
public class EliminarFotoProdcutoController {

    private EliminarFotoProductoService eliminarFotoProductoService;

    @Autowired
    public EliminarFotoProdcutoController(EliminarFotoProductoService eliminarFotoProductoService) {
        this.eliminarFotoProductoService = eliminarFotoProductoService;
    }

    @DeleteMapping(value = "foto/producto")
    public ResponseEntity<?> eliminarFotoProdcuto(@PathVariable Integer id) {

        eliminarFotoProductoService.eliminarFotoProducto(id);

        return ResponseEntity.ok(Map.of("mensaje", "Eliminacion de foto correcta."));
    }

}
