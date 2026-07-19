/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.Productos;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.DTOS.Response.Productos.Categoria.CategoryDetailsDto;
import restaurante_gratitude.demp.DTOS.Response.Productos.Categoria.CategoryDtoResponse;
import restaurante_gratitude.demp.Entidades.Productos.Categoria;

/**
 *
 * @author Usuario
 */
@Repository
public interface CategoriaProductoRepository extends JpaRepository<Categoria, Integer> {

    public Optional<Categoria> findByNombreIgnoreCase(String nombre);

    @Query("""
           SELECT NEW restaurante_gratitude.demp.DTOS.Response.Productos.Categoria.CategoryDtoResponse(
           c.id,
           c.nombre, 
           c.isDelete,
           c.description,
           c.createAt,
           c.updateAt,
           c.createBy
           )
           
           FROM Categoria c
           
           WHERE (:nombre IS NULL OR LOWER(c.nombre) LIKE LOWER(CONCAT(CAST(:nombre AS string), '%')))
           AND (:isDelete IS NULL OR :isDelete = c.isDelete)
           
           
           """)
    public Page<CategoryDtoResponse> GetAll(
            @Param(value = "nombre") String nombre,
            @Param(value = "isDelete") Boolean isDelete,
            Pageable pageable);

    @Query("""
           SELECT NEW restaurante_gratitude.demp.DTOS.Response.Productos.Categoria.CategoryDetailsDto(
           c.deleteAt,
           c.creatorName,
           c.updateBy,
           c.updateName,
           c.deleteName,
           c.deleteBy
           )
           
           FROM Categoria c
           
           WHERE (:id = c.id)
           """)
    public Optional<CategoryDetailsDto> getDetails(@Param(value = "id") Integer id);

}
