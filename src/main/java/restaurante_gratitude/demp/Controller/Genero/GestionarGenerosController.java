/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Genero;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Genero.GeneroDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Genero.GestionarGeneroService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("genero")
public class GestionarGenerosController {

    private GestionarGeneroService gestionarGeneroService;

    @Autowired
    public GestionarGenerosController(GestionarGeneroService gestionarGeneroService) {
        this.gestionarGeneroService = gestionarGeneroService;
    }

    public GestionarGenerosController() {
    }

    public GestionarGeneroService getGestionarGeneroService() {
        return gestionarGeneroService;
    }

    public void setGestionarGeneroService(GestionarGeneroService gestionarGeneroService) {
        this.gestionarGeneroService = gestionarGeneroService;
    }

    @PostMapping("crear")
    public ResponseEntity<?> crearGenero(@Valid @RequestBody GeneroDto generoDto) {

        GeneroDto respuesta = gestionarGeneroService.crearGenero(generoDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensaje", "El genero " + generoDto.getNombre()
                        + " ha sido agregado exitosamente al sistema"));
    }

}
