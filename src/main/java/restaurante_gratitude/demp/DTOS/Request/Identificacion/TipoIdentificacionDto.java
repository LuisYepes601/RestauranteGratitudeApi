/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Identificacion;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author User
 */
public class TipoIdentificacionDto {

    @NotBlank(message = "No se pudo agregar el tipo de identificación al sistema, "
            + "el campo nombre debe estar rellena, por ejempplo, Nombre: Cédula de ciudadania")
    private String nombre;

    public TipoIdentificacionDto(String nombre) {
        this.nombre = nombre;
    }

    public TipoIdentificacionDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
