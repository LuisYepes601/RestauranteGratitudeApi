/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Cuenta;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
public class EstadoCuentaDto {

    @NotBlank
    private String nombre;

    public EstadoCuentaDto() {
    }

    public EstadoCuentaDto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
