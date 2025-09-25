/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Direcciones;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.Service.ServiceImplement.Direcciones.gestionarCiudades;

/**
 *
 * @author User
 */
@RestController()
@RequestMapping("agregar")
public class GestionarCiudadescontroller {

    private gestionarCiudades ciudadesService;

    public GestionarCiudadescontroller() {
    }

    @Autowired
    public GestionarCiudadescontroller(gestionarCiudades ciudadesService) {
        this.ciudadesService = ciudadesService;
    }

    public gestionarCiudades getCiudadesService() {
        return ciudadesService;
    }

    public void setCiudadesService(gestionarCiudades ciudadesService) {
        this.ciudadesService = ciudadesService;
    }

    @GetMapping("/ciudades/add/many")
    public ResponseEntity<?> agregarCiudades() {

        ciudadesService.agregarCiudades();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensaje", "Ciudades agaregadas con exito"));
    }
}
