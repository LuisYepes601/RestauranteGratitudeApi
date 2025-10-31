/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.DTOS.PedidoDto.TipoPedidoDto;
import restaurante_gratitude.demp.Entidades.Pedidos.TipoPedido;
import restaurante_gratitude.demp.Repositorys.Pedidos.TipoPedidoRepository;
import restaurante_gratitude.demp.Service.Pedidos.GestionTipoPedido;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionTipoPedidoService implements GestionTipoPedido {

    private TipoPedidoRepository tipoPedidoRepo;

    @Autowired
    public GestionTipoPedidoService(TipoPedidoRepository tipoPedidoRepo) {
        this.tipoPedidoRepo = tipoPedidoRepo;
    }

    @Override
    public String crearTiPoPedido(TipoPedidoDto tipoPedidoDto) {

        ValidacionesGlobales.validarExistencia(tipoPedidoRepo.findByNombre(
                tipoPedidoDto.getNombre()),
                "Error el tipo de pedido: " + tipoPedidoDto.getNombre() + " ya existe en el sistema.");

        TipoPedido tipoPedido = new TipoPedido();

        tipoPedido.setNombre(tipoPedidoDto.getNombre());
        tipoPedidoRepo.save(tipoPedido);

        return "El tipo de pedido " + tipoPedidoDto.getNombre() + " ha sido creado con exito.";
    }

}
