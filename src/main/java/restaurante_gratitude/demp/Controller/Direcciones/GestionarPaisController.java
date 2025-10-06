/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Direcciones;

import java.util.Map;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Direccion.PaisDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Direcciones.GestionarPaisService;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/pais")
public class GestionarPaisController {

    private GestionarPaisService paisService;

    public GestionarPaisController() {
    }

    @Autowired
    public GestionarPaisController(GestionarPaisService paisService) {
        this.paisService = paisService;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> agregarPais(@Valid @RequestBody PaisDto paisDto) {

        paisService.crearPais(paisDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensaje", "Pais " + paisDto.getNombre().toUpperCase() + " ha sido creado con éxito"));

    }
}
