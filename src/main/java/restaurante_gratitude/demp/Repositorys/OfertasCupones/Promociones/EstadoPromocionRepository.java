/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.OfertasCupones.Promociones;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.OfertsCupons.Promociones.EstadoPromocion;

/**
 *
 * @author Usuario
 */
@Repository
public interface EstadoPromocionRepository extends JpaRepository<EstadoPromocion, Integer> {

    public Optional<EstadoPromocion> findByNombre(String nombre);
}
