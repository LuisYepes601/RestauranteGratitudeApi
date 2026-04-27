/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Reservas;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.Request.Reservas.TipoReservaDtoRes;
import restaurante_gratitude.demp.Entidades.Reservas.TipoReserva;
import restaurante_gratitude.demp.Repositorys.Reservas.TipoReservaRepository;
import restaurante_gratitude.demp.Service.Reservas.tipoDeReserva;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class tipoDeReservaService implements tipoDeReserva {

    private TipoReservaRepository tipoReservaRepository;

    @Autowired
    public tipoDeReservaService(TipoReservaRepository tipoReservaRepository) {
        this.tipoReservaRepository = tipoReservaRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void crearTipoDeReserva(TipoReservaDtoRes tipoReservaDto) {
        ValidacionesGlobales.validarExistencia(
                tipoReservaRepository
                        .findByNombre(tipoReservaDto.getNombre().toLowerCase()),
                "Error el tipo de reserva ya se encuentra en el sistema.");

        TipoReserva tipoReserva = new TipoReserva();

        tipoReserva.setNombre(tipoReservaDto.getNombre());
        tipoReservaRepository.save(tipoReserva);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<TipoReservaDtoRes> obtenerTiposDeReserva() {

        List<TipoReserva> tipoReservas = tipoReservaRepository.findAll();

        if (tipoReservas.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay tipos de reservas que mostrar.");
        }

        List<TipoReservaDtoRes> tipoReservaDto = new ArrayList<>();

        for (TipoReserva tipoReserva : tipoReservas) {
            TipoReservaDtoRes tipoReservaDtoRes = new TipoReservaDtoRes();

            tipoReservaDtoRes.setNombre(tipoReserva.getNombre());
            tipoReservaDtoRes.setId(tipoReserva.getId());
            tipoReservaDto.add(tipoReservaDtoRes);
        }
        return tipoReservaDto;
    }

    @Override
    public TipoReservaDtoRes obtenerTipoDeReservaPorId(Integer id) {

        TipoReserva tipoReserva = ValidacionesGlobales.obtenerSiExiste(
                tipoReservaRepository.findById(id),
                "Error el tipo de reserva no se encuentra en el sistema");

        TipoReservaDtoRes tipoReservaDtoRes = new TipoReservaDtoRes();
        tipoReservaDtoRes.setNombre(tipoReserva.getNombre());
        tipoReservaDtoRes.setId(tipoReserva.getId());
        
        return tipoReservaDtoRes;
    }

    @Override
    public void actualizarTipoDeReserva(Long id, TipoReservaDtoRes tipoReservaDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarTipoDeReserva(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
