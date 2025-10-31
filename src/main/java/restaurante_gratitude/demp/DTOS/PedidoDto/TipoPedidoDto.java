/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.PedidoDto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
public class TipoPedidoDto {

    private Integer id;

    @NotBlank(message = "El campo nombre de tipo de pedido, no puede quedar vacio.")
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
