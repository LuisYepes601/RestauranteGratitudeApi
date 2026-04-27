/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.Devoluciones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.Devoluciones.TipoDevolucion;

/**
 *
 * @author User
 */
@Repository
public interface TipoDevolucionRepository extends JpaRepository<TipoDevolucion, Integer>{
    
}
