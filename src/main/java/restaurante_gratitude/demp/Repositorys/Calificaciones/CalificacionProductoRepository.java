/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.Calificaciones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.RangoCalificacion.CalficacionProducto;
import restaurante_gratitude.demp.Entidades.RangoCalificacion.CalificacionProductoId;

/**
 *
 * @author Usuario
 */
@Repository
public interface CalificacionProductoRepository extends JpaRepository<CalficacionProducto, CalificacionProductoId> {

}
