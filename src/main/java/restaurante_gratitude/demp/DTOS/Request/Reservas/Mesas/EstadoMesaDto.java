/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Reservas.Mesas;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
public class EstadoMesaDto {
    
    Integer id;
    
    @NotBlank(message = "El nombre del estado de la mesa no puede quedar vacio. ")
    String nombre;

    public EstadoMesaDto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public EstadoMesaDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
