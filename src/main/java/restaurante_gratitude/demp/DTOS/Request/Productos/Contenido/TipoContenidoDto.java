/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Productos.Contenido;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
public class TipoContenidoDto {

    @NotBlank(message = "El campo nombre del tipo de contenido no puede quedar vacio."
            + " Le invitamos a rellenearlo, por ejemplo, Mililitos")
    private String nombre;

    public TipoContenidoDto(String nombre) {
        this.nombre = nombre;
    }

    public TipoContenidoDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
