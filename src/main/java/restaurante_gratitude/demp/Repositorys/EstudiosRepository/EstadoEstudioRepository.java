/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.EstudiosRepository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.Estudios.EstadoEstudio;

/**
 *
 * @author User
 */
@Repository
public interface EstadoEstudioRepository extends JpaRepository<EstadoEstudio, Integer>{
    
    public Optional<EstadoEstudio> findByNombre(String nombre);
    
}
