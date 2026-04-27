/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Direcciones;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Direccion.MunicipioDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Direcciones.GestionarMunicipiosService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/municipios")
public class GestionarMunicipiosController {

    private GestionarMunicipiosService gestionarMunicipiosService;

    @Autowired
    public GestionarMunicipiosController(GestionarMunicipiosService gestionarMunicipiosService) {
        this.gestionarMunicipiosService = gestionarMunicipiosService;
    }

    public GestionarMunicipiosController() {
    }

    public GestionarMunicipiosService getGestionarMunicipiosService() {
        return gestionarMunicipiosService;
    }

    public void setGestionarMunicipiosService(GestionarMunicipiosService gestionarMunicipiosService) {
        this.gestionarMunicipiosService = gestionarMunicipiosService;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearMunicipio(@Valid @RequestBody MunicipioDto municipioDto) {
        gestionarMunicipiosService.crearMunicipio(municipioDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensaje", "El municipio: " + municipioDto.getNombre() + " ha sido "
                        + "agregado con exito."));
    }

}
