/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Identificacion;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Identificacion.TipoIdentificacionDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Identificacion.GestionarTipoIdentificacionService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/tipoIdentificacion")
public class GestionarTipoIdentificacionesController {

    private GestionarTipoIdentificacionService gestionarTipoIdentificacionService;

    @Autowired
    public GestionarTipoIdentificacionesController(GestionarTipoIdentificacionService gestionarTipoIdentificacionService) {
        this.gestionarTipoIdentificacionService = gestionarTipoIdentificacionService;
    }

    public GestionarTipoIdentificacionesController() {
    }

    public GestionarTipoIdentificacionService getGestionarTipoIdentificacionService() {
        return gestionarTipoIdentificacionService;
    }

    public void setGestionarTipoIdentificacionService(GestionarTipoIdentificacionService gestionarTipoIdentificacionService) {
        this.gestionarTipoIdentificacionService = gestionarTipoIdentificacionService;
    }

    @PostMapping("crear")
    public ResponseEntity<?> crearTipoIdentificacion(@Valid @RequestBody TipoIdentificacionDto tipoIdentificacionDto) {

        TipoIdentificacionDto identificacionDto = gestionarTipoIdentificacionService.agregarTipoIdentificacion(tipoIdentificacionDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensaje", "El tipo de identificación: "
                        + tipoIdentificacionDto.getNombre() + " ha sido agregado exitosamente al sistema."));
    }

}
