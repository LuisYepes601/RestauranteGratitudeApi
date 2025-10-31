/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Pedido;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.PedidoDto.DetallePedidoDto;
import restaurante_gratitude.demp.DTOS.PedidoDto.InfoPedidoDto;
import restaurante_gratitude.demp.DTOS.PedidoDto.InfoProductosPedidoDto;
import restaurante_gratitude.demp.DTOS.PedidoDto.ObtenerPedidoBasicoDto;
import restaurante_gratitude.demp.DTOS.PedidoDto.PedidoDto;
import restaurante_gratitude.demp.Entidades.Pedidos.DetallePedido;
import restaurante_gratitude.demp.Entidades.Pedidos.Pedido;
import restaurante_gratitude.demp.Repositorys.Pedidos.PedidoRepository;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Pedidos.ObtenerPedidos;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class ObtenerPedidosService implements ObtenerPedidos {

    private UsuarioRepository usuarioRepo;
    private PedidoRepository pedidoRepo;

    @Autowired
    public ObtenerPedidosService(UsuarioRepository usuarioRepo, PedidoRepository pedidoRepo) {
        this.usuarioRepo = usuarioRepo;
        this.pedidoRepo = pedidoRepo;
    }

    @Override
    public List<ObtenerPedidoBasicoDto> obtenerUltimosPedidosByUser(Integer id_user, Integer limite) {

        ValidacionesGlobales.obtenerSiExiste(usuarioRepo.findById(id_user),
                "El usuario no se enecuentra en el sistema.");

        Pageable pageable = PageRequest.of(
                0,
                limite);

        List<Pedido> pedidos = pedidoRepo.findByUsuarioIdOrderByFechaPedidoDesc(
                id_user,
                pageable).getContent();

        if (pedidos.isEmpty()) {
            throw new NoDatosQueMostrarExecption("Error, el usuario no tiene pedidos.");
        }

        List<ObtenerPedidoBasicoDto> pedidoBasicoDtos = new ArrayList<>();

        for (Pedido pedido : pedidos) {

            ObtenerPedidoBasicoDto dto = new ObtenerPedidoBasicoDto();

            dto.setIdPedido(pedido.getId());

            if (pedido.getEstadoPedido() != null) {
                dto.setEstadoPedido(pedido.getEstadoPedido().getNombre());
            }
            dto.setFechaPedido(pedido.getFechaPedido());

            if (pedido.getTipoPedido() != null) {
                dto.setTipoPedido(pedido.getTipoPedido().getNombre());
            }

            dto.setTotalItems(pedido.getTotalItems());
            dto.setTotal(pedido.getTotal());

            pedidoBasicoDtos.add(dto);
        }

        return pedidoBasicoDtos;

    }

    public Page<ObtenerPedidoBasicoDto> getPedidosUsuario(
            Integer usuarioId,
            String search,
            String estado,
            Pageable pageable) {

        // Usa directamente tu consulta con filtros
        Page<Pedido> page = pedidoRepo.findByUsuarioIdWithFilters(
                usuarioId,
                search,
                estado,
                pageable
        );

        // Mapeo manual al DTO
        return page.map(pedido -> new ObtenerPedidoBasicoDto(
                pedido.getId(),
                pedido.getFechaPedido(),
                pedido.getTipoPedido() != null ? pedido.getTipoPedido().getNombre() : "Online",
                pedido.getEstadoPedido() != null ? pedido.getEstadoPedido().getNombre() : "Pendiente",
                pedido.getTotal(),
                pedido.getTotalItems()
        ));
    }

    @Override
    public InfoPedidoDto obtenerPedidoById(Integer id, Integer id_user) {
        ValidacionesGlobales.obtenerSiExiste(usuarioRepo.findById(id_user),
                "El usuario no se enecuentra en el sistema.");

        Pedido pedido = ValidacionesGlobales.obtenerSiExiste(pedidoRepo.findById(id),
                "Error el pedido no se encuentra registardo en el sistema");

        InfoPedidoDto pedidoDto = new InfoPedidoDto();

        if (pedido.getEstadoPedido() != null) {

            pedidoDto.setEstado(pedido.getEstadoPedido().getNombre());
        }

        pedidoDto.setFechaPedido(pedido.getFechaPedido());

        if (pedido.getTipoPedido() != null) {
            pedidoDto.setTipo(pedido.getTipoPedido().getNombre());
        }
        pedidoDto.setTotal_items(pedido.getTotalItems());
        List<InfoProductosPedidoDto> detallePedidoDtos = new ArrayList<>();

        for (DetallePedido registro : pedido.getDetalles()) {

            InfoProductosPedidoDto infoProductosPedidoDto = new InfoProductosPedidoDto();

            infoProductosPedidoDto.setCantidad(registro.getCantidad());
            infoProductosPedidoDto.setDescripion(registro.getDecripcion());
            infoProductosPedidoDto.setPrecioUnidad(registro.getPrecioUnidad());
            infoProductosPedidoDto.setSubtotal(registro.getPrecioUnidad());
            infoProductosPedidoDto.setTotal(pedido.getTotal());
            if (registro.getProducto() != null) {

                infoProductosPedidoDto.setImg_producto(registro.getProducto().getImagen());
            }

            detallePedidoDtos.add(infoProductosPedidoDto);
        }

        pedidoDto.setProductos(detallePedidoDtos);

        return pedidoDto;

    }

}
