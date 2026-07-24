/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Productos.Contenido;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.Request.Productos.Contenido.ContenidoDto;
import restaurante_gratitude.demp.Service.Productos.Contenido.IContenidoProduct;

/**
 *
 * @author luis
 */
@Tag(
        name = "Content Product",
        description = "Modulo encargado de adminidatras todas las operaciones respecto a el contenido de un producto")
@RequestMapping(value = "/api/v1/content-products")
@RestController
public class ContenidoController {

    private IContenidoProduct contenidoProductService;

    @Autowired
    public ContenidoController(IContenidoProduct contenidoProductService) {
        this.contenidoProductService = contenidoProductService;
    }

    @Operation(
            description = "OPeración encargada de crear un contenido en el sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> create(
            @Valid
            @RequestBody(required = true) ContenidoDto contenidoDto) {

        contenidoProductService.create(contenidoDto);
        return ResponseEntity
                .ok()
                .build();
    }

}
