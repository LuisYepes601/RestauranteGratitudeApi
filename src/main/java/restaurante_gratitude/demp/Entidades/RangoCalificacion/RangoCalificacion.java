/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.RangoCalificacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import restaurante_gratitude.demp.Entidades.Pedidos.Pedido;

/**
 *
 * @author User
 */
@Entity
public class RangoCalificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "rangoCalificacion")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "rangoCalificacion")
    private List<CalficacionProducto> calficacionProductos;

    public RangoCalificacion(int id, String nombre, List<Pedido> pedidos, List<CalficacionProducto> calficacionProductos) {
        this.id = id;
        this.nombre = nombre;
        this.pedidos = pedidos;
        this.calficacionProductos = calficacionProductos;
    }

    public RangoCalificacion() {
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<CalficacionProducto> getCalficacionProductos() {
        return calficacionProductos;
    }

    public void setCalficacionProductos(List<CalficacionProducto> calficacionProductos) {
        this.calficacionProductos = calficacionProductos;
    }

}
