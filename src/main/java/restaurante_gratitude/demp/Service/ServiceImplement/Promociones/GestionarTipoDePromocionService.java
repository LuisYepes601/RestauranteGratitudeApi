/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Promociones;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.Request.Promociones.TipoPromocionDto;
import restaurante_gratitude.demp.Entidades.OfertsCupons.Promociones.TipoPromocion;
import restaurante_gratitude.demp.Repositorys.OfertasCupones.Promociones.TipoPromocionRepository;
import restaurante_gratitude.demp.Service.Promociones.GestionarTipoDePromocion;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarTipoDePromocionService implements GestionarTipoDePromocion {

    private TipoPromocionRepository tipoPromRepo;

    @Autowired
    public GestionarTipoDePromocionService(TipoPromocionRepository tipoPromRepo) {
        this.tipoPromRepo = tipoPromRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public TipoPromocionDto crearTipoPromocion(TipoPromocionDto dto) {

        ValidacionesGlobales.validarExistencia(
                tipoPromRepo.findByName(dto.getNombre().trim().toLowerCase()),
                "Error el tipo de promoción ya se encuentra en el sistema.");

        TipoPromocion tipoPromocion = new TipoPromocion();

        tipoPromocion.setName(dto.getNombre());
        tipoPromRepo.save(tipoPromocion);

        return dto;

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public TipoPromocionDto obtenerTipoPromocionPorId(Integer id) {
        TipoPromocion tipodir = ValidacionesGlobales.obtenerSiExiste(
                tipoPromRepo.findById(id),
                "El tipo de promoción no se encuentra en el sistema.");

        TipoPromocionDto tipoPromocionDto = new TipoPromocionDto();

        tipoPromocionDto.setNombre(tipodir.getName());
        tipoPromocionDto.setId(tipodir.getId());

        return tipoPromocionDto;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<TipoPromocionDto> listarTiposPromocion() {

        List<TipoPromocion> tipoPromociones = tipoPromRepo.findAll();

        List<TipoPromocionDto> tipoPromocionDtos = new ArrayList<>();

        if (!tipoPromociones.isEmpty()) {

            TipoPromocionDto tipoPromocionDto = new TipoPromocionDto();

            for (TipoPromocion tipoPromocion : tipoPromociones) {

                tipoPromocionDto.setId(tipoPromocion.getId());
                tipoPromocionDto.setNombre(tipoPromocion.getName());

                tipoPromocionDtos.add(tipoPromocionDto);

            }

        } else {
            throw new NoDatosQueMostrarExecption("Error no hay tipos de promociones que mostrar.");
        }
        return tipoPromocionDtos;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public TipoPromocionDto actualizarTipoPromocion(Integer id, TipoPromocionDto dto) {

        TipoPromocion tipoPromocion = ValidacionesGlobales.obtenerSiExiste(
                tipoPromRepo.findById(id),
                "El tipo de promocion no se encuentra en el sistema, "
                + " no hay datos para actualizar.");

        tipoPromocion.setName(dto.getNombre());

        tipoPromRepo.save(tipoPromocion);

        dto.setNombre(tipoPromocion.getName());

        return dto;

    }

    @Override
    public void eliminarTipoPromocion(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
