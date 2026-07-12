/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Rol;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 *
 * @author User
 */
public class RolDtoReq {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    @Schema(
            description = "Nombre del Rol.",
            example = "Admin",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El campo nombre del rol, no puede estar vacio, lo invitamos a "
            + "rellenarlo, por ejemplo: Nombre: Admin")
    @Size(min = 3,
            max = 20,
            message = "El nombre de rol, debe de tener al menos 3 caracteres y máximo 20")
    private String nombre;

    @Schema(description = "Descripcion del rol creado",
            example = "El rol ADMIN brinda permisos especiales.",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @Size(max = 200,
            message = "La descripcion debe de ser mas corta no debe de superar los 200 caracteres")
    private String description;

    public RolDtoReq(Integer id, String nombre, String description) {
        this.id = id;
        this.nombre = nombre;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
