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
import restaurante_gratitude.demp.DTOS.Request.Cuenta.EditarDatosBasicosDto.EditarDireccionDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.DatosPersonales.EditarDatosDireccionPerfilService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "perfil/")
public class EditarDatosDireccionPerfilController {

    private EditarDatosDireccionPerfilService datosDireccionPerfilService;

    @Autowired
    public EditarDatosDireccionPerfilController(EditarDatosDireccionPerfilService datosDireccionPerfilService) {
        this.datosDireccionPerfilService = datosDireccionPerfilService;
    }

    @PutMapping(value = "editar/direccion/{id_user}")
    public ResponseEntity editarMyDireccion(@Valid @PathVariable Integer id_user,
            @RequestBody EditarDireccionDto editarDireccionDto) {

        datosDireccionPerfilService.editarMidireccion(
                id_user,
                editarDireccionDto);

        return ResponseEntity.ok().build();

    }

}
