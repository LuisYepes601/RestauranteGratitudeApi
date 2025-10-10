/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Productos;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.DTOS.Request.Productos.CrearProductoDto;
import restaurante_gratitude.demp.DTOS.Request.Productos.EditarDatosBasicProductDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.CrearProductoService;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.EditarProductosService;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.EliminarProductoService;
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
    private EliminarProductoService eliminarProductsoServive;
    private EditarProductosService editarProductosService;

    @Autowired
    public GestionarProductosController(CrearProductoService crearProductoService, ObtenerProductosService obtenerProdcutosService, EliminarProductoService eliminarProductsoServive, EditarProductosService editarProductosService) {
        this.crearProductoService = crearProductoService;
        this.obtenerProdcutosService = obtenerProdcutosService;
        this.eliminarProductsoServive = eliminarProductsoServive;
        this.editarProductosService = editarProductosService;
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

    @DeleteMapping(value = "eliminar/byId/{id}")
    public ResponseEntity<?> eliminarProductoById(@PathVariable Integer id) {

        eliminarProductsoServive.eliminarProductoById(id);

        Map<String, String> respuesta = new HashMap<>();

        respuesta.put("mensaje", "El producto ha sido eliminado con exito.");

        return ResponseEntity.ok(respuesta);
    }

    @PostMapping(value = "editar")
    public ResponseEntity<?> editarDatosBasicosProductos(
            @RequestBody EditarDatosBasicProductDto datosBasicProductDto) {

        String respuesta = editarProductosService.editarProductoByid(datosBasicProductDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensaje", respuesta));
    }
}
