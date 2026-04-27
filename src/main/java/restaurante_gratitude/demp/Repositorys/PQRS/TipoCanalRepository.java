/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.PQRS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.PQRS.TipoCanal;

/**
 *
 * @author Usuario
 */
@Repository
public interface TipoCanalRepository extends JpaRepository<TipoCanal, Integer> {
    
}
