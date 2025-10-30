/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.DTOS.PedidoDto.EstadoPedidoDto;
import restaurante_gratitude.demp.Entidades.Pedidos.EstadoPedido;
import restaurante_gratitude.demp.Repositorys.Pedidos.EstadoPedidoRepository;
import restaurante_gratitude.demp.Service.Pedidos.GestionEstadoPedido;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author USUARIO
 */
@Service
public class GestionEstadoPedidoService implements GestionEstadoPedido {

    private EstadoPedidoRepository estadoPedidoRepository;

    @Autowired
    public GestionEstadoPedidoService(EstadoPedidoRepository estadoPedidoRepository) {
        this.estadoPedidoRepository = estadoPedidoRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void crearEstadoPedido(EstadoPedidoDto estadoPedidoDto) {

        ValidacionesGlobales.validarExistencia(estadoPedidoRepository
                .findByNombre(estadoPedidoDto.getNombre()),
                "El tipo de estado de pedido: " + estadoPedidoDto.getNombre() + " ya se encuentra en el sistema");

        EstadoPedido estadoPedido = new EstadoPedido();

        estadoPedido.setNombre(estadoPedidoDto.getNombre());

        estadoPedidoRepository.save(estadoPedido);

    }

}
