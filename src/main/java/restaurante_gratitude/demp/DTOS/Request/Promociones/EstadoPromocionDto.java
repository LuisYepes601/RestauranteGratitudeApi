/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Promociones;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
public class EstadoPromocionDto {
    
    @NotBlank(message = "El campo nombre del estado de promocion no puede estar vacio.")
    private String nombre;

    public EstadoPromocionDto(String nombre) {
        this.nombre = nombre;
    }

    public EstadoPromocionDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
