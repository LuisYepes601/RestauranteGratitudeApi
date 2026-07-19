/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Productos.Contenido;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 *
 * @author Usuario
 */
public class TipoContenidoDto {

    @Schema(
            name = "nombre",
            description = "Campo que representa el nombre del tipo de contenido de un producto",
            example = "KG",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres ")
    @NotBlank(message = "El campo nombre del tipo de contenido no puede quedar vacio."
            + " Le invitamos a rellenearlo, por ejemplo, Mililitos")
    private String nombre;

    @Schema(
            description = "Descripcion deñl tipo de contenido de un producto",
            example = "Representa el peso en Kilogramos",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @Size(min = 10, max = 200, message = "La descripcion debe de tener almnenos 10 caracteres y 200 máximo. ")
    private String description;

    public TipoContenidoDto(String nombre) {
        this.nombre = nombre;
    }

    public TipoContenidoDto() {
    }

    public TipoContenidoDto(String nombre, String description) {
        this.nombre = nombre;
        this.description = description;
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
