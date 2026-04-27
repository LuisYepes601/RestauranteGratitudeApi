/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.PedidoDto;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ObtenerPedidoBasicoDto {

    private Integer idPedido;
    private Date fechaPedido;
    private String tipoPedido;
    private String estadoPedido;
    private Double total;

    private Integer totalItems;

    public Integer getIdPedido() {
        return idPedido;
    }

    public ObtenerPedidoBasicoDto(Integer idPedido, Date fechaPedido, String tipoPedido, String estadoPedido, Double total, Integer totalItems) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.tipoPedido = tipoPedido;
        this.estadoPedido = estadoPedido;
        this.total = total;
        this.totalItems = totalItems;
    }

    public ObtenerPedidoBasicoDto() {
    }
    

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

}
