/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Productos.Categoria;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
public class CategoriaProductoDto {

    @Schema(
            name = "Nombre",
            description = "Nombre de la categoria que desea crear",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El campo nombdre de categoria, no puede estar vacio, le invitamso a rrellenarlo"
            + " , por ejemplo; Nombre: Postres")
    private String nombre;

    @Schema(
            description = "Descripcion de la categoria creada",
            example = "Esta categoria representa a los productos de panaderia",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private String description;

    public CategoriaProductoDto(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaProductoDto(String nombre, String description) {
        this.nombre = nombre;
        this.description = description;
    }

    public CategoriaProductoDto() {
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
