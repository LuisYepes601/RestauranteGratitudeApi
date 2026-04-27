/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.DatosBasicos;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.DTOS.Request.Genero.GeneroDto;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Genero;

/**
 *
 * @author User
 */
@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {

    Optional<Genero> findByNombre(String nombre);

    @Query("SELECT NEW restaurante_gratitude.demp.DTOS.Request.Genero.GeneroDto(g.nombre)"
            + " FROM Genero g "
            + " WHERE (:name IS NULL OR g.nombre = :name)"
            + " OR (:name IS NULL OR g.nombre LIKE CONCAT (:name, '%'))")
    public Page<GeneroDto> generos(String name, Pageable pageable);

}
