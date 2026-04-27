/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.OfertsCupons.Cupones;

import jakarta.persistence.Embeddable;

/**
 *
 * @author User
 */
@Embeddable
public class UsoCuponId {
    
    private int id_cupon;
    
    private int id_usario;

    public UsoCuponId(int id_cupon, int id_usario) {
        this.id_cupon = id_cupon;
        this.id_usario = id_usario;
    }

    public UsoCuponId() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.id_cupon;
        hash = 13 * hash + this.id_usario;
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
        final UsoCuponId other = (UsoCuponId) obj;
        if (this.id_cupon != other.id_cupon) {
            return false;
        }
        return this.id_usario == other.id_usario;
    }

    public int getId_cupon() {
        return id_cupon;
    }

    public void setId_cupon(int id_cupon) {
        this.id_cupon = id_cupon;
    }

    public int getId_usario() {
        return id_usario;
    }

    public void setId_usario(int id_usario) {
        this.id_usario = id_usario;
    }
    
    
}
