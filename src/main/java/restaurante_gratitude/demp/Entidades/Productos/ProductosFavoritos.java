/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Productos;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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

    public ProductosFavoritos(ProductosFavoritosId productosFavoritosId, Usuario usuario, Producto producto) {
        this.productosFavoritosId = productosFavoritosId;
        this.usuario = usuario;
        this.producto = producto;
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
    
    
    
    
}
