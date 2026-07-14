/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Sexo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 *
 * @author User
 */
public class SexoDto {

    @Schema(
            name = "nombre",
            example = "Femenino",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El campo nombre de la entidad sexo, no puede quedar vacio lo invitamos a rellenarlo")
    @Size(
            min = 3,
            max = 20,
            message = "El nombre del Sexo debe de tener al menos 3 caracteres y un máximo de 20.")
    private String nombre;

    @Schema(
            name = "description",
            example = "El sexo femenino respresnta a las personas cisgeneros",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @Size(
            min = 10,
            max = 200,
            message = "La descricción del sexo debe de tener al menos 10 caracteres y máximo 200")
    private String description;

    public SexoDto(String nombre) {
        this.nombre = nombre;
    }

    public SexoDto() {
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

    public SexoDto(String nombre, String description) {
        this.nombre = nombre;
        this.description = description;
    }

}
