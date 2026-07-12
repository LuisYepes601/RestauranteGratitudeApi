/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Genero;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 *
 * @author User
 */
public class GeneroDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    @Schema(name = "nombre",
            example = "Female")
    @NotBlank(message = "El campo nombre del genero no puede quedar vacio, lo invitamos a rellenarlo, "
            + "por ejemplo: Genero: Femenino ")
    @Size(max = 50,
            message = "El nombre del genero no debe de superar los 50 caracteres")
    private String nombre;

    @Size(max = 200,
            message = "La descripción del genero no debe de superar los 200 caracteres")
    @Schema(example = "Este genero es el masculino y respresenta a los hombres heterosexuales",
            name = "description")
    private String description;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime createAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime updateAt;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String createBy;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private boolean delete;

    public GeneroDto(Integer id, String nombre, String description) {
        this.id = id;
        this.nombre = nombre;
        this.description = description;

    }

    public GeneroDto(Integer id, String nombre, String description, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.nombre = nombre;
        this.description = description;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public GeneroDto(Integer id, String nombre, String description, LocalDateTime createAt, LocalDateTime updateAt, String createBy) {
        this.id = id;
        this.nombre = nombre;
        this.description = description;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
    }

    public GeneroDto(Integer id, String nombre, String description, LocalDateTime createAt, LocalDateTime updateAt, String createBy, boolean delete) {
        this.id = id;
        this.nombre = nombre;
        this.description = description;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.delete = delete;
    }

    public GeneroDto(String nombre) {
        this.nombre = nombre;
    }

    public GeneroDto(String nombre, String description) {
        this.nombre = nombre;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GeneroDto() {
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

}
