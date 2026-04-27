/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Promociones;

import java.util.List;
import restaurante_gratitude.demp.DTOS.Request.Promociones.TipoPromocionDto;

/**
 *
 * @author Usuario
 */
public interface GestionarTipoDePromocion {

    TipoPromocionDto crearTipoPromocion(TipoPromocionDto dto);

    // Obtener un tipo de promoción por su ID
    TipoPromocionDto obtenerTipoPromocionPorId(Integer id);

    // Listar todos los tipos de promoción
    List<TipoPromocionDto> listarTiposPromocion();

    // Actualizar un tipo de promoción existente
    TipoPromocionDto actualizarTipoPromocion(Integer id, TipoPromocionDto dto);

    // Eliminar un tipo de promoción por su ID
    void eliminarTipoPromocion(Integer id);

}
