/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Pedidos;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import restaurante_gratitude.demp.Entidades.Productos.Producto;

/**
 *
 * @author User
 */
@Entity
public class DetallePedido {

    @EmbeddedId
    private DetallePedidoId detallePedidoId;

    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @MapsId("id_pedido")
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaPedido;

    private String decripcion;

    @Column(nullable = false)
    private double subTotal;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private double precioUnidad;

    public DetallePedido(DetallePedidoId detallePedidoId, Producto producto, Pedido pedido, Date fechaPedido, String decripcion, double subTotal, double total, int cantidad, double precioUnidad) {
        this.detallePedidoId = detallePedidoId;
        this.producto = producto;
        this.pedido = pedido;
        this.fechaPedido = fechaPedido;
        this.decripcion = decripcion;
        this.subTotal = subTotal;
        this.total = total;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
    }

    public DetallePedido() {
    }

    public DetallePedidoId getDetallePedidoId() {
        return detallePedidoId;
    }

    public void setDetallePedidoId(DetallePedidoId detallePedidoId) {
        this.detallePedidoId = detallePedidoId;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

}
