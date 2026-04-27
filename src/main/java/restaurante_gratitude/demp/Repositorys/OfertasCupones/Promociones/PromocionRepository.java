/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.OfertasCupones.Promociones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.OfertsCupons.Promociones.Promocion;

/**
 *
 * @author Usuario
 */
@Repository
public interface PromocionRepository extends JpaRepository<Promocion, Integer>{
    
}
