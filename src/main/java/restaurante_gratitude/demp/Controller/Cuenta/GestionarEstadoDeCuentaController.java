/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Cuenta;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Cuenta.EstadoCuentaDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.Contraseña.GestionarEstadoDeCuentaService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/estadoDeCuenta")
public class GestionarEstadoDeCuentaController {

    private GestionarEstadoDeCuentaService estadoDeCuentaService;

    @Autowired
    public GestionarEstadoDeCuentaController(GestionarEstadoDeCuentaService estadoDeCuentaService) {
        this.estadoDeCuentaService = estadoDeCuentaService;
    }

    public GestionarEstadoDeCuentaController() {
    }

    public GestionarEstadoDeCuentaService getEstadoDeCuentaService() {
        return estadoDeCuentaService;
    }

    public void setEstadoDeCuentaService(GestionarEstadoDeCuentaService estadoDeCuentaService) {
        this.estadoDeCuentaService = estadoDeCuentaService;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearEstadoDeCuenta(@Valid @RequestBody EstadoCuentaDto estadoCuentaDto) {

        EstadoCuentaDto respuesta = estadoDeCuentaService.agregarEstadoDeCuenta(estadoCuentaDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensaje", "El estado de cuenta: " + estadoCuentaDto.getNombre()
                        + " , ha sido agregado con exito al sistema."));
    }

}
