/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Response.Productos;

import java.util.Date;
import java.util.List;
import restaurante_gratitude.demp.DTOS.Response.Calificaciones.ObtenerCalificacionesDto;

/**
 *
 * @author User
 */
public class ObtnerProductoDto {

    private String nombre;

    private double precio;

    private String descripcion;

    private String imagen;

    private String categoria;

    private int id_categoria;

    private String valorContenido;

    private String tipoContenido;

    private int idTipoContenido;

    private String tipoPromocion;

    private int idtipoPromocion;

    private double valorPromocion;

    private Date fechaFin;

    private String descripcionPromocion;

    private List<ObtenerCalificacionesDto> calificacionesDtos;

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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getValorContenido() {
        return valorContenido;
    }

    public void setValorContenido(String valorContenido) {
        this.valorContenido = valorContenido;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public int getIdTipoContenido() {
        return idTipoContenido;
    }

    public void setIdTipoContenido(int idTipoContenido) {
        this.idTipoContenido = idTipoContenido;
    }

    public String getTipoPromocion() {
        return tipoPromocion;
    }

    public void setTipoPromocion(String tipoPromocion) {
        this.tipoPromocion = tipoPromocion;
    }

    public int getIdtipoPromocion() {
        return idtipoPromocion;
    }

    public void setIdtipoPromocion(int idtipoPromocion) {
        this.idtipoPromocion = idtipoPromocion;
    }

    public double getValorPromocion() {
        return valorPromocion;
    }

    public void setValorPromocion(double valorPromocion) {
        this.valorPromocion = valorPromocion;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcionPromocion() {
        return descripcionPromocion;
    }

    public void setDescripcionPromocion(String descripcionPromocion) {
        this.descripcionPromocion = descripcionPromocion;
    }

    public List<ObtenerCalificacionesDto> getCalificacionesDtos() {
        return calificacionesDtos;
    }

    public void setCalificacionesDtos(List<ObtenerCalificacionesDto> calificacionesDtos) {
        this.calificacionesDtos = calificacionesDtos;
    }

}
