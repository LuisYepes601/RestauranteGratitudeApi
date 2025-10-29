/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Reservas;

import java.util.List;
import restaurante_gratitude.demp.Controller.Reservas.ReservaDto;

/**
 *
 * @author Usuario
 */
public interface ReservasGestion {

    void crearReserva(ReservaDto reservaDto);

    List<ReservaDto> obtenerReservas();

    ReservaDto obtenerReservaPorId(Long id);

    void actualizarReserva(Long id, ReservaDto reservaDto);

    void eliminarReserva(Long id);
}
