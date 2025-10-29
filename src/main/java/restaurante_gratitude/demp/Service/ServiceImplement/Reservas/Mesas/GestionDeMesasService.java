/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Reservas.Mesas;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.Request.Reservas.Mesas.MesaDto;
import restaurante_gratitude.demp.Entidades.Reservas.EstadoMesa;
import restaurante_gratitude.demp.Entidades.Reservas.Mesa;
import restaurante_gratitude.demp.Repositorys.Reservas.EstadoMesaRepository;
import restaurante_gratitude.demp.Repositorys.Reservas.MesaRepository;
import restaurante_gratitude.demp.Service.Reservas.Mesas.GestionDeMesas;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionDeMesasService implements GestionDeMesas {

    private MesaRepository mesaRepo;
    private EstadoMesaRepository estadoMesaRepo;

    @Autowired
    public GestionDeMesasService(MesaRepository mesaRepo, EstadoMesaRepository estadoMesaRepo) {
        this.mesaRepo = mesaRepo;
        this.estadoMesaRepo = estadoMesaRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public MesaDto registrarMesa(MesaDto mesaDto) {

        ValidacionesGlobales.validarExistencia(mesaRepo.findByNumero(
                mesaDto.getNumero()),
                "Error al agregar una mesa, la mesa con número: " + mesaDto.getNumero() + " ya existe en el sistema.");

        Mesa mesa = new Mesa();

        mesa.setCapacidad(mesaDto.getCapacidad());
        mesa.setNumero(mesaDto.getNumero());
        mesa.setCantidadPersonas(mesaDto.getCantidadPersonas());

        EstadoMesa estadoMesa = ValidacionesGlobales.obtenerSiExiste(
                estadoMesaRepo.findById(mesaDto.getIdEstadoMesa()),
                "El estado de mesa no existe en el sistema.");

        mesa.setEstadoMesa(estadoMesa);

        mesaRepo.save(mesa);

        return mesaDto;

    }

    @Override
    public MesaDto actualizarMesa(Integer id, MesaDto mesaDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MesaDto obtenerMesaPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarMesa(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MesaDto> listarMesas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MesaDto> listarMesasDisponibles() {
        String estadoMesa = "activa";

        List<Mesa> mesasDisponibles = mesaRepo.findByEstadoMesa_Nombre(estadoMesa);

        if (mesasDisponibles.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay mesas disponibles ene este momento.");
        }

        List<MesaDto> mesaDtos = new ArrayList<>();

        for (Mesa mesa : mesasDisponibles) {

            MesaDto mesaDto = new MesaDto();

            mesaDto.setCapacidad(mesa.getCapacidad());
            mesaDto.setCantidadPersonas(mesa.getCantidadPersonas());
            mesaDto.setNumero(mesa.getNumero());
            mesaDto.setId(mesa.getId());
            mesaDto.setUrlImgMesa(mesa.getUr_img_mesa());

            if (mesa.getEstadoMesa() != null) {
                mesaDto.setIdEstadoMesa(mesa.getEstadoMesa().getId());
            }

            mesaDtos.add(mesaDto);

        }
        return mesaDtos;
    }

    @Override
    public MesaDto cambiarEstadoMesa(Integer idMesa, Integer idNuevoEstado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
