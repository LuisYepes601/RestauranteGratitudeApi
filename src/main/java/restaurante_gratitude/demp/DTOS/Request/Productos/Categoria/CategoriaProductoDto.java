/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Productos.Categoria;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
public class CategoriaProductoDto {

    @NotBlank(message = "El campo nombdre de categoria, no puede estar vacio, le invitamso a rrellenarlo"
            + " , por ejemplo; Nombre: Postres")
    private String nombre;

    public CategoriaProductoDto(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaProductoDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
