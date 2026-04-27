/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Cuenta.Perfil;

import restaurante_gratitude.demp.DTOS.Request.Cuenta.EditarDatosBasicosDto.EditarDatosBasicosDto;

/**
 *
 * @author Usuario
 */
public interface EditarDatosBasicos {
    
    public String editarInformacionPersonal(Integer id_user, EditarDatosBasicosDto datosBasicosDto);
}
