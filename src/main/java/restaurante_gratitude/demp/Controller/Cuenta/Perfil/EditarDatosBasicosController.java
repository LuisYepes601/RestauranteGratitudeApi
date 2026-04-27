/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Cuenta.Perfil;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Cuenta.EditarDatosBasicosDto.EditarDatosBasicosDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.DatosPersonales.EditarDatosBasicosService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "perfil/")
public class EditarDatosBasicosController {

    private EditarDatosBasicosService datosBasicosService;

    @Autowired
    public EditarDatosBasicosController(EditarDatosBasicosService datosBasicosService) {
        this.datosBasicosService = datosBasicosService;
    }

    @PutMapping(value = "editar/informacionPersonal/{id}")
    public ResponseEntity<String> editarInformacionPersonal(@Valid
            @RequestBody EditarDatosBasicosDto datosBasicosDto,
            @PathVariable Integer id) {

        return ResponseEntity.ok(datosBasicosService.editarInformacionPersonal(
                id,
                datosBasicosDto));
    }

}
