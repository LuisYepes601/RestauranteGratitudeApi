/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Rol;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Rol.RolDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Rol.GestionRolesService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("rol")
public class GestionRolesController {

    private GestionRolesService gestionRolesService;

    @Autowired
    public GestionRolesController(GestionRolesService gestionRolesService) {
        this.gestionRolesService = gestionRolesService;
    }

    public GestionRolesController() {
    }

    public GestionRolesService getGestionRolesService() {
        return gestionRolesService;
    }
    

    public void setGestionRolesService(GestionRolesService gestionRolesService) {
        this.gestionRolesService = gestionRolesService;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearRol(@Valid @RequestBody RolDto rolDto) {

        RolDto respuesta = gestionRolesService.crearRol(rolDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensaje", "Rol: " + rolDto.getNombre()
                        + " ha sido agregado con exito."));
    }

}
