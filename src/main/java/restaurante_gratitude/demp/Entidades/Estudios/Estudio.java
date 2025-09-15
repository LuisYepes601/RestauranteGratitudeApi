/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Estudios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import restaurante_gratitude.demp.Entidades.Usuarios.Empleado;

/**
 *
 * @author Usuario
 */
@Entity
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_nivel_estudio")
    private NivelEstudio nivelEstudio;

    @Column(nullable = false)
    private String nombreInstitucion;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @ManyToOne
    @JoinColumn(name = "id_estado_estudio")
    private EstadoEstudio estadoEstudio;

    @ManyToOne
    @JoinColumn(name = "id_modalidad")
    private Modalidad modalidad;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    public Estudio(int id, NivelEstudio nivelEstudio, String nombreInstitucion, Date fechaInicio, EstadoEstudio estadoEstudio, Modalidad modalidad, Empleado empleado) {
        this.id = id;
        this.nivelEstudio = nivelEstudio;
        this.nombreInstitucion = nombreInstitucion;
        this.fechaInicio = fechaInicio;
        this.estadoEstudio = estadoEstudio;
        this.modalidad = modalidad;
        this.empleado = empleado;
    }

    public Estudio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NivelEstudio getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(NivelEstudio nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public EstadoEstudio getEstadoEstudio() {
        return estadoEstudio;
    }

    public void setEstadoEstudio(EstadoEstudio estadoEstudio) {
        this.estadoEstudio = estadoEstudio;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}
