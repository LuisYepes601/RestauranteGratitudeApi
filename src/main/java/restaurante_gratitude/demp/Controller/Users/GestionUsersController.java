/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Users.UsuarioBasicDTO;
import restaurante_gratitude.demp.Service.ServiceImplement.Users.GestionUsersService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "user/")
public class GestionUsersController {

    private GestionUsersService gestionUsersService;

    @Autowired
    public GestionUsersController(GestionUsersService gestionUsersService) {
        this.gestionUsersService = gestionUsersService;
    }

    @GetMapping(value = "obtener/byId/{id}")
    public ResponseEntity<UsuarioBasicDTO> obtenerUsuariById(@PathVariable Integer id) {

        return ResponseEntity.ok(gestionUsersService.obtnerUsuarioByID(id));
    }

}
