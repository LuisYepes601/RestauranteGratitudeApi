/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Duracion;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
public class TipoDuracionDto {

    @NotBlank(message = "El campo nombre no puede estar vacio lo invitamos a rellenar "
            + "el campo para continuar con el proceso, por ejmplo Tipo de duracion Nombre: Mes")
    private String nombre;

    public TipoDuracionDto(String nombre) {
        this.nombre = nombre;
    }

    public TipoDuracionDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
