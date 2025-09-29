/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Sesiones;

import jakarta.servlet.http.HttpServletRequest;
import restaurante_gratitude.demp.Entidades.HistorialSesiones.HistorialSesiones;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author Usuario
 */
public interface GestionarSesiones {

    public HistorialSesiones agregarRegistroSesion(HttpServletRequest httpServletRequest, Usuario usuario);
}
