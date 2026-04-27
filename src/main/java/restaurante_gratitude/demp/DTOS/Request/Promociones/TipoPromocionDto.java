/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Promociones;

import jakarta.validation.constraints.NotNull;

/**
 *
 * @author User
 */
public class TipoPromocionDto {

    @NotNull(message = "El nombre de la promocion no puede quedar vacio, le invitamos a rellenarlo. ")
    private String nombre;
    
    private int id;

    public TipoPromocionDto() {
    }

    public TipoPromocionDto(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
