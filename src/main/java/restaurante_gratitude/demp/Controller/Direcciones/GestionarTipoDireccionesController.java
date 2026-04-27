/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Direcciones;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Direccion.TipoDireccionDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Direcciones.GestionarTipoDireccionesService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/tipoDireccion")
public class GestionarTipoDireccionesController {

    private GestionarTipoDireccionesService gestionarTipoDireccionesService;

    @Autowired
    public GestionarTipoDireccionesController(GestionarTipoDireccionesService gestionarTipoDireccionesService) {
        this.gestionarTipoDireccionesService = gestionarTipoDireccionesService;
    }

    public GestionarTipoDireccionesController() {
    }

    public GestionarTipoDireccionesService getGestionarTipoDireccionesService() {
        return gestionarTipoDireccionesService;
    }

    public void setGestionarTipoDireccionesService(GestionarTipoDireccionesService gestionarTipoDireccionesService) {
        this.gestionarTipoDireccionesService = gestionarTipoDireccionesService;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearTipodireccion(@Valid @RequestBody TipoDireccionDto tipoDireccionDto) {

        TipoDireccionDto respuesta = gestionarTipoDireccionesService.agregarTipoDeDireccion(tipoDireccionDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensaje", "El tipo de dirección: "
                        + tipoDireccionDto.getNombre()
                        + " ha sido agregado con exito."));

    }

}
