/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Pedidos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author User
 */
@Embeddable
public class DetallePedidoId implements Serializable {

    @Column(name = "id_pedido")
    private int id_pedido;

    @Column(name = "id_producto")
    private int id_producto;

    public DetallePedidoId() {
    }

    public DetallePedidoId(int id_pedido, int id_producto) {
        this.id_pedido = id_pedido;
        this.id_producto = id_producto;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id_pedido;
        hash = 29 * hash + this.id_producto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetallePedidoId other = (DetallePedidoId) obj;
        if (this.id_pedido != other.id_pedido) {
            return false;
        }
        return this.id_producto == other.id_producto;
    }

}
