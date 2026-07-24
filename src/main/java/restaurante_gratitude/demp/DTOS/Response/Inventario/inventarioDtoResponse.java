/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Response.Inventario;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author User
 */
public class inventarioDtoResponse {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer cantidad;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer cantidadMax;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer cantidadMin;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer idProducto;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String imagenProducto;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Double precio;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private boolean isDelete;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime updateAt;

    private String categoriaName;

    private Integer idCat;
    
    private String nombre;

    public inventarioDtoResponse(Integer id, Integer cantidad, Integer cantidadMax, Integer cantidadMin, Integer idProducto, String imagenProducto, Double precio, boolean isDelete, LocalDateTime updateAt, String categoriaName, Integer idCat, String nombre) {
        this.id = id;
        this.cantidad = cantidad;
        this.cantidadMax = cantidadMax;
        this.cantidadMin = cantidadMin;
        this.idProducto = idProducto;
        this.imagenProducto = imagenProducto;
        this.precio = precio;
        this.isDelete = isDelete;
        this.updateAt = updateAt;
        this.categoriaName = categoriaName;
        this.idCat = idCat;
        this.nombre = nombre;
    }

   

    public inventarioDtoResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getCategoriaName() {
        return categoriaName;
    }

    public void setCategoriaName(String categoriaName) {
        this.categoriaName = categoriaName;
    }

    public Integer getIdCat() {
        return idCat;
    }

    public void setIdCat(Integer idCat) {
        this.idCat = idCat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
