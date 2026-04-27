/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Cuenta;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Cuenta.RecuperarContraseñaByGmailDto;
import restaurante_gratitude.demp.DTOS.Request.Cuenta.RecuperarContraseñaByIdentificacionDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.Contraseña.GestionarRecuperacionContraseñasService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("recuperarContraseña/by")
public class RecuperarContraseñasController {

    private GestionarRecuperacionContraseñasService recuperacionContraseñasService;

    public RecuperarContraseñasController() {
    }

    @Autowired
    public RecuperarContraseñasController(GestionarRecuperacionContraseñasService recuperacionContraseñasService) {
        this.recuperacionContraseñasService = recuperacionContraseñasService;
    }

    public GestionarRecuperacionContraseñasService getRecuperacionContraseñasService() {
        return recuperacionContraseñasService;
    }

    public void setRecuperacionContraseñasService(GestionarRecuperacionContraseñasService recuperacionContraseñasService) {
        this.recuperacionContraseñasService = recuperacionContraseñasService;
    }

    @PostMapping("/gmail")
    public ResponseEntity<?> recuperarContraseñaByEmail(
            @Valid @RequestBody RecuperarContraseñaByGmailDto contraseñaByGmailDto) {

        Map<String, String> respuesta = new HashMap<>();

        respuesta.put("mensaje", "La contraseña se ha cambiado con exito revise el correo: "
                + contraseñaByGmailDto.getGmail() + " e inicie sesión con la nueva contraseña.");

        recuperacionContraseñasService.recuperarContraseñaPorEmail(contraseñaByGmailDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(respuesta);
    }

    @PostMapping("/identificacion")
    public ResponseEntity<?> recuperarContraseñaByIdentificacion(
            @Valid @RequestBody RecuperarContraseñaByIdentificacionDto byIdentificacionDto) {

        Map<String, String> respuesta = new HashMap<>();

        respuesta.put("mensaje", "La contraseña se ha cambiado con exito revise el correo asociado "
                + "a esta cuenta, "
                + " e inicie sesión con la nueva contraseña.");

        recuperacionContraseñasService.recuperarContraseñaPorIdentificacion(
                byIdentificacionDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(respuesta);
    }

}
