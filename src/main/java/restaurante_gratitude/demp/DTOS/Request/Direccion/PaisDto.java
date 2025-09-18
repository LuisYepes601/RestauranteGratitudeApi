/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Direccion;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author User
 */
public class PaisDto {

    @NotBlank(message = "Rellene el campo nombre para poder crear el pais, por ejemplo: Nombre: Colombia")
    private String nombre;

    public PaisDto(String nombre) {
        this.nombre = nombre;
    }

    public PaisDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
