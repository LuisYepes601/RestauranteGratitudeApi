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
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import restaurante_gratitude.demp.Entidades.Usuarios.Admin;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author Usuario
 */
@Entity
public class PQRS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoPqrs estadoPqrs;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoPqrs tipoPqrs;

    @ManyToOne
    @JoinColumn(name = "id_tipo_canal")
    private TipoCanal tipoCanal;

    @Column(nullable = false)
    private String adjunto;

    @OneToMany(mappedBy = "pqrs")
    private List<RespuestaPqrs> respuestaPqrses;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Admin admin;

    public PQRS(int id, String descripcion, Date fechaCreacion, EstadoPqrs estadoPqrs, TipoPqrs tipoPqrs, TipoCanal tipoCanal, String adjunto, List<RespuestaPqrs> respuestaPqrses, Usuario usuario, Admin admin) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estadoPqrs = estadoPqrs;
        this.tipoPqrs = tipoPqrs;
        this.tipoCanal = tipoCanal;
        this.adjunto = adjunto;
        this.respuestaPqrses = respuestaPqrses;
        this.usuario = usuario;
        this.admin = admin;
    }

    public PQRS() {
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EstadoPqrs getEstadoPqrs() {
        return estadoPqrs;
    }

    public void setEstadoPqrs(EstadoPqrs estadoPqrs) {
        this.estadoPqrs = estadoPqrs;
    }

    public TipoPqrs getTipoPqrs() {
        return tipoPqrs;
    }

    public void setTipoPqrs(TipoPqrs tipoPqrs) {
        this.tipoPqrs = tipoPqrs;
    }

    public TipoCanal getTipoCanal() {
        return tipoCanal;
    }

    public void setTipoCanal(TipoCanal tipoCanal) {
        this.tipoCanal = tipoCanal;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

    public List<RespuestaPqrs> getRespuestaPqrses() {
        return respuestaPqrses;
    }

    public void setRespuestaPqrses(List<RespuestaPqrs> respuestaPqrses) {
        this.respuestaPqrses = respuestaPqrses;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    
}
