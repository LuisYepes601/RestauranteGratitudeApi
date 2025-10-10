/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Login.InicioDeSesion;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
public class InicioSesionDto {

    @NotBlank(message = "Error al iniciciar sesión."
            + "El correo de usuario no puede estar vacio, le inivitamos a rellenar la credencial."
            + "Por ejemplo: Usuario: yepesluis006@gmail.com")
    private String correo;

    @NotBlank(message = "Error inicio de sesión."
            + "El campo contraseña no puede quedar vacio. Le invitamos a rellenarlo, por eejemplo,"
            + "Contraseña: Micontraseña123#")
    private String contrasenia;

    
    public InicioSesionDto(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public InicioSesionDto() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
