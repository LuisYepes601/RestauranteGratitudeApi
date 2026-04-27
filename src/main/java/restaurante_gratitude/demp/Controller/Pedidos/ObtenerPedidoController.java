/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Pedidos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.PedidoDto.InfoPedidoDto;
import restaurante_gratitude.demp.DTOS.PedidoDto.ObtenerPedidoBasicoDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Pedido.ObtenerPedidosService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "pedidos/")
public class ObtenerPedidoController {

    private ObtenerPedidosService obtenerPedidosService;

    @Autowired
    public ObtenerPedidoController(ObtenerPedidosService obtenerPedidosService) {
        this.obtenerPedidosService = obtenerPedidosService;
    }

    @GetMapping(value = "recientes/usuario/{id}")
    public ResponseEntity<List> obtenerUltimosPedidos(@PathVariable Integer id,
            @RequestParam Integer limite) {

        return ResponseEntity.ok(obtenerPedidosService.obtenerUltimosPedidosByUser(id, limite));

    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Page<ObtenerPedidoBasicoDto>> getPedidosUsuario(
            @PathVariable Integer id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String estado) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("fechaPedido").descending());

        Page<ObtenerPedidoBasicoDto> response = obtenerPedidosService.getPedidosUsuario(id, search, estado, pageable);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id_pedido}/{id_user}")
    public ResponseEntity<InfoPedidoDto> obtnerPedido(@PathVariable Integer id_pedido, @PathVariable Integer id_user) {

        return ResponseEntity.ok(obtenerPedidosService.obtenerPedidoById(id_pedido, id_user));
    }

}
