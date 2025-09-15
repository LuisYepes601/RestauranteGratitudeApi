/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.OfertsCupons.Cupones;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import restaurante_gratitude.demp.Entidades.Pedidos.Pedido;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author User
 */
@Entity
public class UsoCupon {
    
    @EmbeddedId
    private UsoCuponId usoCuponId;
    
    @ManyToOne
    @MapsId("id_cupon")
    @JoinColumn(name = "id_cupon")
    private Cupon cupon;
    
    @ManyToOne
    @MapsId("id_usario")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaUso;
    
    @Column(nullable = false)
    private double montoCompra;
    
    @Column(nullable = false)
    private double descuentoAplicado;
    
    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    public UsoCupon(UsoCuponId usoCuponId, Cupon cupon, Usuario usuario, Date fechaUso, double montoCompra, double descuentoAplicado, Pedido pedido) {
        this.usoCuponId = usoCuponId;
        this.cupon = cupon;
        this.usuario = usuario;
        this.fechaUso = fechaUso;
        this.montoCompra = montoCompra;
        this.descuentoAplicado = descuentoAplicado;
        this.pedido = pedido;
    }

    public UsoCupon() {
    }

    public UsoCuponId getUsoCuponId() {
        return usoCuponId;
    }

    public void setUsoCuponId(UsoCuponId usoCuponId) {
        this.usoCuponId = usoCuponId;
    }

    public Cupon getCupon() {
        return cupon;
    }

    public void setCupon(Cupon cupon) {
        this.cupon = cupon;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(Date fechaUso) {
        this.fechaUso = fechaUso;
    }

    public double getMontoCompra() {
        return montoCompra;
    }

    public void setMontoCompra(double montoCompra) {
        this.montoCompra = montoCompra;
    }

    public double getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(double descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
    
    
}
