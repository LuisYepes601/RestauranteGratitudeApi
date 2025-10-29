/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Cuenta.Perfil;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Cuenta.EditarDatosBasicosDto.EditarDatosIdentificacionDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.DatosPersonales.EditarDatosIdentificacionService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "perfil/")
public class EditarDatosIdentificacionController {

    private EditarDatosIdentificacionService datosIdentificacionService;

    @Autowired
    public EditarDatosIdentificacionController(EditarDatosIdentificacionService datosIdentificacionService) {
        this.datosIdentificacionService = datosIdentificacionService;
    }

    @PutMapping(value = "editar/identificacion/{id_user}")
    public ResponseEntity editarMyIdentificacion(@Valid @PathVariable Integer id_user,
            @RequestBody EditarDatosIdentificacionDto editarDatosIdentificacionDto) {

        datosIdentificacionService.editarDatosIdentificacion(
                id_user,
                editarDatosIdentificacionDto);

        return ResponseEntity.ok().build();
    }

}
