/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.Pedidos;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.Pedidos.EstadoPedido;

/**
 *
 * @author Usuario
 */
@Repository
public interface EstadoPedidoRepository extends JpaRepository<EstadoPedido, Integer> {

    public Optional<EstadoPedido> findByNombre(String nombre);
}
