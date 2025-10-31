/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Pedidos;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.PedidoDto.TipoPedidoDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Pedido.GestionTipoPedidoService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "tipoPedido/")
public class GestionTipoPedidoController {

    private GestionTipoPedidoService tipoPedidoService;

    public GestionTipoPedidoController(GestionTipoPedidoService tipoPedidoService) {
        this.tipoPedidoService = tipoPedidoService;
    }

    @PostMapping(value = "crear")
    public ResponseEntity<Map> crearTipoPedido(@Valid @RequestBody TipoPedidoDto tipoPedidoDto) {

        String response = tipoPedidoService.crearTiPoPedido(tipoPedidoDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensaje", response));
    }
}
