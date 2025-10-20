/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Inventario;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 *
 * @author Usuario
 */
public class editarCantidadtDto {

    @NotNull(message = "Error el campo cantidad no puede quedar null")
    @Positive(message = "Error, la cantidad debe de ser mayor a cero 0.")
    private Integer cantidad;

    @NotNull(message = "Error el campo id del producto no puede quedar null")
    @Positive(message = "Error, el producto no tiene inventario")
    private Integer id_producto;

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }
}
