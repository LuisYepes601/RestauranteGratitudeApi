/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Productos.Contenido;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Request.Productos.Contenido.TipoContenidoDto;
import restaurante_gratitude.demp.DTOS.Response.Productos.Contenido.TipoContenidoDtoResponse;
import restaurante_gratitude.demp.Service.Productos.Contenido.GestionarTipoDeContenido;


/**
 *
 * @author Usuario
 */
@Tag(
        name = "Tipo de Contenido de un Producto",
        description = "Modulo encargado de administrar los tios de contenidod de productos en el sistema.")
@RestController
@RequestMapping(value = "/api/v1/type-contents-products")
public class GestionarTipoContenidoProductoController {

    private GestionarTipoDeContenido tipoDeContenidoService;

    @Autowired
    public GestionarTipoContenidoProductoController(GestionarTipoDeContenido tipoDeContenidoService) {
        this.tipoDeContenidoService = tipoDeContenidoService;
    }

    @Operation(
            description = "Operación encargada de crear un tipo de contenido de prodcuto en el sistema.",
            method = "POST")
    @PostMapping
    public ResponseEntity<BasicResponseDto> createTipoContent(
            @Valid
            @RequestBody TipoContenidoDto tipoContenidoDto) {

        return ResponseEntity
                .ok()
                .body(tipoDeContenidoService.crearTipoDeContenido(tipoContenidoDto));

    }

    @Operation(
            description = "Operación que permte obtener todos los tipos de contenidos en el sistema segun los filtros aplicados.",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<TipoContenidoDtoResponse>> getAll(
            @RequestParam(
                    name = "nombre",
                    required = false) String nombre,
            @RequestParam(
                    name = "isDelete",
                    required = false) Boolean isDelete,
            Pageable pageable) {

        return ResponseEntity
                .ok()
                .body(tipoDeContenidoService.getAll(nombre, isDelete, pageable));
    }
}
