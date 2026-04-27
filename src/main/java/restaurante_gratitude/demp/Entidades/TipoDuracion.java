/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import restaurante_gratitude.demp.Entidades.Contratos.Contrato;
import restaurante_gratitude.demp.Entidades.InformacionLaboral.Experiencia;

/**
 *
 * @author Usuario
 */
@Entity
public class TipoDuracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "tipoDuracion")
    List<Contrato> contratos;

    @OneToMany(mappedBy = "tipoDuracion")
    List<Experiencia> experiencias;

    public TipoDuracion(int id, String nombre, List<Contrato> contratos, List<Experiencia> experiencias) {
        this.id = id;
        this.nombre = nombre;
        this.contratos = contratos;
        this.experiencias = experiencias;
    }

    public TipoDuracion() {
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

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

}
