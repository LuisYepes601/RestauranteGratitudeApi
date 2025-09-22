/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.InformacionLaboralDto;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class InformacionLaboralDto {

    private List<ExperienciaDto> experiencias;
    private int id;

    public InformacionLaboralDto(List<ExperienciaDto> experiencias, int id) {
        this.experiencias = experiencias;
        this.id = id;
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
    
    
}
