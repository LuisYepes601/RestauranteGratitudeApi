/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Devoluciones.Reembolso;

import restaurante_gratitude.demp.Entidades.Devoluciones.Devolucion;
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
public class Reembolso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private double valor;
    
    @OneToOne
    @JoinColumn(name = "id_devolucion")
    private Devolucion devolucion;
    
    @ManyToOne
    @JoinColumn( name = "id_tipo_rembolso")
    private TipoReembolso tipoReembolso;

    public Reembolso(int id, double valor, Devolucion devolucion, TipoReembolso tipoReembolso) {
        this.id = id;
        this.valor = valor;
        this.devolucion = devolucion;
        this.tipoReembolso = tipoReembolso;
    }

    public Reembolso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Devolucion getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Devolucion devolucion) {
        this.devolucion = devolucion;
    }

    public TipoReembolso getTipoReembolso() {
        return tipoReembolso;
    }

    public void setTipoReembolso(TipoReembolso tipoReembolso) {
        this.tipoReembolso = tipoReembolso;
    }
    
    
    
}
