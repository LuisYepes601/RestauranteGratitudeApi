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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

/**
 *
 * @author Usuario
 */
@Entity
public class Cupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private double valor;
    
    @ManyToOne 
    @JoinColumn(name = "id_tipo_cupon")
    private TipoCupon tipoCupon;
    
    @ManyToOne
    @JoinColumn(name = "id_estado_cupon")
    private EstadoCupon estadoCupon;
    
    
    @OneToOne
    @JoinColumn(name = "id_limite_de_uso")
    private LimitesUso limitesUso;

    public Cupon(int id, String nombre, String descripcion, double valor, TipoCupon tipoCupon, EstadoCupon estadoCupon, LimitesUso limitesUso) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
        this.tipoCupon = tipoCupon;
        this.estadoCupon = estadoCupon;
        this.limitesUso = limitesUso;
    }

    public Cupon() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoCupon getTipoCupon() {
        return tipoCupon;
    }

    public void setTipoCupon(TipoCupon tipoCupon) {
        this.tipoCupon = tipoCupon;
    }

    public EstadoCupon getEstadoCupon() {
        return estadoCupon;
    }

    public void setEstadoCupon(EstadoCupon estadoCupon) {
        this.estadoCupon = estadoCupon;
    }

    public LimitesUso getLimitesUso() {
        return limitesUso;
    }

    public void setLimitesUso(LimitesUso limitesUso) {
        this.limitesUso = limitesUso;
    }
    
    
    
    

    
}
