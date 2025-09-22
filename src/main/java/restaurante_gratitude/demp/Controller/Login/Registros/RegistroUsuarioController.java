/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Login.Registros;

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
import restaurante_gratitude.demp.DTOS.Request.Login.Empleado.ResgistroEmpleadoDto;
import restaurante_gratitude.demp.DTOS.Request.Login.RegistroUsuarioBasicoDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Login.Registros.RegistroEmpleadoService;
import restaurante_gratitude.demp.Service.ServiceImplement.Login.Registros.RegistroUsuarioBasico;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/login/registro/usuario")
public class RegistroUsuarioController {

    private RegistroUsuarioBasico usuarioBasico;
    private RegistroEmpleadoService empleadoService;

    @Autowired
    public RegistroUsuarioController(RegistroUsuarioBasico usuarioBasico, RegistroEmpleadoService empleadoService) {
        this.usuarioBasico = usuarioBasico;
        this.empleadoService = empleadoService;
    }

    public RegistroUsuarioController() {
    }

    @PostMapping("/basico")
    public ResponseEntity<?> registrarUsuarioBasico(@Valid @RequestBody RegistroUsuarioBasicoDto usuarioBasico) {

        this.usuarioBasico.registrar(usuarioBasico);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensaje:", "Usuario " + usuarioBasico.getPrimerNombre() + " registrado con exito"));

    }

    @PostMapping("/empleado")
    public ResponseEntity<?> registrarEmpleado(@Valid @RequestBody ResgistroEmpleadoDto empleadoDto) {

        ResgistroEmpleadoDto resgistroEmpleadoDto = new ResgistroEmpleadoDto();

        resgistroEmpleadoDto = empleadoService.registrarEmpleado(empleadoDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("Mensaje", "Usuario con rol " + resgistroEmpleadoDto.getUsuarioBasicoDto().getRol() + " ha sido registrado exitosamente"));

    }

}
