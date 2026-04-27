/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Devoluciones.Reembolso;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Entity
public class TipoReembolso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "tipoReembolso")
    private List<Reembolso> reembolsos;

    public TipoReembolso(int id, String nombre, List<Reembolso> reembolsos) {
        this.id = id;
        this.nombre = nombre;
        this.reembolsos = reembolsos;
    }

    public TipoReembolso() {
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
 
    public List<Reembolso> getReembolsos() {
        return reembolsos;
    }

    public void setReembolsos(List<Reembolso> reembolsos) {
        this.reembolsos = reembolsos;
    }

}
