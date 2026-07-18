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
 * @author luis
 */
public class ProductoBasicDtoResponse {

    Integer id;

    private String nombre;

    private Double precio;

    private String imagen;

    private String categoria;

    private Integer id_categoria;

    private String valorContenido;

    private String tipoContenidos;

    private Integer idTipoContenido;

    private String tipoPromocion;

    private Integer idtipoPromocion;

    private double valorPromocion;

    private Date fechaFin;

    private Double promedioCalificacion;

    private boolean isFavorite;

    private Long totalReseñas;

    public ProductoBasicDtoResponse(Integer id, String nombre, Double precio, String imagen, String categoria, Integer id_categoria, String valorContenido, String tipoContenidos, Integer idTipoContenido, String tipoPromocion, Integer idtipoPromocion, double valorPromocion, Date fechaFin, Double promedioCalificacion, boolean isFavorite, Long totalReseñas) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.categoria = categoria;
        this.id_categoria = id_categoria;
        this.valorContenido = valorContenido;
        this.tipoContenidos = tipoContenidos;
        this.idTipoContenido = idTipoContenido;
        this.tipoPromocion = tipoPromocion;
        this.idtipoPromocion = idtipoPromocion;
        this.valorPromocion = valorPromocion;
        this.fechaFin = fechaFin;
        this.promedioCalificacion = promedioCalificacion;
        this.isFavorite = isFavorite;
        this.totalReseñas = totalReseñas;
    }

  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getValorContenido() {
        return valorContenido;
    }

    public void setValorContenido(String valorContenido) {
        this.valorContenido = valorContenido;
    }

    public String getTipoContenidos() {
        return tipoContenidos;
    }

    public void setTipoContenidos(String tipoContenidos) {
        this.tipoContenidos = tipoContenidos;
    }

    public Integer getIdTipoContenido() {
        return idTipoContenido;
    }

    public void setIdTipoContenido(Integer idTipoContenido) {
        this.idTipoContenido = idTipoContenido;
    }

    public String getTipoPromocion() {
        return tipoPromocion;
    }

    public void setTipoPromocion(String tipoPromocion) {
        this.tipoPromocion = tipoPromocion;
    }

    public Integer getIdtipoPromocion() {
        return idtipoPromocion;
    }

    public void setIdtipoPromocion(Integer idtipoPromocion) {
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

    public double getPromedioCalificacion() {
        return promedioCalificacion;
    }

    public void setPromedioCalificacion(double promedioCalificacion) {
        this.promedioCalificacion = promedioCalificacion;
    }

    public boolean isIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
  
    
    

}
