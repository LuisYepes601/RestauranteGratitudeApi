/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Sexo;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author User
 */
public class SexoDto {

    @NotBlank(message = "El campo nombre de la entidad sexo, no puede quedar vacio lo invitamos a rellenarlo")
    private String nombre;

    public SexoDto(String nombre) {
        this.nombre = nombre;
    }

    public SexoDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
