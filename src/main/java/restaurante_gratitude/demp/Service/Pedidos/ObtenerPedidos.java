/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Pedidos;

import java.util.List;
import restaurante_gratitude.demp.DTOS.PedidoDto.InfoPedidoDto;
import restaurante_gratitude.demp.DTOS.PedidoDto.ObtenerPedidoBasicoDto;
import restaurante_gratitude.demp.DTOS.PedidoDto.PedidoDto;

/**
 *
 * @author Usuario
 */
public interface ObtenerPedidos {

    public List<ObtenerPedidoBasicoDto> obtenerUltimosPedidosByUser(Integer id_user, Integer limite);

    public InfoPedidoDto obtenerPedidoById(Integer id,Integer id_user);
}
