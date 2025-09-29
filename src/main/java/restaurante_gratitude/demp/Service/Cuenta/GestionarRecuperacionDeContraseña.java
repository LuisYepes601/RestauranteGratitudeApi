/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Cuenta;

import restaurante_gratitude.demp.DTOS.Request.Cuenta.RecuperarContraseñaByGmailDto;
import restaurante_gratitude.demp.DTOS.Request.Cuenta.RecuperarContraseñaByIdentificacionDto;

/**
 *
 * @author Usuario
 */
public interface GestionarRecuperacionDeContraseña {

    public RecuperarContraseñaByGmailDto recuperarContraseñaPorEmail(
            RecuperarContraseñaByGmailDto contraseñaByGmailDto);

    public RecuperarContraseñaByIdentificacionDto recuperarContraseñaPorIdentificacion(
            RecuperarContraseñaByIdentificacionDto contraseñaByIdentificacionDto);
}
