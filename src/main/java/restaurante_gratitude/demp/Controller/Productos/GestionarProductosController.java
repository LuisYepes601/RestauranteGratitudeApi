/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Productos;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.DTOS.Request.Productos.CrearProductoDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.CrearProductoService;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.ObtenerProductosService;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value = "producto")
public class GestionarProductosController {

    private CrearProductoService crearProductoService;
    private ObtenerProductosService obtenerProdcutosService;

    @Autowired
    public GestionarProductosController(CrearProductoService crearProductoService, ObtenerProductosService obtenerProdcutosService) {
        this.crearProductoService = crearProductoService;
        this.obtenerProdcutosService = obtenerProdcutosService;
    }

    @PostMapping(value = "crear", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> crearProducto(@Valid
            @RequestPart("imagen") MultipartFile imagen,
            @RequestPart("producto") CrearProductoDto productodto) {

        Map respuesta = crearProductoService.crearProducto(productodto, imagen);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(respuesta);
    }

    @GetMapping(value = "/obtener/todos")
    public ResponseEntity<?> obtnerTodolosProductos() {

        return ResponseEntity.ok(obtenerProdcutosService.productosDatosBasicos());
    }

}
