/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Reservas.Mesas;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Reservas.Mesas.EstadoMesaDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Reservas.Mesas.estadoMesasService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "estadoMesa")
public class EstadoMesaController {
    
    private estadoMesasService estadoMesaService;

    @Autowired
    public EstadoMesaController(estadoMesasService estadoMesaService) {
        this.estadoMesaService = estadoMesaService;
    }
    
    @PostMapping(value = "/crear")
    public ResponseEntity<Map>crearEstadoMesa(@Valid @RequestBody  EstadoMesaDto estadoMesaDto){
        
        estadoMesaService.crearEstadoMesa(estadoMesaDto);
        
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensaje","El tipo de estado de mesa: " + estadoMesaDto.getNombre() + " ha sido creado con exito en el sistema."));
    }
    
    
}
