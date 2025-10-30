/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.PedidoDto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author USUARIO
 */
public class EstadoPedidoDto {

    @NotBlank(message = "El campo nombre del estado del pedido no puede quedar vacio.")
    private String nombre;
    private Integer id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
