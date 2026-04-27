/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Promociones;

import java.util.List;
import restaurante_gratitude.demp.DTOS.Request.Promociones.EstadoPromocionDto;

/**
 *
 * @author Usuario
 */
public interface GestionarEstadoDePromociones {

    EstadoPromocionDto crearEstadoPromocion(EstadoPromocionDto estadoPromocionDto);

    EstadoPromocionDto actualizarEstadoPromocion(Long id, EstadoPromocionDto estadoPromocionDto);

    void eliminarEstadoPromocion(Long id);

    EstadoPromocionDto obtenerEstadoPromocionPorId(Long id);

    List<EstadoPromocionDto> listarEstadosPromocion();
}
