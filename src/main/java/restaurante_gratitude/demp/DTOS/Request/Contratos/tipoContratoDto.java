/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Contratos;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
public class tipoContratoDto {

    @NotBlank(message = "El campo nombre del tipo de contrato no puede quedar vacio,"
            + " por ejemplo:, Tipo de contrato: Término fijo")
    private String nombre;

    public tipoContratoDto(String nombre) {
        this.nombre = nombre;
    }

    public tipoContratoDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
