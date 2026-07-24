/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Productos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.Request.Productos.CrearProductoDto;
import restaurante_gratitude.demp.Service.Productos.AdministrarProducts;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.CrearProductoService;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.EditarProductosService;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.EliminarProductoService;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.ObtenerProductosService;

/**
 *
 * @author User
 */
@Tag(
        name = "Productos",
        description = "Módulo encargado de adminitrar todas las funcionalidades con respecto a los productos")
@RestController()
@RequestMapping(value = "/api/v1/products")
public class GestionarProductosController {

    private AdministrarProducts productosService;

    public GestionarProductosController(AdministrarProducts productosService) {
        this.productosService = productosService;
    }

    @Operation(
            description = "Crear producto a travez de los datos solicitados",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> createProduct(
            @Valid
            @RequestPart(required = true, name = "producto") CrearProductoDto productoDto,
            @RequestPart(required = true, name = "primary") MultipartFile primary,
            @RequestPart(required = false, name = "gallery") List<MultipartFile> gallery
    ) {

        return ResponseEntity
                .ok()
                .body(productosService.createProduct(primary, gallery, productoDto));
    }
}
