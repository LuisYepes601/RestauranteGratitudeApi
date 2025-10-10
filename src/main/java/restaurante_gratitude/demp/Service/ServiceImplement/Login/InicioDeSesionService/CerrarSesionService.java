/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Login.InicioDeSesionService;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.Entidades.HistorialSesiones.HistorialSesiones;
import restaurante_gratitude.demp.Repositorys.HistorialSesiones.HistorialSesionesReepository;
import restaurante_gratitude.demp.Service.Login.InicioDeSesion.CerrarSesion;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class CerrarSesionService implements CerrarSesion {

    private HistorialSesionesReepository histSesionesRepo;

    @Autowired
    public CerrarSesionService(HistorialSesionesReepository histSesionesRepo) {
        this.histSesionesRepo = histSesionesRepo;
    }

    @Override
    public void cerrarSesion(Integer id) {

        HistorialSesiones historialSesiones = ValidacionesGlobales.obtenerSiExiste(
                histSesionesRepo.findById(id),
                "La sesion ingresada no existe.");
        

        historialSesiones.setFechaFin(new Date());
        histSesionesRepo.save(historialSesiones);
    }

}
