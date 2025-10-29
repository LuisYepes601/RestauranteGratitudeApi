/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Promociones;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.DTOS.Request.Promociones.EstadoPromocionDto;
import restaurante_gratitude.demp.Entidades.OfertsCupons.Promociones.EstadoPromocion;
import restaurante_gratitude.demp.Repositorys.OfertasCupones.Promociones.EstadoPromocionRepository;
import restaurante_gratitude.demp.Service.Promociones.GestionarEstadoDePromociones;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarEstadoDePromocionesService implements GestionarEstadoDePromociones {

    private EstadoPromocionRepository estadoPromocionRepo;

    @Autowired
    public GestionarEstadoDePromocionesService(EstadoPromocionRepository estadoPromocionRepo) {
        this.estadoPromocionRepo = estadoPromocionRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public EstadoPromocionDto crearEstadoPromocion(EstadoPromocionDto estadoPromocionDto) {

        ValidacionesGlobales.validarExistencia(estadoPromocionRepo
                .findByNombre(estadoPromocionDto.getNombre()),
                "Error el tipo de estado de promoción ya existe lo invitamos a ingresar uno valido");

        EstadoPromocion estadoPromocion = new EstadoPromocion();

        estadoPromocion.setNombre(estadoPromocionDto.getNombre());
        estadoPromocionRepo.save(estadoPromocion);

        return estadoPromocionDto;
    }

    @Override
    public EstadoPromocionDto actualizarEstadoPromocion(Long id, EstadoPromocionDto estadoPromocionDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarEstadoPromocion(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EstadoPromocionDto obtenerEstadoPromocionPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<EstadoPromocionDto> listarEstadosPromocion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
