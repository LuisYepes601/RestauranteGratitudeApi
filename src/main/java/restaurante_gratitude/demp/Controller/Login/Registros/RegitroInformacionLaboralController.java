/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Login.Registros;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.InformacionLaboralDto.InformacionLaboralDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Login.Registros.RegistroInformacionLaboralService;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/registro/informacion/laboral")
public class RegitroInformacionLaboralController {

    @Autowired
    private RegistroInformacionLaboralService informacionLaboralService;

    public RegitroInformacionLaboralController(RegistroInformacionLaboralService informacionLaboralService) {
        this.informacionLaboralService = informacionLaboralService;
    }

    public RegitroInformacionLaboralController() {
    }

    public RegistroInformacionLaboralService getInformacionLaboralService() {
        return informacionLaboralService;
    }

    public void setInformacionLaboralService(RegistroInformacionLaboralService informacionLaboralService) {
        this.informacionLaboralService = informacionLaboralService;
    }

    @GetMapping("/")
    public ResponseEntity<?> registrarInformacionLaboral(@Valid @RequestBody InformacionLaboralDto informacionLaboralDto) {

        InformacionLaboralDto laboralDto = informacionLaboralService.registrarInformacionLaboral(informacionLaboralDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mesaje", "Información la boral registrada con exito"));
    }

}
