/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Cuenta;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Cuenta.CambiarContraseñaDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.Contraseña.CambiarContraseñaService;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value = "/cambiarContraseña")
public class CambiarContraseñaController {

    private CambiarContraseñaService cambiarContraseñaService;

    @Autowired
    public CambiarContraseñaController(CambiarContraseñaService cambiarContraseñaService) {
        this.cambiarContraseñaService = cambiarContraseñaService;
    }

    public CambiarContraseñaController() {
    }

    @PostMapping("/")
    public ResponseEntity<?> cambiarContraseña(@Valid @RequestBody CambiarContraseñaDto cambiarContraseñaDto) {

        cambiarContraseñaService.cambiarContraseña(cambiarContraseñaDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensaje", "La contraseña ha sida cambiada con exito "));
    }
}
