/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Sesiones;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.DTOS.Response.IpApi.IpApiDto;
import restaurante_gratitude.demp.Entidades.HistorialSesiones.HistorialSesiones;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Service.ServiceImplement.ConcumoDeApis.IpApiService.IpApiService;
import restaurante_gratitude.demp.Service.Sesiones.GestionarSesiones;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarSesionesSevice implements GestionarSesiones {

    private IpApiService apiservice;

    @Autowired
    public GestionarSesionesSevice(IpApiService apiservice) {
        this.apiservice = apiservice;
    }

    @Override
    public HistorialSesiones agregarRegistroSesion(
            HttpServletRequest httpServletRequest,
            Usuario usuario) {

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

        String ip = httpServletRequest.getRemoteAddr();

        if ("0:0:0:0:0:0:0:1".equals(ip) || "127.0.0.1".equals(ip)) {
            ip = "8.8.8.8"; // Por ejemplo, IP pública de Google para pruebas
        }
        IpApiDto respuesta = apiservice.getDatos(ip);

        historialSesiones.setPais(respuesta.getCountry());
        historialSesiones.setDepartamento(respuesta.getRegion());
        historialSesiones.setCiudad(respuesta.getCity());

        if (respuesta.getTimezone() != null) {
            historialSesiones.setTimeZone(respuesta.getTimezone().getId());
        }

        return historialSesiones;

    }

}
