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
public class RecuperarContraseñaByIdentificacionDto {

    @NotBlank(message = "Error al recuperar contraseña."
            + "El campo de filtro por número de identificacion no puede estar vacio."
            + "Le invitamos a colocar una credencial válida. Por ejemplo:"
            + "Número de identificación: 1050276428")
    private String identificacion;

    public RecuperarContraseñaByIdentificacionDto(String identificacion) {
        this.identificacion = identificacion;
    }

    public RecuperarContraseñaByIdentificacionDto() {
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

   

}
