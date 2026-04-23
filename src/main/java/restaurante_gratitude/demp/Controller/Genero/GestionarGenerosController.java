/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Genero;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Genero.GeneroDto;
import restaurante_gratitude.demp.Service.Genero.GestionarGeneros;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/genero")
public class GestionarGenerosController {

    @Qualifier(value = "generoService")
    private GestionarGeneros gestionarGeneros;

    public GestionarGenerosController(GestionarGeneros gestionarGeneros) {
        this.gestionarGeneros = gestionarGeneros;
    }

    @PostMapping("/create")
    public ResponseEntity<?> crearGenero(@Valid @RequestBody GeneroDto generoDto) {

        GeneroDto respuesta = gestionarGeneros.crearGenero(generoDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensaje", "El genero " + generoDto.getNombre()
                        + " ha sido agregado exitosamente al sistema"));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<GeneroDto>> getGeneros(@RequestParam(required = false) String name, Pageable pageable) {

        return ResponseEntity.ok(gestionarGeneros.getGeneros(name, pageable));
    }

}
