/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Login.InicioDeSesion;

import jakarta.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import restaurante_gratitude.demp.DTOS.Request.Login.InicioDeSesion.InicioSesionDto;
import restaurante_gratitude.demp.DTOS.Response.Login.LoginResponseDto;

/**
 *
 * @author Usuario
 */
public interface InicicioDeSesion {

    public LoginResponseDto iniciarSesion(InicioSesionDto inicioSesionDto, HttpServletRequest httpServletRequest);
}
