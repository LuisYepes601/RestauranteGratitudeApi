/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Promociones;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Promociones.EstadoPromocionDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Promociones.GestionarEstadoDePromocionesService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "estadoPromocion/")
public class GestionarEstadoDePromocionesController {

    private GestionarEstadoDePromocionesService estadoDePromocionesService;

    @Autowired
    public GestionarEstadoDePromocionesController(GestionarEstadoDePromocionesService estadoDePromocionesService) {
        this.estadoDePromocionesService = estadoDePromocionesService;
    }

    @PostMapping(value = "crear/")
    ResponseEntity<Map> crearEstadoDePromocion(@Valid @RequestBody EstadoPromocionDto promocionDto) {

        EstadoPromocionDto estadoPromocionDto = estadoDePromocionesService.crearEstadoPromocion(promocionDto);

        Map<String, String> mensaje = new HashMap<>();

        mensaje.put("mensaje", "El estado de promoción " + promocionDto.getNombre() + " ha sido"
                + " agregado con exito.");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mensaje);
    }

}
