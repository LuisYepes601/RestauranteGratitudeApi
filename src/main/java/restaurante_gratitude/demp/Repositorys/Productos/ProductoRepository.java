/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.Productos;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.DTOS.Response.Productos.ProductoBasicDtoResponse;
import restaurante_gratitude.demp.Entidades.Productos.Producto;

/**
 *
 * @author Usuario
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    public Optional<Producto> findByNombre(String nombre);

    public List<Producto> findByCategoria_nombre(String nombre);

    @Query("""
         SELECT NEW restaurante_gratitude.demp.DTOS.Response.Productos.ProductoBasicDtoResponse(
             p.id,
             p.nombre,
             p.precio,
             p.imagen,
             cat.nombre,
             cat.id,
             cont.valor,
             tipcont.nombre,
             tipcont.id,
             tipProm.name,
             tipProm.id,
             prom.valor,
             prom.fechaFin,
             AVG(calf.rangoCalificacion),
             fav.isDelete,
             COUNT(DISTINCT calf.id)
                
           
         )
         FROM Producto p
         LEFT JOIN p.categoria cat
         LEFT JOIN p.contenido cont
         LEFT JOIN cont.tipo tipcont
         LEFT JOIN p.promocion prom
         LEFT JOIN prom.tipoPromocion tipProm
         LEFT JOIN p.productosFavoritos fav
         LEFT JOIN p.calficacionProductos calf
           
         WHERE (
             (CAST(:nombre AS string) IS NULL
             OR p.nombre LIKE CONCAT(CAST(:nombre AS string), '%'))
                 
         AND 
            (:precio IS NULL 
               OR p.precio = :precio)
           
         AND  (CAST(:category AS string) IS NULL
               OR cat.nombre LIKE CONCAT(CAST(:category AS string), '%'))
         )
           
           GROUP BY
               p.id,
               p.nombre,
               p.precio,
               p.imagen,
               cat.nombre,
               cat.id,
               cont.valor,
               tipcont.nombre,
               tipcont.id,
               tipProm.name,
               tipProm.id,
               prom.valor,
               prom.fechaFin,
               fav.isDelete
     """)
    Page<ProductoBasicDtoResponse> findAllBasic(
            @Param("nombre") String nombre,
            @Param("precio") Double precio,
            @Param("category") String category,
            Pageable pageable);

}
