/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.Inventario;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.DTOS.Response.Inventario.InventarioDetailsDtoResp;
import restaurante_gratitude.demp.DTOS.Response.Inventario.inventarioDtoResponse;
import restaurante_gratitude.demp.Entidades.InventarioStockProducto.StockProducto;

/**
 *
 * @author Usuario
 */
@Repository
public interface StockProductoRepository extends JpaRepository<StockProducto, Integer> {

    Optional<StockProducto> findByProductoId(Integer id_producto);

    @Query("""
           
           SELECT NEW restaurante_gratitude.demp.DTOS.Response.Inventario.inventarioDtoResponse(
           
           sp.id,
           sp.cantidad,
           sp.cantidadMax,
           sp.cantidadMin,
           p.id,
           p.imagen,
           p.precio,
           sp.isDelete,
           sp.updateAt,
           c.nombre,
           c.id, 
           p.nombre
           
           )
           FROM StockProducto sp
           LEFT JOIN sp.producto p 
           LEFT JOIN p.categoria c
           
           WHERE(:nombre IS NULL OR p.nombre LIKE CONCAT(CAST(:nombre AS string), '%'))
           AND (:id_cat IS NULL OR :id_cat = c.id)
           AND (:isDelete IS NULL OR :isDelete = sp.isDelete)
           AND ((p.precio BETWEEN :precioMin AND :precioMax) 
                OR (:precioMin IS NULL AND :precioMax IS NULL) 
                OR (:precioMax IS NULL)
                OR (:precioMin IS NULL))
           """)
    public Page<inventarioDtoResponse> getAll(
            @Param(value = "nombre") String nombre,
            @Param(value = "id_cat") Integer category,
            @Param(value = "isDelete") Boolean isDelete,
            @Param(value = "precioMin") Double precioMin,
            @Param(value = "precioMax") Double precioMax,
            Pageable pageable);

    @Query("""
           
           SELECT NEW restaurante_gratitude.demp.DTOS.Response.Inventario.InventarioDetailsDtoResp(
                      sp.deleteAt,
                      sp.creatorName,
                      sp.updateBy,
                      sp.updateName,
                      sp.deleteBy,
                      sp.deleteName,
                      sp.updateAt,
                      sp.createBy,
                      p.descripcion,
                      c.nombre,
                      p.imagen
                      
           )
        
           FROM StockProducto sp
           JOIN sp.producto p
           LEFT JOIN p.categoria c 
           
           where sp.producto.id = :id_product
           
           
           """)
    public Optional<InventarioDetailsDtoResp> getDetail(@Param(value = "id_product") Integer id);

}
