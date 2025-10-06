/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Productos;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.DTOS.Request.Productos.CrearProductoDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.CrearProductoService;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value = "producto", consumes = {"multipart/form-data"})
public class GestionarProductosController {

    private CrearProductoService crearProductoService;

    @Autowired
    public GestionarProductosController(CrearProductoService crearProductoService) {
        this.crearProductoService = crearProductoService;
    }

    @PostMapping(value = "crear")
    public ResponseEntity<?> crearProducto(@Valid
            @RequestPart("imagen") MultipartFile imagen,
            @RequestPart("producto") CrearProductoDto productodto) {

        Map respuesta = crearProductoService.crearProducto(productodto, imagen);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(respuesta);
    }

}
