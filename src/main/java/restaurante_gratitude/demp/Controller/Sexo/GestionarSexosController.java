/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Sexo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Request.Sexo.SexoDto;
import restaurante_gratitude.demp.DTOS.Response.Sexo.SexoDetailsDto;
import restaurante_gratitude.demp.DTOS.Response.Sexo.SexoResponseDto;
import restaurante_gratitude.demp.Service.Sexo.GestionarSexos;

/**
 *
 * @author User
 */
@Tag(name = "Sexo")
@RestController
@RequestMapping(value = "api/v1/sexo")
public class GestionarSexosController {

    private GestionarSexos gestionarSexosService;

    @Autowired
    public GestionarSexosController(GestionarSexos gestionarSexosService) {
        this.gestionarSexosService = gestionarSexosService;
    }

    public GestionarSexosController() {
    }

    public GestionarSexos getGestionarSexosService() {
        return gestionarSexosService;
    }

    public void setGestionarSexosService(GestionarSexos gestionarSexosService) {
        this.gestionarSexosService = gestionarSexosService;
    }

    @Operation(
            description = "Operación encargada de crear un género en el sistema.",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> agregarSexo(
            @Valid
            @RequestBody SexoDto sexoDto) {

        return ResponseEntity
                .ok()
                .body(gestionarSexosService.agregarSexo(sexoDto));
    }

    @GetMapping()
    public ResponseEntity<PageResponse<SexoResponseDto>> findAll(
            @RequestParam(
                    name = "nombre",
                    required = false) String nombre,
            @RequestParam(
                    name = "isDelete",
                    required = false) Boolean isDelete,
            Pageable pageable) {

        return ResponseEntity
                .ok()
                .body(gestionarSexosService.getAll(
                        nombre,
                        isDelete,
                        pageable));
    }

    @Operation(
            description = "Operación encargada de acytulizar un registro de sexo en el sistema.",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateById(
            @PathVariable(
                    name = "id",
                    required = true) Integer id,
            @Valid
            @RequestBody(required = true) SexoDto sexoDto) {

        BasicResponseDto response = gestionarSexosService.updateById(id, sexoDto);

        return ResponseEntity
                .ok()
                .body(response);
    }

    @Operation(
            description = "Operación encargada de eliminar Sexos del sistema.",
            method = "DELETE")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> deleteById(
            @PathVariable(
                    name = "id",
                    required = true) Integer id) {

        return ResponseEntity
                .ok()
                .body(gestionarSexosService.deleteById(id));
    }

    @Operation(description = "Operacion enecargada de activar registros de Sexo en el sistema")
    @PutMapping(value = "/{id}/activate")
    public ResponseEntity<BasicResponseDto> activateById(
            @PathVariable(
                    name = "id",
                    required = true) Integer id) {

        return ResponseEntity
                .ok()
                .body(gestionarSexosService.activateById(id));

    }

    @Operation(description = "Operación encargada de mostrar detalles de un regitro de Sexo.")
    @GetMapping(value = "/{id}/details")
    public ResponseEntity<SexoDetailsDto> getDetailsById(
            @PathVariable(
                    name = "id",
                    required = true) Integer id) {

        return ResponseEntity
                .ok()
                .body(gestionarSexosService.getDetails(id));

    }

}
