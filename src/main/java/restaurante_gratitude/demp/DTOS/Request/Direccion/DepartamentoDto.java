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
public class DepartamentoDto {

    @NotBlank(message = "El campo nombre del departamento no puede estar vacio, "
            + "le invitamos a rellenarlo para continuar el proceso, por ejemplo nombre: Amazonas")
    private String nombre;

    public DepartamentoDto(String nombre) {
        this.nombre = nombre;
    }

    public DepartamentoDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
