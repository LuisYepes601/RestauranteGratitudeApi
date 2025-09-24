/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Duracion;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoYaExistenteException;
import restaurante_gratitude.demp.DTOS.Request.Duracion.TipoDuracionDto;
import restaurante_gratitude.demp.Entidades.TipoDuracion;
import restaurante_gratitude.demp.Repositorys.TipoDuracionRepository;
import restaurante_gratitude.demp.Service.Duracion.GestionarTipoDuracionInterface;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class TipoDuracionService implements GestionarTipoDuracionInterface {

    private TipoDuracionRepository tipoDuracionRepository;

    @Autowired
    public TipoDuracionService(TipoDuracionRepository tipoDuracionRepository) {
        this.tipoDuracionRepository = tipoDuracionRepository;
    }

    public TipoDuracionService() {
    }

    public TipoDuracionRepository getTipoDuracionRepository() {
        return tipoDuracionRepository;
    }

    public void setTipoDuracionRepository(TipoDuracionRepository tipoDuracionRepository) {
        this.tipoDuracionRepository = tipoDuracionRepository;
    }

    @Override
    public TipoDuracionDto agregarTipoDuracion(TipoDuracionDto tipoDuracionDto) {

        ValidacionesGlobales.validarExistencia(tipoDuracionRepository
                .findByNombre(tipoDuracionDto.getNombre()), "Agregacion cancelada. "
                + "El tipo de duracion que quiere agregar ya se encuentra en el sistema.");

        TipoDuracion tipoDuracion = new TipoDuracion();

        tipoDuracion.setNombre(tipoDuracionDto.getNombre());
        tipoDuracionRepository.save(tipoDuracion);

        return tipoDuracionDto;

    }

}
