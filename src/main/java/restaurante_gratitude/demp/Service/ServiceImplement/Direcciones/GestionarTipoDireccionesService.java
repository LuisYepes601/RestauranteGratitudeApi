/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Direcciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.DTOS.Request.Direccion.TipoDireccionDto;
import restaurante_gratitude.demp.Entidades.Direccion.TipoDireccion;
import restaurante_gratitude.demp.Repositorys.Direccion.TipoDireccionRepository;
import restaurante_gratitude.demp.Service.Direcciones.GestionarTipoDirecciones;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarTipoDireccionesService implements GestionarTipoDirecciones {

    private TipoDireccionRepository tipoDirRepo;

    @Autowired
    public GestionarTipoDireccionesService(TipoDireccionRepository tipoDirRepo) {
        this.tipoDirRepo = tipoDirRepo;
    }

    public GestionarTipoDireccionesService() {
    }

    public TipoDireccionRepository getTipoDirRepo() {
        return tipoDirRepo;
    }

    public void setTipoDirRepo(TipoDireccionRepository tipoDirRepo) {
        this.tipoDirRepo = tipoDirRepo;
    }

    @Override
    public TipoDireccionDto agregarTipoDeDireccion(TipoDireccionDto tipoDireccionDto) {

        ValidacionesGlobales.validarExistencia(tipoDirRepo
                .findByNombre(tipoDireccionDto.getNombre()),
                "El tipo de dirección: " + tipoDireccionDto.getNombre() + " no se pudo agregar"
                + " al sistema porque ya existe, le invitamos a agregar uno valido.");

        TipoDireccion tipoDireccion = new TipoDireccion();

        tipoDireccion.setNombre(tipoDireccionDto.getNombre());
        tipoDirRepo.save(tipoDireccion);

        return tipoDireccionDto;

    }

}
