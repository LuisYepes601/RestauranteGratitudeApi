/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.Pedidos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.Pedidos.TipoPedido;

/**
 *
 * @author Usuario
 */
@Repository
public interface TipoPedidoRepository extends JpaRepository<TipoPedido, Integer>{
    
}
