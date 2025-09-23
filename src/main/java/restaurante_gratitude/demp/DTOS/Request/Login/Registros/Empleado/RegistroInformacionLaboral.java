/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Login.Registros.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import restaurante_gratitude.demp.DTOS.Request.InformacionLaboralDto.InformacionLaboralDto;

/**
 *
 * @author User
 */
public class RegistroInformacionLaboral {

    private InformacionLaboralDto informacionLaboral;

    @Autowired
    public RegistroInformacionLaboral(InformacionLaboralDto informacionLaboral) {

        this.informacionLaboral = informacionLaboral;
    }

    public RegistroInformacionLaboral() {
    }

    public InformacionLaboralDto getInformacionLaboral() {
        return informacionLaboral;
    }

    public void setInformacionLaboral(InformacionLaboralDto informacionLaboral) {
        this.informacionLaboral = informacionLaboral;
    }

}
