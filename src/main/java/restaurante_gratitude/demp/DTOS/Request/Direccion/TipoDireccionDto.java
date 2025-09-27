/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Direccion;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
public class TipoDireccionDto {

    @NotBlank(message = "El campo nombre del tipo de dirección no puede quedar vacio "
            + "le invitamos a rellenar el campo, por ejemeplo: Nombre: Casa")
    private String nombre;

    public TipoDireccionDto(String nombre) {
        this.nombre = nombre;
    }

    public TipoDireccionDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
