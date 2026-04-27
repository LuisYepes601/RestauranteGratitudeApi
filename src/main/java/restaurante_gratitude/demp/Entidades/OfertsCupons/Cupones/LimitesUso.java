/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.OfertsCupons.Cupones;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 *
 * @author Usuario
 */
@Entity
public class LimitesUso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int global;

    @Column(nullable = false)
    private int porUsuario;

    @Column(nullable = false)
    private int usosAcuatles;

    @OneToOne(mappedBy = "limitesUso")
    private Cupon cupon;

    public LimitesUso(int id, int global, int porUsuario, int usosAcuatles, Cupon cupon) {
        this.id = id;
        this.global = global;
        this.porUsuario = porUsuario;
        this.usosAcuatles = usosAcuatles;
        this.cupon = cupon;
    }

    public LimitesUso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGlobal() {
        return global;
    }

    public void setGlobal(int global) {
        this.global = global;
    }

    public int getPorUsuario() {
        return porUsuario;
    }

    public void setPorUsuario(int porUsuario) {
        this.porUsuario = porUsuario;
    }

    public int getUsosAcuatles() {
        return usosAcuatles;
    }

    public void setUsosAcuatles(int usosAcuatles) {
        this.usosAcuatles = usosAcuatles;
    }

}
