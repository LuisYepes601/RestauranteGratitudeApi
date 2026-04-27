/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.InformacionLaboralDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import javax.validation.Valid;

/**
 *
 * @author Usuario
 */
public class InformacionLaboralDto {

    @Valid
    @NotNull(message = "El campo experiencias no puede quedar vacio")
    private List<ExperienciaDto> experiencias;
    private int id;
    @NotBlank(message = "El campo correo de uusario no puede quedar vacio. Ingrese el correo del "
            + "uusario para asociarlo a la informacion laboral.")
    private String email;

    public InformacionLaboralDto(List<ExperienciaDto> experiencias, int id, String email) {
        this.experiencias = experiencias;
        this.id = id;
        this.email = email;
    }

    public InformacionLaboralDto(List<ExperienciaDto> experiencias) {
        this.experiencias = experiencias;
    }

    public InformacionLaboralDto() {
    }

    public List<ExperienciaDto> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<ExperienciaDto> experiencias) {
        this.experiencias = experiencias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

}
