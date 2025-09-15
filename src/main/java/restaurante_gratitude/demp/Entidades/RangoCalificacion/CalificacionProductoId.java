/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.RangoCalificacion;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author User
 */
@Embeddable
public class CalificacionProductoId implements Serializable {

    private int id_usuario;
    private int id_producto;

    public CalificacionProductoId() {
    }

    public CalificacionProductoId(int id_usuario, int id_producto) {
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id_usuario;
        hash = 71 * hash + this.id_producto;
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
        final CalificacionProductoId other = (CalificacionProductoId) obj;
        if (this.id_usuario != other.id_usuario) {
            return false;
        }
        return this.id_producto == other.id_producto;
    }

}
