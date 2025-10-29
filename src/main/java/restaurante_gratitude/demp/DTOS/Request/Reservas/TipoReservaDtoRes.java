/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Reservas;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
public class TipoReservaDtoRes {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    
    private int id;

    public TipoReservaDtoRes() {
    }

    public TipoReservaDtoRes(String nombre) {
        this.nombre = nombre;
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
