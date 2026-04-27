/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.RangoCalificacion;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author User
 */
@Entity
public class CalficacionProducto {

    @EmbeddedId
    private CalificacionProductoId calificacionProductoId;

    private String descripcion;

    private String evidencia;

    @ManyToOne
    @JoinColumn(name = "id_rango_calificacion")
    private RangoCalificacion rangoCalificacion;

    @ManyToOne
    @MapsId("id_usuario")
    @JoinColumn(name = "id_uusario")
    private Usuario usuario;

    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public CalficacionProducto(CalificacionProductoId calificacionProductoId, String descripcion, String evidencia, RangoCalificacion rangoCalificacion, Usuario usuario, Producto producto) {
        this.calificacionProductoId = calificacionProductoId;
        this.descripcion = descripcion;
        this.evidencia = evidencia;
        this.rangoCalificacion = rangoCalificacion;
        this.usuario = usuario;
        this.producto = producto;
    }

    public CalficacionProducto() {
    }

    public CalificacionProductoId getCalificacionProductoId() {
        return calificacionProductoId;
    }

    public void setCalificacionProductoId(CalificacionProductoId calificacionProductoId) {
        this.calificacionProductoId = calificacionProductoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }

    public RangoCalificacion getRangoCalificacion() {
        return rangoCalificacion;
    }

    public void setRangoCalificacion(RangoCalificacion rangoCalificacion) {
        this.rangoCalificacion = rangoCalificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
