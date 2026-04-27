/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.InformacionLaboral;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import restaurante_gratitude.demp.Entidades.Contratos.Contrato;
import restaurante_gratitude.demp.Entidades.TipoHorario;
import restaurante_gratitude.demp.Entidades.Usuarios.Empleado;

/**
 *
 * @author Usuario
 */
@Entity
public class InformacionLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private double salario;

    @OneToMany(mappedBy = "informacionLaboral")
    List<Experiencia> experiencias;

    @ManyToOne
    @JoinColumn(name = "id_tipo_horario")
    private TipoHorario tipoHorario;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato contrato;

    @OneToOne(mappedBy = "informacionLaboral")
    private Empleado empleado;

    public InformacionLaboral(int id, double salario, List<Experiencia> experiencias, TipoHorario tipoHorario, Contrato contrato, Empleado empleado) {
        this.id = id;
        this.salario = salario;
        this.experiencias = experiencias;
        this.tipoHorario = tipoHorario;
        this.contrato = contrato;
        this.empleado = empleado;
    }

    public InformacionLaboral() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    public TipoHorario getTipoHorario() {
        return tipoHorario;
    }

    public void setTipoHorario(TipoHorario tipoHorario) {
        this.tipoHorario = tipoHorario;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    

}
