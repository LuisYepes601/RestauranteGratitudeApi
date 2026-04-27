/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Productos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class CrearProductoDto {

    @NotBlank(message = "El nombre del producto no puede quedar vacio."
            + " Le invitamos a rellenarlo, por Ejemplo; Nombre : Hamburguesa")
    private String nombre;

    @NotNull(message = "El precio del producto no puede quedar vacio. Le invitamos a rellenar el "
            + " campo precio del producto. Po ejemplo, Precio: 12500")
    @PositiveOrZero(message = "El campo precio solo acepta positivos o cero 0")
    private double precio;

    @NotBlank(message = "La descripción del producto no puede quedar vacia."
            + " Le invitamos a colocarle una descripión a el producto.")
    private String descripcion;

    @NotBlank(message = "El campo categoria no puede quedar vacio, le invitamos a escoger una opción"
            + " , por ejemplo; Categoria: Postres")
    private String categoria;

    @NotBlank(message = "El campo valor de contenido, no puede quedar vacio, le invitamos a rellenarlo"
            + " por ejemplo: 500 ml")
    private String Valorcontenido;

    @NotBlank(message = "El campo tipo de contenido no puede quedar vacio, le invitamos"
            + " a ingresar "
            + "una opción, por ejemplo Mililitos(Ml)")
    private String tipoContenido;

    private Date fecha_ingreso = new Date();

    @NotNull(message = "El campo cantidad actual no puede quedar vacio. Le invitamos a ingresar"
            + " una cantidad inicial, por ejemplo; Cantidad actual: 15 ")
    @PositiveOrZero(message = "La cantidad ingresada debe ser cero 0 o mayor a el."
            + "Por ejemplo; Cantidad: 15")
    private int cantidad;

    @NotBlank(message = "El campo cantidad máxima no puede quedar vacio, le invitamos a que rellene el campo."
            + "Por ejemplo: Cantidad máxima = 120 ")
    @PositiveOrZero(message = "La cantidad ingresada debe ser cero 0 o mayor a el. "
            + "Por ejemplo; Cantidad: 120")
    private int cantidadMax;

    @NotBlank(message = "El campo cantidad minima no puede quedar vacio, le invitamos a que rellene el campo."
            + "Por ejemplo: Cantidad minima = 12 ")
    @PositiveOrZero(message = "La cantidad ingresada debe ser cero 0 o mayor a el. "
            + "Por ejemplo; Cantidad: 12")
    private int cantidadMin;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getValorcontenido() {
        return Valorcontenido;
    }

    public void setValorcontenido(String Valorcontenido) {
        this.Valorcontenido = Valorcontenido;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidadMax() {
        return cantidadMax;
    }

    public void setCantidadMax(int cantidadMax) {
        this.cantidadMax = cantidadMax;
    }

    public int getCantidadMin() {
        return cantidadMin;
    }

    public void setCantidadMin(int cantidadMin) {
        this.cantidadMin = cantidadMin;
    }

}
