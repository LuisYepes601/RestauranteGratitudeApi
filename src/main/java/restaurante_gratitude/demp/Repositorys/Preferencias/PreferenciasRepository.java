/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.Preferencias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.Preferencias.Preferencia;

/**
 *
 * @author Usuario
 */
@Repository
public interface PreferenciasRepository extends JpaRepository<Preferencia, Integer>{
    
}
