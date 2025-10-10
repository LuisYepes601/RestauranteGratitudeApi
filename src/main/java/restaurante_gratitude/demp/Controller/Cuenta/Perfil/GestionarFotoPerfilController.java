/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Cuenta.Perfil;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.Contraseña.Perfil.GestionarFotoDePerfilService;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value = "perfil/foto/")
public class GestionarFotoPerfilController {

    private GestionarFotoDePerfilService gestionarFotoDePerfilService;

    @Autowired
    public GestionarFotoPerfilController(GestionarFotoDePerfilService gestionarFotoDePerfilService) {
        this.gestionarFotoDePerfilService = gestionarFotoDePerfilService;
    }

    @PostMapping(value = "agregar/{id_user}")
    public ResponseEntity<?> agregarFotoPefil(
            @RequestParam("imagen") MultipartFile imagen,
            @PathVariable int id_user) {

        gestionarFotoDePerfilService.subirFotoDePerfil(imagen, id_user);

        Map<String, String> mensaje = new HashMap<>();

        mensaje.put("mensaje", "Foto de perfil agregada con exito");

        return ResponseEntity.ok()
                .body(this);
    }

    @DeleteMapping(value = "eliminar/{id}")
    public ResponseEntity<?> eliminarFotoDePerfil(@PathVariable int id) {

        gestionarFotoDePerfilService.eliminarFotoDePerfil(id);
        return ResponseEntity.ok().build();

    }

}
