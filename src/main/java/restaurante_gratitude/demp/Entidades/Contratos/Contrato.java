/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Contratos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import restaurante_gratitude.demp.Entidades.InformacionLaboral.InformacionLaboral;
import restaurante_gratitude.demp.Entidades.TipoDuracion;

/**
 *
 * @author Usuario
 */
@Entity
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contrato")
    private TipoContrato tipoContrato;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_duaracion")
    private TipoDuracion tipoDuracion;

    @OneToMany(mappedBy = "contrato")
    private List<InformacionLaboral> informacionLaborales;

    public Contrato(int id, TipoContrato tipoContrato, String descripcion, TipoDuracion tipoDuracion, List<InformacionLaboral> informacionLaborales) {
        this.id = id;
        this.tipoContrato = tipoContrato;
        this.descripcion = descripcion;
        this.tipoDuracion = tipoDuracion;
        this.informacionLaborales = informacionLaborales;
    }

    public Contrato() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoDuracion getTipoDuracion() {
        return tipoDuracion;
    }

    public void setTipoDuracion(TipoDuracion tipoDuracion) {
        this.tipoDuracion = tipoDuracion;
    }

    public List<InformacionLaboral> getInformacionLaborales() {
        return informacionLaborales;
    }

    public void setInformacionLaborales(List<InformacionLaboral> informacionLaborales) {
        this.informacionLaborales = informacionLaborales;
    }
    
    

}
