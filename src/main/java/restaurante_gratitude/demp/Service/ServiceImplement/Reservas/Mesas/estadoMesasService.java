/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Reservas.Mesas;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.DTOS.Request.Reservas.Mesas.EstadoMesaDto;
import restaurante_gratitude.demp.Entidades.Reservas.EstadoMesa;
import restaurante_gratitude.demp.Repositorys.Reservas.EstadoMesaRepository;
import restaurante_gratitude.demp.Service.Reservas.Mesas.EstadoMesaGestion;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class estadoMesasService implements EstadoMesaGestion {

    private EstadoMesaRepository estadoMesaRepo;

    @Autowired
    public estadoMesasService(EstadoMesaRepository estadoMesaRepo) {
        this.estadoMesaRepo = estadoMesaRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void crearEstadoMesa(EstadoMesaDto estadoMesaDto) {

        ValidacionesGlobales.validarExistencia(
                estadoMesaRepo.findByNombre(estadoMesaDto.getNombre().toLowerCase()),
                "Error el tipo de estado de mesa no se encuentra disponible en el sistema");

        EstadoMesa estadoMesa = new EstadoMesa();
        estadoMesa.setNombre(estadoMesaDto.getNombre());
        estadoMesaRepo.save(estadoMesa);

    }

    @Override
    public List<EstadoMesaDto> obtenerEstadosDeMesa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarEstadoMesa(int id, EstadoMesaDto estadoMesaDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarEstadoMesa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
