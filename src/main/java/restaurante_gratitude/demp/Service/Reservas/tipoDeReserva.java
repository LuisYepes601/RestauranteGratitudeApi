/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Reservas;

import java.util.List;
import restaurante_gratitude.demp.DTOS.Request.Reservas.TipoReservaDtoRes;

/**
 *
 * @author Usuario
 */
public interface tipoDeReserva {

    void crearTipoDeReserva(TipoReservaDtoRes tipoReservaDto);

    // Obtener todos los tipos de reserva
    List<TipoReservaDtoRes> obtenerTiposDeReserva();

    // Obtener un tipo de reserva por su ID
    TipoReservaDtoRes obtenerTipoDeReservaPorId(Integer id);

    // Actualizar un tipo de reserva
    void actualizarTipoDeReserva(Long id, TipoReservaDtoRes tipoReservaDto);

    // Eliminar un tipo de reserva
    void eliminarTipoDeReserva(Long id);
}
