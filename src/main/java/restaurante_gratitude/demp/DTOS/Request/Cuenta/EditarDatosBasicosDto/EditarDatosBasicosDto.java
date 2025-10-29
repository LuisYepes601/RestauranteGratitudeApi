/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Cuenta.EditarDatosBasicosDto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
public class EditarDatosBasicosDto {

    @NotBlank(message = "El campo primer nombre no puede quedar vacio")
    private String primerNombre;

    @NotBlank(message = "El campo segundo nombre no puede quedar vacio")
    private String segundoNombre;

    @NotBlank(message = "El campo correo no puede quedar vacio")
    private String correo;

    @NotBlank(message = "El campo segundo apellido no puede quedar vacio")
    private String segundoApellido;

    @NotBlank(message = "El campo primer apellido no puede quedar vacio")
    private String primerApellido;

    @NotBlank(message = "El campo telefono no puede quedar vacio")
    private String telefono;

    @NotBlank(message = "El campo sexo no puede quedar vacio")
    private String sexo;

    @NotBlank(message = "El campo genero no puede quedar vacio")
    private String genero;

    public EditarDatosBasicosDto(String primerNombre, String segundoNombre, String correo, String segundoApellido, String primerApellido, String telefono, String sexo, String genero) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.correo = correo;
        this.segundoApellido = segundoApellido;
        this.primerApellido = primerApellido;
        this.telefono = telefono;
        this.sexo = sexo;
        this.genero = genero;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
