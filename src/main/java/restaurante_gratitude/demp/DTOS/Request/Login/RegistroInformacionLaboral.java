/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Login;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import restaurante_gratitude.demp.DTOS.Request.Estudios.EstudioDto;
import restaurante_gratitude.demp.DTOS.Request.InformacionLaboralDto.InformacionLaboralDto;

/**
 *
 * @author User
 */
public class RegistroInformacionLaboral {

    private List<EstudioDto> estudios;
    private InformacionLaboralDto informacionLaboral;

    @Autowired
    public RegistroInformacionLaboral(List<EstudioDto> estudios, InformacionLaboralDto informacionLaboral) {
        this.estudios = estudios;
        this.informacionLaboral = informacionLaboral;
    }

    public RegistroInformacionLaboral() {
    }

    public List<EstudioDto> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<EstudioDto> estudios) {
        this.estudios = estudios;
    }

    public InformacionLaboralDto getInformacionLaboral() {
        return informacionLaboral;
    }

    public void setInformacionLaboral(InformacionLaboralDto informacionLaboral) {
        this.informacionLaboral = informacionLaboral;
    }

   

}
