/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Reservas.Mesas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Reservas.Mesas.MesaDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Reservas.Mesas.GestionDeMesasService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "mesa/")
public class GestionDeMesasControler {

    private GestionDeMesasService mesasService;

    @Autowired
    public GestionDeMesasControler(GestionDeMesasService mesasService) {
        this.mesasService = mesasService;
    }

    @PostMapping(value = "crear")
    public ResponseEntity<Map> crearMesa(@Valid @RequestBody MesaDto mesaDto) {

        MesaDto dto = mesasService.registrarMesa(mesaDto);

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "La mesa " + mesaDto.getNumero() + " ha sido agregada con exito al sistema.");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(respuesta);

    }

    @GetMapping(value = "listar")
    public ResponseEntity<List> obtnerMesasDisponibles() {

        return ResponseEntity.ok(mesasService.listarMesasDisponibles());
    }

}
