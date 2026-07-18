/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Genero;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
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
import restaurante_gratitude.demp.DTOS.Request.Genero.GeneroDto;
import restaurante_gratitude.demp.DTOS.Response.Genero.generoDetailsDto;
import restaurante_gratitude.demp.Service.Genero.GestionarGeneros;

/**
 *
 * @author Usuario
 */
@Tag(name = "Generos",
        description = "Operaciones encargdas de la gestión de los generos del sistema.")
@RestController
@RequestMapping("api/v1/generos")
public class GestionarGenerosController {

    @Qualifier(value = "generoService")
    private GestionarGeneros gestionarGeneros;

    public GestionarGenerosController(GestionarGeneros gestionarGeneros) {
        this.gestionarGeneros = gestionarGeneros;
    }

    @Operation(
            description = "Operación encargada de crear generos en el sistema..",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> crearGenero(@Valid
            @RequestBody GeneroDto generoDto) {

        gestionarGeneros.crearGenero(generoDto);

        return ResponseEntity.ok(new BasicResponseDto("El genero " + generoDto.getNombre().toUpperCase() + " ha sido creado exitosamente."));
    }

    @Operation(description = "Operación encargada de obtener todos los generos creados del sistema dependiento el filtro usado..",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<GeneroDto>> getGeneros(
            @RequestParam(required = false, value = "name") String name,
            @RequestParam(required = false, value = "isDelete") Boolean isDelete,
            Pageable pageable) {

        return ResponseEntity.ok(gestionarGeneros.getGeneros(name, isDelete, pageable));
    }

    @Operation(description = "Operación encargada de actualizar datos de un genero por su id.",
            method = "PUT")
    @PutMapping("/{id}")
    public ResponseEntity<BasicResponseDto> updateGenreById(@Valid
            @PathVariable(
                    name = "id",
                    required = true) Integer id,
            @RequestBody GeneroDto generoDto) {

        gestionarGeneros.updateGenreById(id, generoDto);

        return ResponseEntity.ok(new BasicResponseDto("El genero ha sido actulizado correctamente"));
    }

    @Operation(description = "Operación encargada de eliminar un genero del sistema.",
            method = "DELETE")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(
            name = "id",
            required = true) Integer id) {

        gestionarGeneros.deleteGenreById(id);

        return ResponseEntity.ok().body("El género ha sido eliminado con exito del sistema.");

    }

    @PutMapping(value = "/{id}/activate")
    public ResponseEntity<BasicResponseDto> activateById(@PathVariable(
            name = "id",
            required = true) Integer id) {

        gestionarGeneros.activate(id);

        return ResponseEntity
                .ok(new BasicResponseDto("El genero ha sido activado correctamente.."));
    }

    @GetMapping(value = "/{id}/details")
    public ResponseEntity<generoDetailsDto> getDetailsByid(
            @PathVariable(
                    name = "id",
                    required = true) Integer id) {

        return ResponseEntity.ok(gestionarGeneros.getDeatails(id));

    }

}
