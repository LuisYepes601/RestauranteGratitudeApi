/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Identificacion;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoYaExistenteException;
import restaurante_gratitude.demp.DTOS.Request.Identificacion.TipoIdentificacionDto;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Identificaciones.TipoIdentificacion;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.Identificaciones.TipoIdentificacionRepository;
import restaurante_gratitude.demp.Service.Identificacion.GestionarTipoIdentificacion;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarTipoIdentificacionService implements GestionarTipoIdentificacion {

    private TipoIdentificacionRepository tipoIdentificacionRepo;

    @Autowired
    public GestionarTipoIdentificacionService(TipoIdentificacionRepository tipoIdentificacionRepo) {
        this.tipoIdentificacionRepo = tipoIdentificacionRepo;
    }

    public GestionarTipoIdentificacionService() {
    }

    public TipoIdentificacionRepository getTipoIdentificacionRepo() {
        return tipoIdentificacionRepo;
    }

    public void setTipoIdentificacionRepo(TipoIdentificacionRepository tipoIdentificacionRepo) {
        this.tipoIdentificacionRepo = tipoIdentificacionRepo;
    }

    @Override
    public TipoIdentificacionDto agregarTipoIdentificacion(TipoIdentificacionDto tipoIdentificacionDto) {

        Optional<TipoIdentificacion> optional = tipoIdentificacionRepo.findByNombre(tipoIdentificacionDto.getNombre());

        if (optional.isPresent()) {

            throw new DatoYaExistenteException("El tipo de identificación: " + tipoIdentificacionDto.getNombre() + " no se "
                    + "pudo agregar por que ya existe en el sistema."
                    + " Lo(a) invitamos a ingresar un tipo de indentificación que no exista");
        }

        TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();

        tipoIdentificacion.setNombre(tipoIdentificacionDto.getNombre());
        tipoIdentificacionRepo.save(tipoIdentificacion);

        return tipoIdentificacionDto;

    }

}
