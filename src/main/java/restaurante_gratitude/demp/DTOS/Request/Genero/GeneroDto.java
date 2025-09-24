/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Genero;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author User
 */
public class GeneroDto {

    @NotBlank(message = "El campo nombre del genero no puede quedar vacio, lo invitamos a rellenarlo, "
            + "por ejemplo: Genero: Femenino ")
    private String nombre;

    public GeneroDto(String nombre) {
        this.nombre = nombre;
    }

    public GeneroDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
