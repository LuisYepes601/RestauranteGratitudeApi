/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import restaurante_gratitude.demp.Entidades.Proveedores.Proveedor;

/**
 *
 * @author User
 */
@Entity
public class TipoIdentificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "tipoIdentificacion")
    private List<Identificacion> identificaciones;

    @OneToMany(mappedBy = "tipoIdentificacion")
    List<Proveedor> proveedores;

    public TipoIdentificacion(int id, String nombre, List<Identificacion> identificaciones, List<Proveedor> proveedores) {
        this.id = id;
        this.nombre = nombre;
        this.identificaciones = identificaciones;
        this.proveedores = proveedores;
    }

    public List<Identificacion> getIdentificaciones() {
        return identificaciones;
    }

    public void setIdentificaciones(List<Identificacion> identificaciones) {
        this.identificaciones = identificaciones;
    }

    public TipoIdentificacion() {
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

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

}
