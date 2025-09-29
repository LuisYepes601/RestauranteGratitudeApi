/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Cuenta;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
public class RecuperarContraseñaByGmailDto {

    @NotBlank(message = "Error al recuperar contraseña."
            + "El campo de filtro por email no puede estar vacio."
            + "Le invitamos a colocar una credencial válida.")
    private String gmail;

    public RecuperarContraseñaByGmailDto(String gmail) {
        this.gmail = gmail;
    }

    public RecuperarContraseñaByGmailDto() {
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

}
