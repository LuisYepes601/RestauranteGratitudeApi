/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Direcciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.Service.ServiceImplement.Direcciones.AgregarCiudadesService;

/**
 *
 * @author User
 */
@RestController()
@RequestMapping("agregar")
public class AgregarCiudadescontroller {

    private AgregarCiudadesService ciudadesService;

    @Autowired
    public AgregarCiudadescontroller(AgregarCiudadesService ciudadesService) {
        this.ciudadesService = ciudadesService;
    }

    public AgregarCiudadescontroller() {
    }

    public AgregarCiudadesService getCiudadesService() {
        return ciudadesService;
    }

    public void setCiudadesService(AgregarCiudadesService ciudadesService) {
        this.ciudadesService = ciudadesService;
    }

    @GetMapping("/ciudades")
    public void agregarCiudades() {

        ciudadesService.agregarCiudades();
    }
}
