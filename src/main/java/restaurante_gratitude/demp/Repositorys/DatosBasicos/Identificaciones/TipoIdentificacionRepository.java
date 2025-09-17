/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.DatosBasicos.Identificaciones;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Identificaciones.TipoIdentificacion;

/**
 *
 * @author User
 */
@Repository
public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Integer>{
    
    public Optional<TipoIdentificacion>findByNombre(String nombre);
    
}
