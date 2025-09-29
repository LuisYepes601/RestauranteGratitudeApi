/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Login.Registros;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

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

    @Pattern(regexp = "^3\\d{9}$",
            message = "Teléfono inválido. Ingresa un número válido, ejemplo: 3101234567")
    @NotBlank(message = "Rellene el campo Telefono, por ejemplo, Telefono: 3008998311")
    private String telefono;

    @Email(message = "Correo inválido")
    private String email;

    @NotBlank(message = "El tipo de identificación no debe de estar vacio")
    private String tipoIdentificacion;

    @NotBlank(message = "El número de identificación no debe de estar vacio")
    private String numeroDeIdentificacion;

    @NotBlank(message = "El campo rol no puede quedar vacio. Por ejemplo Rol: usuario")
    private String rol;

    private String codigoRol;

    @NotBlank(message = "Selecciona un pais, el campo pais no puede quedar vacio")
    private String pais;

    @NotBlank(message = "Rellena el campo Barrio, por ejemplo Barrio: El prado")
    private String barrio;

    @NotBlank(message = "Rellena el campo Departamento, por ejemplo, Departamento: Bolivar")
    private String departamento;

    @NotBlank(message = "Rellena el campo Ciudad, por ejemplo, Ciudad: Bógota")
    private String ciudad;

    @NotBlank(message = "Rellena el campo Municipio, por ejemplo, Municipio: El Carmen de Bolivar")
    private String municipio;

    @NotBlank(message = "Rellena el campo Calle, por ejemplo, Calle 20 #40-52")
    private String calle;

    @NotBlank(message = "Rellena el campo Tipo de dirección, por ejemplo, Tipo de dirección: Casa")
    private String tipoDireccion;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Rellena el campo Fecha de nacimiento, por ejemplo, Fecha de nacimiento: 17/03/2004")
    private Date fechaNacimiento;

    @NotBlank(message = "Rellena el campo de Contraseña, por ejemplo, Contraseña: Juan123@")
    @Pattern(regexp = "^(?=\\S)^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "La contraseña debe tener mínimo 8 caracteres, una mayúscula, una minúscula, un número "
            + "y un carácter especial")
    private String contraseña;

    @NotBlank(message = "Escoge una opcion de genero, Por ejemplo Genero: Heterosexual")
    private String genero;

    @NotBlank(message = "Escoge una opcion de sexo, Por ejemplo Sexo: Masculino")
    private String sexo;

    private Date fechaRegistro = new Date();

    public RegistroUsuarioBasicoDto() {
    }

    @Autowired
    public RegistroUsuarioBasicoDto(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String telefono, String email, String tipoIdentificacion, String numeroDeIdentificacion, String rol, String codigoRol, String pais, String barrio, String departamento, String ciudad, String municipio, String calle, String tipoDireccion, Date fechaNacimiento, String contraseña, String genero, String sexo, Date fechaRegistro) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.email = email;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroDeIdentificacion = numeroDeIdentificacion;
        this.rol = rol;
        this.codigoRol = codigoRol;
        this.pais = pais;
        this.barrio = barrio;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.municipio = municipio;
        this.calle = calle;
        this.tipoDireccion = tipoDireccion;
        this.fechaNacimiento = fechaNacimiento;
        this.contraseña = contraseña;
        this.genero = genero;
        this.sexo = sexo;
        this.fechaRegistro = fechaRegistro;
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

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroDeIdentificacion() {
        return numeroDeIdentificacion;
    }

    public void setNumeroDeIdentificacion(String numeroDeIdentificacion) {
        this.numeroDeIdentificacion = numeroDeIdentificacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getTipoDireccion() {
        return tipoDireccion;
    }

    public void setTipoDireccion(String tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public String getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(String codigoRol) {
        this.codigoRol = codigoRol;
    }

}
