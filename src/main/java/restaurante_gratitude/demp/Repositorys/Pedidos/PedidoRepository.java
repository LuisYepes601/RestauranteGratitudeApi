/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.Pedidos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.Pedidos.Pedido;

/**
 *
 * @author Usuario
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    Page<Pedido> findByUsuarioIdOrderByFechaPedidoDesc(Integer id, Pageable pageable);

    @Query("""
    SELECT p FROM Pedido p
    WHERE p.usuario.id = :usuarioId
      AND (:search IS NULL 
           OR LOWER(p.tipoPedido.nombre) LIKE LOWER(CONCAT('%', :search, '%'))
           OR CAST(p.id AS string) LIKE CONCAT('%', :search, '%'))
      AND (:estado IS NULL OR p.estadoPedido.nombre = :estado)
    """)
Page<Pedido> findByUsuarioIdWithFilters(
    @Param("usuarioId") Integer usuarioId,
    @Param("search") String search,
    @Param("estado") String estado,
    Pageable pageable);

}
