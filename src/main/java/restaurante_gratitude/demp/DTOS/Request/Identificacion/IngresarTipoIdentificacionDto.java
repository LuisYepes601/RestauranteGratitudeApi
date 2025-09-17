/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Identificacion;

/**
 *
 * @author User
 */
public class IngresarTipoIdentificacionDto {

    private String nombre;

    public IngresarTipoIdentificacionDto(String nombre) {
        this.nombre = nombre;
    }

    public IngresarTipoIdentificacionDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
