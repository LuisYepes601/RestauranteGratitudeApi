/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Reservas.Mesas;

import java.util.List;
import restaurante_gratitude.demp.DTOS.Request.Reservas.Mesas.EstadoMesaDto;

/**
 *
 * @author Usuario
 */
public interface EstadoMesaGestion {
    
    
    void crearEstadoMesa(EstadoMesaDto estadoMesaDto);
    
    // Obtener la lista de todos los estados de mesa registrados
    List<EstadoMesaDto> obtenerEstadosDeMesa();
    
    // Actualizar un estado existente (por ejemplo, cambiar el nombre o estado)
    void actualizarEstadoMesa(int id, EstadoMesaDto estadoMesaDto);
    
    // Eliminar un estado de mesa por su ID
    void eliminarEstadoMesa(int id);
}
