/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Proveedores;

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
import restaurante_gratitude.demp.Entidades.Identificacion;
import restaurante_gratitude.demp.Entidades.TipoIdentificacion;

/**
 *
 * @author Usuario
 */
@Entity
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre_empresa;

    @ManyToOne
    @JoinColumn(name = "id_tipo_identificacion")
    private TipoIdentificacion tipoIdentificacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fecha_registro;

    @Column
    private String url_logo;

    @Column
    private String telefono;

    @Column(nullable = false)
    private String email;

    @Column
    private boolean estado;

    @Column(nullable = false)
    private String numero_identificacion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_proveedor")
    private TipoProveedor tipoProveedor;

    public Proveedor(int id, String nombre_empresa, TipoIdentificacion tipoIdentificacion, Date fecha_registro, String url_logo, String telefono, String email, boolean estado, String numero_identificacion, TipoProveedor tipoProveedor) {
        this.id = id;
        this.nombre_empresa = nombre_empresa;
        this.tipoIdentificacion = tipoIdentificacion;
        this.fecha_registro = fecha_registro;
        this.url_logo = url_logo;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
        this.numero_identificacion = numero_identificacion;
        this.tipoProveedor = tipoProveedor;
    }

    public Proveedor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getUrl_logo() {
        return url_logo;
    }

    public void setUrl_logo(String url_logo) {
        this.url_logo = url_logo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(String numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public TipoProveedor getTipoProveedor() {
        return tipoProveedor;
    }

    public void setTipoProveedor(TipoProveedor tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }
    
    
}
