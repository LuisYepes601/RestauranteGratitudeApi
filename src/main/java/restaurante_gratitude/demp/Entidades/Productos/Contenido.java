/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Productos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

/**
 *
 * @author Usuario
 */
@Entity
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String valor;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contenido")
    private TipoContenidoProducto tipo;

    @OneToOne(mappedBy = "contenido")
    private Producto producto;

    public Contenido(int id, String valor, TipoContenidoProducto tipo, Producto producto) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.producto = producto;
    }

    public Contenido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public TipoContenidoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoContenidoProducto tipo) {
        this.tipo = tipo;
    }

}
