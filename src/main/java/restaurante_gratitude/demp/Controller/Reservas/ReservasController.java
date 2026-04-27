/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Reservas;

import jakarta.validation.Valid;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.Service.ServiceImplement.Reservas.ReservasGestionService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "reserva/")
public class ReservasController {

    private ReservasGestionService reservasGestionService;

    @Autowired
    public ReservasController(ReservasGestionService reservasGestionService) {
        this.reservasGestionService = reservasGestionService;
    }

    @PostMapping(value = "crear")
    public ResponseEntity<Map> crearReservar(@Valid @RequestBody ReservaDto reservaDto) {

        reservasGestionService.crearReserva(reservaDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensaje", "Querido usuario, su reservación ha sido creada con exito, paar el dia " + reservaDto.getFecha()
                        + " a la hora: " + reservaDto.getHoraInicio()));
    }

}
