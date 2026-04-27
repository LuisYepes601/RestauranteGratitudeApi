/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.PedidoDto;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class PedidoDto {

    private int idProducto;
    private int cantidad;
    private Integer totalItems;
    private Integer tipo_pedido;
    private Double total;
    private Integer id_usuario;
    private List<DetallePedidoDto> detalles;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getTipo_pedido() {
        return tipo_pedido;
    }

    public void setTipo_pedido(Integer tipo_pedido) {
        this.tipo_pedido = tipo_pedido;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public List<DetallePedidoDto> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedidoDto> detalles) {
        this.detalles = detalles;
    }

}
