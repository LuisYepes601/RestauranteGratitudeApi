/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Duracion;

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
import restaurante_gratitude.demp.DTOS.Request.Duracion.TipoDuracionDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Duracion.TipoDuracionService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/tipoDeDuracion")
public class GestionarTipoDuracionController {

    private TipoDuracionService tipoDuracionService;

    public GestionarTipoDuracionController() {
    }

    @Autowired
    public GestionarTipoDuracionController(TipoDuracionService tipoDuracionService) {
        this.tipoDuracionService = tipoDuracionService;
    }

    public void setTipoDuracionService(TipoDuracionService tipoDuracionService) {
        this.tipoDuracionService = tipoDuracionService;
    }

    public TipoDuracionService getTipoDuracionService() {
        return tipoDuracionService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarTipoDuracion(@Valid @RequestBody TipoDuracionDto tipoDuracionDto) {

        TipoDuracionDto duracionDto = tipoDuracionService.agregarTipoDuracion(tipoDuracionDto);

        Map<String, String> response = new HashMap<>();
        response.put("Mensaje", "El tipo de duración " + tipoDuracionDto.getNombre() + " ha sido creado exitosamente");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);

    }

}
