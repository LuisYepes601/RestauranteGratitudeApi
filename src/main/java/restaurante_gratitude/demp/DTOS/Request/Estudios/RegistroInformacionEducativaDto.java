/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Estudios;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

/**
 *
 * @author User
 */
public class RegistroInformacionEducativaDto {

    private List<EstudioDto> estudios;

    @NotBlank(message = "El campo email del empleado debe estar relleno")
    private String emailEmpleado;

    public RegistroInformacionEducativaDto(List<EstudioDto> estudios, String emailEmpleado) {
        this.estudios = estudios;
        this.emailEmpleado = emailEmpleado;
    }

    public RegistroInformacionEducativaDto(List<EstudioDto> estudios) {
        this.estudios = estudios;
    }

    public RegistroInformacionEducativaDto() {
    }

    public List<EstudioDto> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<EstudioDto> estudios) {
        this.estudios = estudios;
    }

    public String getEmailEmpleado() {
        return emailEmpleado;
    }

    public void setEmailEmpleado(String emailEmpleado) {
        this.emailEmpleado = emailEmpleado;
    }

}
