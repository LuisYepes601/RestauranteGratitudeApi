/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Reservas.Mesas;

import java.util.List;
import restaurante_gratitude.demp.DTOS.Request.Reservas.Mesas.MesaDto;

/**
 *
 * @author Usuario
 */
public interface GestionDeMesas {

    MesaDto registrarMesa(MesaDto mesaDto);

    MesaDto actualizarMesa(Integer id, MesaDto mesaDto);

    MesaDto obtenerMesaPorId(Integer id);

    void eliminarMesa(Integer id);

    List<MesaDto> listarMesas();

    List<MesaDto> listarMesasDisponibles();

    MesaDto cambiarEstadoMesa(Integer idMesa, Integer idNuevoEstado);
}
