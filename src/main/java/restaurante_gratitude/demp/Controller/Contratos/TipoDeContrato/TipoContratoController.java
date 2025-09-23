/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Contratos.TipoDeContrato;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Contratos.tipoContratoDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Contratos.TipoContrato.TipoContratoService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("tipo/contrato/")
public class TipoContratoController {

    private TipoContratoService contratoService;

    @Autowired
    public TipoContratoController(TipoContratoService contratoService) {
        this.contratoService = contratoService;
    }

    public TipoContratoController() {
    }

    public TipoContratoService getContratoService() {
        return contratoService;
    }

    public void setContratoService(TipoContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarTipoContrato(@Valid @RequestBody tipoContratoDto contratoDto) {

        tipoContratoDto tiContratoDto = contratoService.agregarTipoContrato(contratoDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Tipo de contrato agregado con exito", tiContratoDto));
    }

}
