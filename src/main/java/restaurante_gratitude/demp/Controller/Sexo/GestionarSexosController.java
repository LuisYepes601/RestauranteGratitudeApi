/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Sexo;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Sexo.SexoDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Sexo.GestionarSexosService;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/sexo")
public class GestionarSexosController {

    private GestionarSexosService gestionarSexosService;

    @Autowired
    public GestionarSexosController(GestionarSexosService gestionarSexosService) {
        this.gestionarSexosService = gestionarSexosService;
    }

    public GestionarSexosController() {
    }

    public GestionarSexosService getGestionarSexosService() {
        return gestionarSexosService;
    }

    public void setGestionarSexosService(GestionarSexosService gestionarSexosService) {
        this.gestionarSexosService = gestionarSexosService;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> agregarSexo(@Valid @RequestBody SexoDto sexoDto) {

        SexoDto respuesta = gestionarSexosService.agregarSexo(sexoDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensaje", "El sexo " + sexoDto.getNombre() + " ha sido agregado con exito."));
    }

}
