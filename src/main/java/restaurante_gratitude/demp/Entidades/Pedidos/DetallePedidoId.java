/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Pedidos;

import jakarta.persistence.Embeddable;

/**
 *
 * @author User
 */
@Embeddable
public class DetallePedidoId {

    private int id_producto;

    private int id_usuario;

    public DetallePedidoId(int id_producto, int id_usuario) {
        this.id_producto = id_producto;
        this.id_usuario = id_usuario;
    }

    public DetallePedidoId() {
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

}
