/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Inventario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

/**
 *
 * @author luis
 */
public class StockDto {

    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            example = "2052")
    @PositiveOrZero(message = "El id debe de ser posiivo o cero 0")
    private Integer id_producto;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,
            description = "Representa la catidad maxima que un prodcuto tendrá en el inventario",
            example = "50"
    )
    @NotNull(message = "La cantidad maxima no puede quedar vacia")
    @PositiveOrZero(message = "La cantidad debe de ser posistiva o 0")
    private Integer cantidadMax;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,
            description = "Representa la catidad minima que un prodcuto tendrá en el inventario",
            example = "50"
    )
    @NotNull(message = "La cantidad minima no puede quedar vacia")
    @PositiveOrZero(message = "La cantidad debe de ser posistiva o 0")
    private Integer cantidadMin;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,
            description = "Representa la catidad inicial que un prodcuto tendrá en el inventario",
            example = "50"
    )
    @NotNull(message = "La cantidad inicial no puede quedar vacia")
    @PositiveOrZero(message = "La cantidad debe de ser posistiva o 0")
    private Integer cantidad;

    public StockDto(Integer id_producto, Integer cantidadMax, Integer cantidadMin, Integer cantidad) {
        this.id_producto = id_producto;
        this.cantidadMax = cantidadMax;
        this.cantidadMin = cantidadMin;
        this.cantidad = cantidad;
    }

    public StockDto() {
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getCantidadMax() {
        return cantidadMax;
    }

    public void setCantidadMax(Integer cantidadMax) {
        this.cantidadMax = cantidadMax;
    }

    public Integer getCantidadMin() {
        return cantidadMin;
    }

    public void setCantidadMin(Integer cantidadMin) {
        this.cantidadMin = cantidadMin;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    
    
}
