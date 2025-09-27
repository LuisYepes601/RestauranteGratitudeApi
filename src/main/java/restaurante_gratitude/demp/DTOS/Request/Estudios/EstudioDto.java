/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Estudios;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

/**
 *
 * @author User
 */
public class EstudioDto {

    @NotBlank(message = "El campo nombre del estudio no puede quedar vacio, lo invitamos a "
            + "rellenarlo por ejemplo: Nombre: Ingenieria de sotfware")
    private String nombre;

    @NotBlank(message = "El campo nivel de estudio no puede quedar vacio, lo invitamos a seleccionar una opcion, por ejemplo Nivel de estudio: Pregrado")
    private String nivelEstudio;

    @NotBlank(message = "El campo nombre de institución no puede quedar vacio, lo invitamos a rellenarlo , "
            + "por ejemplo; Nombre de institución: Colombo Americano")
    private String nombreInstitucion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotNull(message = "La fecha de inicio del programa no puede que dar vacia")
    private Date fechaInicio;

    @NotBlank(message = "El campo estado de estudio no puede quedar vacio, seleccione una opcion. Por ejemplo: Estado: Certificado")
    private String estadoEstudio;

    @NotBlank(message = "El campo modalidad no puede quedar vacio, lo invitamos ")
    private String modalidad;

    public EstudioDto(String nombre, String nivelEstudio, String nombreInstitucion, Date fechaInicio, String estadoEstudio, String modalidad) {
        this.nombre = nombre;
        this.nivelEstudio = nivelEstudio;
        this.nombreInstitucion = nombreInstitucion;
        this.fechaInicio = fechaInicio;
        this.estadoEstudio = estadoEstudio;
        this.modalidad = modalidad;
    }

    public EstudioDto() {
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getEstadoEstudio() {
        return estadoEstudio;
    }

    public void setEstadoEstudio(String estadoEstudio) {
        this.estadoEstudio = estadoEstudio;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
