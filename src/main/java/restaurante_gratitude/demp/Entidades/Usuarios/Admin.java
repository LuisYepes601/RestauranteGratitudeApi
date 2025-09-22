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

}
