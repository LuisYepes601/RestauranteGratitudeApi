/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.PQRS;

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
import restaurante_gratitude.demp.Entidades.Usuarios.Admin;

/**
 *
 * @author Usuario
 */
@Entity
public class RespuestaPqrs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String descripcion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaRespuesta;

    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "id_pqrs")
    private PQRS pqrs;

    public RespuestaPqrs(int id, String descripcion, Date fechaRespuesta, Admin admin, PQRS pqrs) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaRespuesta = fechaRespuesta;
        this.admin = admin;
        this.pqrs = pqrs;
    }

    public RespuestaPqrs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
