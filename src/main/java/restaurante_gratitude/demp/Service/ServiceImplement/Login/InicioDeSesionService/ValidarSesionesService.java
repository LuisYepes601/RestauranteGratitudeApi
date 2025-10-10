/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Login.InicioDeSesionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.SesionExpiradaException;
import restaurante_gratitude.demp.Entidades.HistorialSesiones.HistorialSesiones;
import restaurante_gratitude.demp.Repositorys.HistorialSesiones.HistorialSesionesReepository;
import restaurante_gratitude.demp.Service.Login.InicioDeSesion.ValidarSesiones;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class ValidarSesionesService implements ValidarSesiones {

    private HistorialSesionesReepository historialRepo;

    @Autowired
    public ValidarSesionesService(HistorialSesionesReepository historialRepo) {
        this.historialRepo = historialRepo;
    }

    @Override
    public void validarSesionActiva(Integer id_sesion) {

        HistorialSesiones historialSesiones = ValidacionesGlobales.obtenerSiExiste(
                historialRepo.findById(id_sesion),
                "La sesion no existe.");

        if (historialSesiones.getFechaFin() != null) {

            throw new SesionExpiradaException("La sesion actual se encuentra expirada, le "
                    + "invitamos a iniciar sesion nuevamente.");
        }

    }

}
