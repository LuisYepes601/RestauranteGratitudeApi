/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Productos;

import jakarta.persistence.Embeddable;

/**
 *
 * @author User
 */
@Embeddable
public class ProductosFavoritosId {
    
    private int id_usuario;
    private int id_producto;

    public ProductosFavoritosId(int id_usuario, int id_producto) {
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
    }

    public ProductosFavoritosId() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id_usuario;
        hash = 89 * hash + this.id_producto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductosFavoritosId other = (ProductosFavoritosId) obj;
        if (this.id_usuario != other.id_usuario) {
            return false;
        }
        return this.id_producto == other.id_producto;
    }
    
    
}
