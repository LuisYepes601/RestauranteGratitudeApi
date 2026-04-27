/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Productos;

/**
 *
 * @author User
 */
public class EditarDatosBasicProductDto {

    private String nombre;

    private Double precio;

    private String descripcion;

    private Integer id_categoria;

    private String valor_contenido;

    private Integer id_tipo_contenido;

    private Integer id_producto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getValor_contenido() {
        return valor_contenido;
    }

    public void setValor_contenido(String valor_contenido) {
        this.valor_contenido = valor_contenido;
    }

    public Integer getId_tipo_contenido() {
        return id_tipo_contenido;
    }

    public void setId_tipo_contenido(Integer id_tipo_contenido) {
        this.id_tipo_contenido = id_tipo_contenido;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

}
