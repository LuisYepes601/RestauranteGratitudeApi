/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Pedidos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import restaurante_gratitude.demp.Entidades.Devoluciones.Devolucion;
import restaurante_gratitude.demp.Entidades.OfertsCupons.Cupones.Cupon;
import restaurante_gratitude.demp.Entidades.OfertsCupons.Cupones.UsoCupon;
import restaurante_gratitude.demp.Entidades.RangoCalificacion.RangoCalificacion;
import restaurante_gratitude.demp.Entidades.Usuarios.Mesero;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author Usuario
 */
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaPedido;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private int totalItems;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pedido")
    private TipoPedido tipoPedido;

    @ManyToOne
    @JoinColumn(name = "id_estado_pedido")
    private EstadoPedido estadoPedido;

    @ManyToOne
    @JoinColumn(name = "id_rango_calificacion")
    private RangoCalificacion rangoCalificacion;

    @ManyToOne
    @JoinColumn(name = "id_cupon")
    private Cupon cupon;

    @OneToOne(mappedBy = "pedido")
    private Devolucion devolucion;

    @ManyToOne
    @JoinColumn(name = "id_mesero")
    private Mesero mesero;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToOne(mappedBy = "pedido")
    private UsoCupon usoCupon;

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public RangoCalificacion getRangoCalificacion() {
        return rangoCalificacion;
    }

    public void setRangoCalificacion(RangoCalificacion rangoCalificacion) {
        this.rangoCalificacion = rangoCalificacion;
    }

    public Cupon getCupon() {
        return cupon;
    }

    public void setCupon(Cupon cupon) {
        this.cupon = cupon;
    }

    public Devolucion getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Devolucion devolucion) {
        this.devolucion = devolucion;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsoCupon getUsoCupon() {
        return usoCupon;
    }

    public void setUsoCupon(UsoCupon usoCupon) {
        this.usoCupon = usoCupon;
    }

}
