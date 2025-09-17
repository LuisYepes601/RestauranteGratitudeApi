/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Genero;

/**
 *
 * @author User
 */
public class IngresarGeneroByNameDto {
    
    private String nombre;

    public IngresarGeneroByNameDto(String nombre) {
        this.nombre = nombre;
    }

    public IngresarGeneroByNameDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
