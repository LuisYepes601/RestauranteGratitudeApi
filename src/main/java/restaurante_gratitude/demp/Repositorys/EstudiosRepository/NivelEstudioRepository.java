/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.EstudiosRepository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.Estudios.NivelEstudio;

/**
 *
 * @author User
 */
@Repository
public interface NivelEstudioRepository extends JpaRepository<NivelEstudio, Integer> {

    public Optional<NivelEstudio> findByNombre(String nombre);
}
