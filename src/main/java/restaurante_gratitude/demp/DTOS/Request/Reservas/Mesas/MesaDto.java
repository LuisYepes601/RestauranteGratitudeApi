/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Reservas.Mesas;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 *
 * @author Usuario
 */
public class MesaDto {

    private Integer id;

    @NotNull(message = "La cantidad de personas no puede quedar vacio.")
    @Positive(message = "La cantidad de persona debe de ser de almenos una.")
    private int cantidadPersonas;

    @NotNull(message = "La cantidad de personas no puede quedar vacio.")
    @Positive(message = "La cantidad de persona debe de ser de almenos una.")
    private int capacidad;

    @NotNull(message = "La cantidad número de mesa no puede quedar vacio.")
    @Positive(message = "La cantidad de número de mesa debe de ser de almenos una.")
    private int numero;

    private String urlImgMesa;

    @NotNull(message = "El estado de mesa no puede quedar vacio.")
    private Integer idEstadoMesa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getUrlImgMesa() {
        return urlImgMesa;
    }

    public void setUrlImgMesa(String urlImgMesa) {
        this.urlImgMesa = urlImgMesa;
    }

    public Integer getIdEstadoMesa() {
        return idEstadoMesa;
    }

    public void setIdEstadoMesa(Integer idEstadoMesa) {
        this.idEstadoMesa = idEstadoMesa;
    }
    
    
}
