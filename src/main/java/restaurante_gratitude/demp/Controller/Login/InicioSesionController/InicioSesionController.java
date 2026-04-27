/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Login.InicioSesionController;

import jakarta.servlet.http.HttpServletRequest;
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
import restaurante_gratitude.demp.DTOS.Request.Login.InicioDeSesion.InicioSesionDto;
import restaurante_gratitude.demp.DTOS.Response.Login.LoginResponseDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Login.InicioDeSesionService.InicioDeSesionService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/login")
public class InicioSesionController {

    @Autowired
    private InicioDeSesionService inicioDeSesionService;

    public InicioSesionController(InicioDeSesionService inicioDeSesionService) {
        this.inicioDeSesionService = inicioDeSesionService;
    }

    public InicioSesionController() {
    }

    public InicioDeSesionService getInicioDeSesionService() {
        return inicioDeSesionService;
    }

    public void setInicioDeSesionService(InicioDeSesionService inicioDeSesionService) {
        this.inicioDeSesionService = inicioDeSesionService;
    }

    @PostMapping("/iniciarSesion")
    public ResponseEntity<?> iniciarSesion(@Valid @RequestBody InicioSesionDto inicioSesionDto,
            HttpServletRequest httpServletRequest) {

        LoginResponseDto response = inicioDeSesionService
                .iniciarSesion(inicioSesionDto, httpServletRequest);

        Map<String, Object> respuesta = new HashMap<>();

        respuesta.put("Mensaje", "El usuario: " + response.getNombre()
                + " con rol: " + response.getRol() + " ha iniciado sesion correctamente.");
        respuesta.put("credenciales", response);

        return ResponseEntity.status(HttpStatus.OK)
                .body(respuesta);
    }

}
