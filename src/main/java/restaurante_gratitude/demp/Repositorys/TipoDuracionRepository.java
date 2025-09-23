/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.DTOS.Request.Duracion.TipoDuracionDto;
import restaurante_gratitude.demp.Entidades.TipoDuracion;

/**
 *
 * @author User
 */
@Repository
public interface TipoDuracionRepository extends JpaRepository<TipoDuracion, Integer> {

    public Optional<TipoDuracion> findByNombre(String nombre);
}
