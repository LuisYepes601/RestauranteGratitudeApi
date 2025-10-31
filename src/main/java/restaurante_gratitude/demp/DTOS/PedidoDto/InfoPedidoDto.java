/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.PedidoDto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class InfoPedidoDto {
    
    private Date fechaPedido;
    private String estado;
    private String tipo;
    private Integer total_items;
    private List<InfoProductosPedidoDto>productos;

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getTotal_items() {
        return total_items;
    }

    public void setTotal_items(Integer total_items) {
        this.total_items = total_items;
    }

    public List<InfoProductosPedidoDto> getProductos() {
        return productos;
    }

    public void setProductos(List<InfoProductosPedidoDto> productos) {
        this.productos = productos;
    }

    
    
}
