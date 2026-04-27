/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Login.ValidacionesSesion;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.Service.ServiceImplement.Login.InicioDeSesionService.ValidarSesionesService;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("validarSesion")
public class ValidacionSesionController {

    private ValidarSesionesService validarSesionesService;

    @Autowired
    public ValidacionSesionController(ValidarSesionesService validarSesionesService) {
        this.validarSesionesService = validarSesionesService;
    }

    @GetMapping("/{id_sesion}")
    public ResponseEntity<?> validarSesiones(@PathVariable Integer id_sesion) {

        validarSesionesService.validarSesionActiva(id_sesion);

        return ResponseEntity.ok()
                .body(Map.of("mensaje", "La sesión actual es valida."));
    }

}
