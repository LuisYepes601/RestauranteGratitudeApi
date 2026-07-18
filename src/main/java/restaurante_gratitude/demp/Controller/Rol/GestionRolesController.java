/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Rol;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Request.Rol.RolDtoReq;
import restaurante_gratitude.demp.DTOS.Response.Rol.DetailsRolDtoResp;
import restaurante_gratitude.demp.DTOS.Response.Rol.RolDtoresponse;
import restaurante_gratitude.demp.Service.Rol.GestionarRoles;

/**
 *
 * @author Usuario
 */
@Tag(name = "Rol",
        description = "Módulo encargado de gestionar todas las operacione sobre los roles en el sistema.")
@RestController
@RequestMapping("api/v1/rol")
public class GestionRolesController {

    private GestionarRoles gestionarRoles;

    @Autowired
    public GestionRolesController(GestionarRoles gestionarRoles) {
        this.gestionarRoles = gestionarRoles;
    }

    public GestionRolesController() {
    }

    public GestionarRoles getGestionarRoles() {
        return gestionarRoles;
    }

    public void setGestionarRoles(GestionarRoles gestionarRoles) {
        this.gestionarRoles = gestionarRoles;
    }

    @Operation(description = "Operación encargada de crear nuevos roles en el sistema.",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> crearRol(
            @Valid
            @RequestBody RolDtoReq rolDto) {

        gestionarRoles.crearRol(rolDto);

        return ResponseEntity
                .ok(new BasicResponseDto("El rol ha sido creado con exito."));
    }

    @Operation(description = "Operación encargada de mostrar todos los roles que se encuentran en el sistema.")
    @GetMapping()
    public ResponseEntity<PageResponse<RolDtoresponse>> findByName(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Boolean isDelete,
            Pageable pageable) {

        return ResponseEntity.ok(gestionarRoles.findAll(
                name,
                isDelete,
                pageable));

    }

    @Operation(
            description = "Operación encargada de obtener mas detalles de un rol..",
            method = "GET")
    @GetMapping(value = "/{id}/details")
    public ResponseEntity<DetailsRolDtoResp> getDetailsbyIdRol(@PathVariable(
            value = "id",
            required = true) Integer id) {

        return ResponseEntity.ok(gestionarRoles.getDetailsRol(id));
    }

    @Operation(
            description = "Operación encargada de actualizar datos de un rol",
            method = "POST")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateById(@PathVariable(
            value = "id",
            required = true) Integer id,
            @Valid
            @RequestBody RolDtoReq dtoReq) {

        return ResponseEntity.ok(gestionarRoles.updateByid(id, dtoReq));
    }

    @Operation(
            description = "Operación encargada de eliminar un genero del sistema a traves de su id",
            method = "DELETE")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> deleteById(@PathVariable(
            value = "id",
            required = true) Integer id) {

        return ResponseEntity.ok()
                .body(gestionarRoles.deleteById(id));

    }

    @Operation(
            description = "Operación encargada de activar un rol eliminado en el sistema.",
            method = "PUT")
    @PutMapping(value = "/{id}/activate")
    public ResponseEntity<BasicResponseDto> activateById(@PathVariable(
            value = "id",
            required = true) Integer id) {

        return ResponseEntity
                .ok()
                .body(gestionarRoles.activateById(id));
    }

}
