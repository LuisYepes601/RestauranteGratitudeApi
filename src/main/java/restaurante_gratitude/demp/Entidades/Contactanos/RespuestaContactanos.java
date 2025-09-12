/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Contactanos;

import jakarta.annotation.Generated;
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

/**
 *
 * @author Usuario
 */
@Entity
public class RespuestaContactanos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_mensaje")
    private MensajeContactanos mensajeContactanos;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_envio;

    @Column(nullable = false)
    private String respuesta;

    private String telefono;

    public RespuestaContactanos(int id, MensajeContactanos mensajeContactanos, Date fecha_envio, String respuesta, String telefono) {
        this.id = id;
        this.mensajeContactanos = mensajeContactanos;
        this.fecha_envio = fecha_envio;
        this.respuesta = respuesta;
        this.telefono = telefono;
    }

    public RespuestaContactanos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MensajeContactanos getMensajeContactanos() {
        return mensajeContactanos;
    }

    public void setMensajeContactanos(MensajeContactanos mensajeContactanos) {
        this.mensajeContactanos = mensajeContactanos;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    

}
