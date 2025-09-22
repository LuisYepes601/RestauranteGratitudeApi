/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Direcciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.Service.ServiceImplement.Direcciones.ObtenerPaisesService;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/Obtener/Pais")
public class ObtenerPaisController {

    private ObtenerPaisesService paisService;

    @Autowired
    public ObtenerPaisController(ObtenerPaisesService paisService) {
        this.paisService = paisService;
    }

    public ObtenerPaisesService getPaisService() {
        return paisService;
    }

    public void setPaisService(ObtenerPaisesService paisService) {
        this.paisService = paisService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> obtenerTodosLosPaises() {

        return ResponseEntity.ok(paisService.ObtenerPaises());

    }
}
