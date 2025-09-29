/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Cuenta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.Contraseña.GestionarRecuperacionContraseñasService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("recuperarContraseña/by")
public class RecuperarContraseñasController {

    private GestionarRecuperacionContraseñasService recuperacionContraseñasService;

    public RecuperarContraseñasController() {
    }

    @Autowired
    
    
    public RecuperarContraseñasController(GestionarRecuperacionContraseñasService recuperacionContraseñasService) {
        this.recuperacionContraseñasService = recuperacionContraseñasService;
    }

    public GestionarRecuperacionContraseñasService getRecuperacionContraseñasService() {
        return recuperacionContraseñasService;
    }

    public void setRecuperacionContraseñasService(GestionarRecuperacionContraseñasService recuperacionContraseñasService) {
        this.recuperacionContraseñasService = recuperacionContraseñasService;
    }

}
