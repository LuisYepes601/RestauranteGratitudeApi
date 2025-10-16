/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.ProductosFavoritos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author User
 */
public class ProductoFavoritoDtoRegistrar {

    @NotNull(message = "No se puede agregar el producto seleccionado a tus favoritos, "
            + "porque no tiene una cuenta activa en el momento. Le invistamos a iniciar sesion.")
    private Integer id_producto;

    @NotBlank(message = "No se puede agregar el producto seleccionado a tus favoritos, "
            + "porque no tiene una cuenta activa en el momento. Le invistamos a iniciar sesion.")
    private String email_user;

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }
}
