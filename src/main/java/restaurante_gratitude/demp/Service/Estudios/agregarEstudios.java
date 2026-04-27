/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Estudios;

import restaurante_gratitude.demp.DTOS.Request.Estudios.RegistroInformacionEducativaDto;
import restaurante_gratitude.demp.DTOS.Response.RegistroInformacionEducativaResposeDto;

/**
 *
 * @author User
 */
public interface agregarEstudios {

    public RegistroInformacionEducativaResposeDto agregarEstudios(RegistroInformacionEducativaDto informacionEducativaDto);
}
