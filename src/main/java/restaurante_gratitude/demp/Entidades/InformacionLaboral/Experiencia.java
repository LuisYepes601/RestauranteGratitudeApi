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
import restaurante_gratitude.demp.Entidades.TipoDuracion;

/**
 *
 * @author Usuario
 */
@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private String jefeInmediato;

    @ManyToOne
    @JoinColumn(name = "id_tipo_duaracion")
    private TipoDuracion tipoDuracion;

    @Column(nullable = false)
    private String duracion;

    @Column(nullable = false)
    private String institucion;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String url_certificado;

    @ManyToOne
    @JoinColumn(name = "id_informacion_laboral")
    private InformacionLaboral informacionLaboral;

    public Experiencia(int id, String cargo, String jefeInmediato, TipoDuracion tipoDuracion, String duracion, String institucion, String telefono, String correo, String url_certificado, InformacionLaboral informacionLaboral) {
        this.id = id;
        this.cargo = cargo;
        this.jefeInmediato = jefeInmediato;
        this.tipoDuracion = tipoDuracion;
        this.duracion = duracion;
        this.institucion = institucion;
        this.telefono = telefono;
        this.correo = correo;
        this.url_certificado = url_certificado;
        this.informacionLaboral = informacionLaboral;
    }

    public Experiencia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getJefeInmediato() {
        return jefeInmediato;
    }

    public void setJefeInmediato(String jefeInmediato) {
        this.jefeInmediato = jefeInmediato;
    }

    public TipoDuracion getTipoDuracion() {
        return tipoDuracion;
    }

    public void setTipoDuracion(TipoDuracion tipoDuracion) {
        this.tipoDuracion = tipoDuracion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUrl_certificado() {
        return url_certificado;
    }

    public void setUrl_certificado(String url_certificado) {
        this.url_certificado = url_certificado;
    }

    public InformacionLaboral getInformacionLaboral() {
        return informacionLaboral;
    }

    public void setInformacionLaboral(InformacionLaboral informacionLaboral) {
        this.informacionLaboral = informacionLaboral;
    }
    
    
    
}
