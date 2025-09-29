/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Sesiones;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.Entidades.HistorialSesiones.HistorialSesiones;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Service.Sesiones.GestionarSesiones;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarSesionesSevice implements GestionarSesiones {

    @Override
    public HistorialSesiones agregarRegistroSesion(HttpServletRequest httpServletRequest, Usuario usuario) {

        HistorialSesiones historialSesiones = new HistorialSesiones();

        historialSesiones.setFechaInicio(new Date());
        historialSesiones.setUsuario(usuario);
        historialSesiones.setDirecionIp(httpServletRequest.getRemoteAddr());
        historialSesiones.setUserArgent(httpServletRequest.getHeader("User-Agent"));
        historialSesiones.setMetodo(httpServletRequest.getMethod());
        historialSesiones.setEndpoint(httpServletRequest.getRequestURI());
        historialSesiones.setProtocolo(httpServletRequest.getProtocol());
        historialSesiones.setHost(httpServletRequest.getRemoteHost());
        historialSesiones.setPort(httpServletRequest.getRemotePort());
        historialSesiones.setPais("");
        historialSesiones.setDepartamento("");
        historialSesiones.setCiudad("");
        historialSesiones.setTimeZone("");

        return historialSesiones;

    }

}
