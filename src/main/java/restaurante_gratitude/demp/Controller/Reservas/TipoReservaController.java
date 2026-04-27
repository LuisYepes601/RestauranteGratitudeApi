/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Reservas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Reservas.TipoReservaDtoRes;
import restaurante_gratitude.demp.Service.ServiceImplement.Reservas.tipoDeReservaService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "tipoReserva/")
public class TipoReservaController {

    private tipoDeReservaService reservaService;

    @Autowired
    public TipoReservaController(tipoDeReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping(value = "crear/")
    public ResponseEntity<Map> crearTipoExperiencia(@Valid @RequestBody TipoReservaDtoRes reservaDtoRes) {

        reservaService.crearTipoDeReserva(reservaDtoRes);

        Map<String, String> respuesta = new HashMap<>();

        respuesta.put("mensaje", "El tipo de reserva: " + reservaDtoRes.getNombre() + " ha sido agreagada, "
                + " con exito al sistema.");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(respuesta);
    }

    @GetMapping(value = "obtenerTodas/")
    public ResponseEntity<List<TipoReservaDtoRes>> obtenerTiposDeReserva() {

        List<TipoReservaDtoRes> tipos = reservaService.obtenerTiposDeReserva();

        return ResponseEntity.ok(tipos);
    }

    @GetMapping(value = "obtener/byId/{id}/")
    public ResponseEntity obtenerTipoReservaById(@PathVariable Integer id) {

        return ResponseEntity.ok(reservaService.obtenerTipoDeReservaPorId(id));
    }

}
