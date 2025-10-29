/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Cuenta.Perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Users.UsuarioPerfilDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.DatosPersonales.ConsultarDatosBasicosService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "perfil/")
public class ConsultarDatosBasicosController {

    private ConsultarDatosBasicosService datosBasicosService;

    @Autowired
    public ConsultarDatosBasicosController(ConsultarDatosBasicosService datosBasicosService) {
        this.datosBasicosService = datosBasicosService;
    }

    @GetMapping(value = "consulrtasDatos/{id}")
    public ResponseEntity<UsuarioPerfilDto> consultarDaotosPerfil(@PathVariable Integer id) {

        return ResponseEntity.ok(datosBasicosService.consultarDatosPerfil(id));
    }

}
