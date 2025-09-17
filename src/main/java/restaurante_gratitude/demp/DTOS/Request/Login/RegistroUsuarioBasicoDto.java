/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Login;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import restaurante_gratitude.demp.DTOS.Request.Direccion.DireccionDto;
import restaurante_gratitude.demp.DTOS.Request.Genero.IngresarGeneroByNameDto;
import restaurante_gratitude.demp.DTOS.Request.Identificacion.IngresarIdentificacionDto;
import restaurante_gratitude.demp.DTOS.Request.Rol.RolDto;

/**
 *
 * @author User
 */
public class RegistroUsuarioBasicoDto {

    @NotBlank(message = "El primer nombre es obligatorio")
    private String primerNombre;

    private String segundoNombre;

    @NotBlank(message = "El primer apellido es obligatorio")
    private String primerApellido;

    @NotBlank(message = "El segundo apellido es obligatorio")
    private String segundoApellido;

    @Pattern(regexp = "^\\+?57?\\s?(\\d{1,4}[-\\s]?){2,3}\\d{3,4}$", message = "Teléfono inválido. Ingresa un número válido, ejemplo: 3101234567")
    private String telefono;

    @Email(message = "Correo inválido")
    private String email;

    private IngresarIdentificacionDto ingresarIdentificacionDto;
    private RolDto rolDto;
    private DireccionDto direccionDto;
    private Date fechaNacimiento;
    private String contraseña;
    private IngresarGeneroByNameDto generoByNameDto;
    private String sexo;
    private Date fechaRegistro;

    public RegistroUsuarioBasicoDto(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String telefono, String email, IngresarIdentificacionDto ingresarIdentificacionDto, RolDto rolDto, DireccionDto direccionDto, Date fechaNacimiento, String contraseña, IngresarGeneroByNameDto generoByNameDto, String sexo, Date fechaRegistro) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.email = email;
        this.ingresarIdentificacionDto = ingresarIdentificacionDto;
        this.rolDto = rolDto;
        this.direccionDto = direccionDto;
        this.fechaNacimiento = fechaNacimiento;
        this.contraseña = contraseña;
        this.generoByNameDto = generoByNameDto;
        this.sexo = sexo;
        this.fechaRegistro = new Date();
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public RolDto getRolDto() {
        return rolDto;
    }

    public void setRolDto(RolDto rolDto) {
        this.rolDto = rolDto;
    }

    public RegistroUsuarioBasicoDto() {
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

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IngresarIdentificacionDto getIngresarIdentificacionDto() {
        return ingresarIdentificacionDto;
    }

    public void setIngresarIdentificacionDto(IngresarIdentificacionDto ingresarIdentificacionDto) {
        this.ingresarIdentificacionDto = ingresarIdentificacionDto;
    }

    public DireccionDto getDireccionDto() {
        return direccionDto;
    }

    public void setDireccionDto(DireccionDto direccionDto) {
        this.direccionDto = direccionDto;
    }

    public IngresarGeneroByNameDto getGeneroByNameDto() {
        return generoByNameDto;
    }

    public void setGeneroByNameDto(IngresarGeneroByNameDto generoByNameDto) {
        this.generoByNameDto = generoByNameDto;
    }

}
