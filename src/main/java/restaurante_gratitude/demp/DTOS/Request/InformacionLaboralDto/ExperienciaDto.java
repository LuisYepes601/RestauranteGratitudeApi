/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.InformacionLaboralDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 *
 * @author Usuario
 */
public class ExperienciaDto {

    @NotBlank(message = "El campo cargo no puede quedar vacio, lo invitamos a rellenarlo,"
            + " por ejmplo: Cargo: Cocinero")
    private String cargo;

    @NotBlank(message = "El campo Nombre del jefe inmediato no puede quedar vacio, lo invitamos a rellenarlo,"
            + " por ejmplo: Jefe inmediato: Juan Perez")
    private String jefeInmediato;

    @NotBlank(message = "El campo tipo de duarción no puede quedar vacio, lo invitamos a rellenarlo,"
            + " por ejmplo: Tipo de duaración: Meses")
    private String tipoDuracion;

    @NotBlank(message = "El campo duración no puede quedar vacio, lo invitamos a rellenarlo,"
            + " por ejmplo: Duración: 12")
    private String duracion;

    @NotBlank(message = "El campo institución no puede quedar vacio, lo invitamos a rellenarlo, por ejemplo: "
            + "Institucion: Colombina S.A.S")
    private String institucion;

    @NotBlank(message = "El campo telefono de jefe inmediato, "
            + "no puede quedar vacio, lo invitamos a relllenarlo, por ejemplo: 3101234567")
    @Pattern(regexp = "^\\+?57?\\s?(\\d{1,4}[-\\s]?){2,3}\\d{3,4}$",
            message = "Teléfono inválido. Ingresa un número válido, ejemplo: 3101234567")
    private String telefono;

    @Email(message = "Correo inválido")
    private String correo;

    @NotBlank(message = "El campo ceertficado, no puede quedar vacio.")
    private String url_certificado;

    public ExperienciaDto(String cargo, String jefeInmediato, String tipoDuracion, String duracion, String institucion, String telefono, String correo, String url_certificado) {
        this.cargo = cargo;
        this.jefeInmediato = jefeInmediato;
        this.tipoDuracion = tipoDuracion;
        this.duracion = duracion;
        this.institucion = institucion;
        this.telefono = telefono;
        this.correo = correo;
        this.url_certificado = url_certificado;
    }

    public ExperienciaDto() {
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getJefeInmediato() {
        return jefeInmediato;
    }

    public void setJefeInmediato(String jefeInmediato) {
        this.jefeInmediato = jefeInmediato;
    }

    public String getTipoDuracion() {
        return tipoDuracion;
    }

    public void setTipoDuracion(String tipoDuracion) {
        this.tipoDuracion = tipoDuracion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUrl_certificado() {
        return url_certificado;
    }

    public void setUrl_certificado(String url_certificado) {
        this.url_certificado = url_certificado;
    }

}
