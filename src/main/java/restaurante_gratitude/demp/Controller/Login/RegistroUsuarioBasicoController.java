/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Login.RegistroUsuarioBasicoDto;
import restaurante_gratitude.demp.Service.ServiceImplement.RegistroUsuarioBasico;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/login/registro/Usuario")
public class RegistroUsuarioBasicoController {

    private RegistroUsuarioBasico usuarioBasico;

    @Autowired
    public RegistroUsuarioBasicoController(RegistroUsuarioBasico usuarioBasico) {
        this.usuarioBasico = usuarioBasico;
    }

    public RegistroUsuarioBasicoController() {
    }

    @PostMapping()
    public ResponseEntity<?> registrarUsusarioBasico(@RequestBody RegistroUsuarioBasicoDto usuarioBasico) {

        if (usuarioBasico != null) {
            this.usuarioBasico.registrar(usuarioBasico);
            return ResponseEntity.ok(usuarioBasico + "Usuario registrado con exito");
        }

        return ResponseEntity.status(HttpStatus.CREATED.NO_CONTENT).build();

    }

}
