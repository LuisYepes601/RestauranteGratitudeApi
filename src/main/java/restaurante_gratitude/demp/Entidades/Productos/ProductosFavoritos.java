/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Productos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import java.time.LocalDate;
import org.hibernate.annotations.ColumnDefault;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author User
 */
@Entity
public class ProductosFavoritos {

    @EmbeddedId
    private ProductosFavoritosId productosFavoritosId;

    @ManyToOne
    @MapsId("id_usuario")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;

    @ColumnDefault(value = "0")
    private boolean isDelete;

    private LocalDate fecha_eliminacion;

    public ProductosFavoritos(ProductosFavoritosId productosFavoritosId, Usuario usuario, Producto producto, LocalDate fecha, boolean isDelete, LocalDate fecha_eliminacion) {
        this.productosFavoritosId = productosFavoritosId;
        this.usuario = usuario;
        this.producto = producto;
        this.fecha = fecha;
        this.isDelete = isDelete;
        this.fecha_eliminacion = fecha_eliminacion;
    }

    public ProductosFavoritos() {
    }

    public ProductosFavoritosId getProductosFavoritosId() {
        return productosFavoritosId;
    }

    public void setProductosFavoritosId(ProductosFavoritosId productosFavoritosId) {
        this.productosFavoritosId = productosFavoritosId;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public LocalDate getFecha_eliminacion() {
        return fecha_eliminacion;
    }

    public void setFecha_eliminacion(LocalDate fecha_eliminacion) {
        this.fecha_eliminacion = fecha_eliminacion;
    }

}
