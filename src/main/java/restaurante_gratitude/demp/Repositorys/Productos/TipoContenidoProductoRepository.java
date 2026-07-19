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
import restaurante_gratitude.demp.DTOS.Response.Productos.Contenido.TipoContenidoDtoResponse;
import restaurante_gratitude.demp.Entidades.Productos.TipoContenidoProducto;

/**
 *
 * @author Usuario
 */
@Repository
public interface TipoContenidoProductoRepository extends JpaRepository<TipoContenidoProducto, Integer> {

    public Optional<TipoContenidoProducto> findByNombreIgnoreCase(String nombre);

    @Query("""
           
           SELECT NEW restaurante_gratitude.demp.DTOS.Response.Productos.Contenido.TipoContenidoDtoResponse(
           tcp.id,
           tcp.nombre,
           tcp.isDelete,
           tcp.description,
           tcp.createAt,
           tcp.updateAt,
           tcp.createBy
           )
           
           FROM TipoContenidoProducto tcp
           
           WHERE (:isDelete IS NULL OR :isDelete = tcp.isDelete)
           AND (:nombre IS NULL OR LOWER(tcp.nombre) LIKE LOWER(CONCAT(CAST(:nombre AS string), '%')))
           """)
    public Page<TipoContenidoDtoResponse> getAll(
            @Param(value = "nombre") String nombre,
            @Param(value = "isDelete") Boolean isDelete,
            Pageable pageable);
}
