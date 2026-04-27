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
import restaurante_gratitude.demp.Entidades.InformacionLaboral.InformacionLaboral;

/**
 *
 * @author User
 */
@Entity
public class TipoHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "tipoHorario")
    private List<InformacionLaboral> informacionLaborales;

    public TipoHorario(int id, String nombre, List<InformacionLaboral> informacionLaborales) {
        this.id = id;
        this.nombre = nombre;
        this.informacionLaborales = informacionLaborales;
    }

    public TipoHorario() {
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

    public List<InformacionLaboral> getInformacionLaborales() {
        return informacionLaborales;
    }

    public void setInformacionLaborales(List<InformacionLaboral> informacionLaborales) {
        this.informacionLaborales = informacionLaborales;
    }

}
