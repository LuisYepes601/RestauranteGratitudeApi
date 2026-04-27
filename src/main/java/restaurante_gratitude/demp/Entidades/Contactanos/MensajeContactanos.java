/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Contactanos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
@Entity
public class MensajeContactanos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String mensaje;

    private String telefono;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_envio;

    private boolean estado;

    @Column(nullable = false)
    private String asunto;

    @OneToMany(mappedBy = "mensajeContactanos")
    private ArrayList<RespuestaContactanos> respuestaContactanos;

    public MensajeContactanos(int id, String nombre, String correo, String mensaje, String telefono, Date fecha_envio, boolean estado, String asunto, ArrayList<RespuestaContactanos> respuestaContactanos) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.mensaje = mensaje;
        this.telefono = telefono;
        this.fecha_envio = fecha_envio;
        this.estado = estado;
        this.asunto = asunto;
        this.respuestaContactanos = respuestaContactanos;
    }

    public MensajeContactanos() {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public ArrayList<RespuestaContactanos> getRespuestaContactanos() {
        return respuestaContactanos;
    }

    public void setRespuestaContactanos(ArrayList<RespuestaContactanos> respuestaContactanos) {
        this.respuestaContactanos = respuestaContactanos;
    }
    
    

}
