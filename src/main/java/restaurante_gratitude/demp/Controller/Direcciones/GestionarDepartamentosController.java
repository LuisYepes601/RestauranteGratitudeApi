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
import restaurante_gratitude.demp.DTOS.Request.Direccion.DepartamentoDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Direcciones.GestionarDepartamentosService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/departamentos")
public class GestionarDepartamentosController {

    private GestionarDepartamentosService departamentosService;

    @Autowired
    public GestionarDepartamentosController(GestionarDepartamentosService departamentosService) {
        this.departamentosService = departamentosService;
    }

    public GestionarDepartamentosController() {
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearDepartamento(@Valid @RequestBody DepartamentoDto departamentoDto) {

        DepartamentoDto respuesta = departamentosService.agregarDepartamento(departamentoDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensaje", "Departamento: " + departamentoDto.getNombre()
                        + " ha sido agregado con exito"));

    }

}
