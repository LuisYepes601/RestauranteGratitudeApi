/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Login.InicioSesionController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.Service.ServiceImplement.Login.InicioDeSesionService.CerrarSesionService;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value = "sesion")
public class CerrarSesionController {

    private CerrarSesionService cerrarSesionService;

    @Autowired
    public CerrarSesionController(CerrarSesionService cerrarSesionService) {
        this.cerrarSesionService = cerrarSesionService;
    }

    @GetMapping(value = "cerrar/{id_sesion}")
    public ResponseEntity<?> cerrarSesion(@PathVariable Integer id_sesion) {

        
        cerrarSesionService.cerrarSesion(id_sesion);
        
        return ResponseEntity.ok().build();
    }

}
