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
import restaurante_gratitude.demp.DTOS.Response.Sexo.SexoDetailsDto;
import restaurante_gratitude.demp.DTOS.Response.Sexo.SexoResponseDto;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Sexo;

/**
 *
 * @author User
 */
@Repository
public interface SexoRepository extends JpaRepository<Sexo, Integer> {

    public Optional<Sexo> findByNombreIgnoreCase(String nombre);

    @Query("""
    SELECT NEW restaurante_gratitude.demp.DTOS.Response.Sexo.SexoResponseDto(
        s.id,
        s.nombre,
        s.isDelete,
        s.description,
        s.createAt,
        s.updateAt,
        s.createBy
    )
    FROM Sexo s
    WHERE (:nombre IS NULL OR LOWER(s.nombre) LIKE LOWER(CONCAT(CAST(:nombre AS string), '%')))
      AND (s.isDelete = :isDelete OR :isDelete IS NULL)
    """)
    Page<SexoResponseDto> getAll(
            @Param("nombre") String nombre,
            @Param("isDelete") Boolean isDelete,
            Pageable pageable
    );

    @Query("SELECT NEW restaurante_gratitude.demp.DTOS.Response.Sexo.SexoDetailsDto("
            + " s.deleteAt,"
            + " s.creatorName,"
            + " s.updateBy,"
            + " s.updateName,"
            + " s.deleteName,"
            + " s.deleteBy ) "
            + " FROM Sexo s "
            + " WHERE (s.id = :id)")
    public Optional<SexoDetailsDto> getDetails(
            @Param(value = "id") Integer id);

}
