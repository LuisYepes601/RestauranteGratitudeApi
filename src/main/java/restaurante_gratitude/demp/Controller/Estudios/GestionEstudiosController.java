/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Estudios;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.Request.Estudios.RegistroInformacionEducativaDto;
import restaurante_gratitude.demp.DTOS.Response.RegistroInformacionEducativaResposeDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Estudio.gestionarEstudiosService;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/estudios")
public class GestionEstudiosController {

    @Autowired
    private gestionarEstudiosService estudiosService;

    public GestionEstudiosController(gestionarEstudiosService estudiosService) {
        this.estudiosService = estudiosService;

    }

    public GestionEstudiosController() {
    }

    public gestionarEstudiosService getEstudiosService() {
        return estudiosService;
    }

    public void setEstudiosService(gestionarEstudiosService estudiosService) {
        this.estudiosService = estudiosService;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> agregarEstudios(@Valid @RequestBody RegistroInformacionEducativaDto informacionEducativaDto) {

        if (informacionEducativaDto == null) {
            throw new NoDatosQueMostrarExecption("Error no ha enviado datos");
        }

        RegistroInformacionEducativaResposeDto registroInformacionEducativaDto = estudiosService.agregarEstudios(informacionEducativaDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(registroInformacionEducativaDto);

    }

}
