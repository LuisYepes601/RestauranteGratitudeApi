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
public class MunicipioDto {

    @NotBlank(message = "El campo nombre de municipio no puede quedar vacio, le invitamos a rellenar"
            + "por ejemplo: Nombre: El Carmen de Bolivar")
    private String nombre;

    public MunicipioDto(String nombre) {
        this.nombre = nombre;
    }

    public MunicipioDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  

}
