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
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.DTOS.Request.Genero.GeneroDto;
import restaurante_gratitude.demp.DTOS.Response.Genero.generoDetailsDto;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Genero;

/**
 *
 * @author User
 */
@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {

    Optional<Genero> findByNombre(String nombre);

    @Query("""
        SELECT NEW restaurante_gratitude.demp.DTOS.Request.Genero.GeneroDto(
            g.id,
            g.nombre,
            g.description,
            g.createAt,
            g.updateAt,
            g.createBy,
            g.isDelete
        )
        FROM Genero g
        WHERE (:name IS NULL OR g.nombre LIKE CONCAT(CAST(:name AS string), '%'))
        AND ( g.isDelete = :isDelete OR :isDelete IS NULL) 
        """)
    Page<GeneroDto> generos(
            @Param("name") String name,
            @Param("isDelete") Boolean isDelete,
            Pageable pageable);

    public Optional<Genero> findByNombreIgnoreCase(String nombre);

    @Query("SELECT NEW restaurante_gratitude.demp.DTOS.Response.Genero.generoDetailsDto( "
            + "g.deleteAt,"
            + "g.creatorName,"
            + "g.updateBy,"
            + "g.updateName,"
            + "g.deleteBy,"
            + "g.deleteName) "
            + "FROM Genero g"
            + " WHERE g.id = :id")
    public Optional<generoDetailsDto> getDetailById(
            @Param(value = "id") Integer id);

}
