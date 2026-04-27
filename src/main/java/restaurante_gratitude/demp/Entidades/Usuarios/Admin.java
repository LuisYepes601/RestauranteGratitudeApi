/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;
import restaurante_gratitude.demp.Entidades.Devoluciones.Devolucion;
import restaurante_gratitude.demp.Entidades.Devoluciones.RespuestaDevolucion;
import restaurante_gratitude.demp.Entidades.Estudios.Estudio;
import restaurante_gratitude.demp.Entidades.InformacionLaboral.InformacionLaboral;
import restaurante_gratitude.demp.Entidades.PQRS.PQRS;
import restaurante_gratitude.demp.Entidades.PQRS.RespuestaPqrs;
import restaurante_gratitude.demp.Entidades.Reservas.Reserva;

/**
 *
 * @author Usuario
 */
@Entity
public class Admin extends Empleado {

    @OneToMany(mappedBy = "admin")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "admin")
    private List<RespuestaDevolucion> respuestaDevoluciones;

    @OneToMany(mappedBy = "admin")
    private List<RespuestaPqrs> respuestaPqrses;

    @OneToMany(mappedBy = "admin")
    private List<PQRS> pqrses;

    @OneToMany(mappedBy = "admin")
    private List<Devolucion> devoluciones;

    public Admin() {
    }

    public Admin(List<Reserva> reservas, List<RespuestaDevolucion> respuestaDevoluciones, List<RespuestaPqrs> respuestaPqrses, List<PQRS> pqrses, List<Devolucion> devoluciones, restaurante_gratitude.demp.Entidades.Usuarios.Usuario Usuario, InformacionLaboral informacionLaboral, List<Estudio> estudios) {
        super(Usuario, informacionLaboral, estudios);
        this.reservas = reservas;
        this.respuestaDevoluciones = respuestaDevoluciones;
        this.respuestaPqrses = respuestaPqrses;
        this.pqrses = pqrses;
        this.devoluciones = devoluciones;
    }

    public Admin(List<Reserva> reservas, List<RespuestaDevolucion> respuestaDevoluciones, List<RespuestaPqrs> respuestaPqrses, List<PQRS> pqrses, List<Devolucion> devoluciones) {
        this.reservas = reservas;
        this.respuestaDevoluciones = respuestaDevoluciones;
        this.respuestaPqrses = respuestaPqrses;
        this.pqrses = pqrses;
        this.devoluciones = devoluciones;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<RespuestaDevolucion> getRespuestaDevoluciones() {
        return respuestaDevoluciones;
    }

    public void setRespuestaDevoluciones(List<RespuestaDevolucion> respuestaDevoluciones) {
        this.respuestaDevoluciones = respuestaDevoluciones;
    }

    public List<RespuestaPqrs> getRespuestaPqrses() {
        return respuestaPqrses;
    }

    public void setRespuestaPqrses(List<RespuestaPqrs> respuestaPqrses) {
        this.respuestaPqrses = respuestaPqrses;
    }

    public List<PQRS> getPqrses() {
        return pqrses;
    }

    public void setPqrses(List<PQRS> pqrses) {
        this.pqrses = pqrses;
    }

    public List<Devolucion> getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(List<Devolucion> devoluciones) {
        this.devoluciones = devoluciones;
    }

    
    
}
