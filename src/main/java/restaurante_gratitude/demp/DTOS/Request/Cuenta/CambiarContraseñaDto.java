/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Cuenta;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author User
 */
public class CambiarContraseñaDto {

    @NotBlank(message = "El campo email no puede quedar vacio, lo invitamos a rellenarlo.")
    private String email;

    @NotBlank(message = "El campo contraseña nueva no puede quedar vacio, le invitamos a rellenarle")
    private String contraseñaNueva;

    @NotBlank(message = "El campo contraseña actual es obligatorio no puede quedar vacio, le invitamos a rellenarlo.")
    private String contraseaActual;

    public CambiarContraseñaDto(String email, String contraseñaNueva, String contraseaActual) {
        this.email = email;
        this.contraseñaNueva = contraseñaNueva;
        this.contraseaActual = contraseaActual;
    }

    public CambiarContraseñaDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseñaNueva() {
        return contraseñaNueva;
    }

    public void setContraseñaNueva(String contraseñaNueva) {
        this.contraseñaNueva = contraseñaNueva;
    }

    public String getContraseaActual() {
        return contraseaActual;
    }

    public void setContraseaActual(String contraseaActual) {
        this.contraseaActual = contraseaActual;
    }

}
