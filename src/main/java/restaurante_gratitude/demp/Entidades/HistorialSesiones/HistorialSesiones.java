/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.HistorialSesiones;

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
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author Usuario
 */
@Entity
public class HistorialSesiones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaFin;

    @Column(nullable = false)
    private String direcionIp;

    @Column(nullable = false)
    private String userArgent;

    @Column(nullable = false)
    private String metodo;

    @Column(nullable = false)
    private String endpoint;

    @Column(nullable = false)
    private String protocolo;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false)
    private int port;

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private String departamento;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String timeZone;

    public HistorialSesiones(int id, Usuario usuario, Date fechaInicio, Date fechaFin, String direcionIp, String userArgent, String metodo, String endpoint, String protocolo, String host, int port, String pais, String departamento, String ciudad, String timeZone) {
        this.id = id;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.direcionIp = direcionIp;
        this.userArgent = userArgent;
        this.metodo = metodo;
        this.endpoint = endpoint;
        this.protocolo = protocolo;
        this.host = host;
        this.port = port;
        this.pais = pais;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.timeZone = timeZone;
    }

    

    public HistorialSesiones() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDirecionIp() {
        return direcionIp;
    }

    public void setDirecionIp(String direcionIp) {
        this.direcionIp = direcionIp;
    }

    public String getUserArgent() {
        return userArgent;
    }

    public void setUserArgent(String userArgent) {
        this.userArgent = userArgent;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

   

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

}
