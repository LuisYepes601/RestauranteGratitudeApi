/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Pedidos;

import jakarta.validation.Valid;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.PedidoDto.PedidoDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Pedido.crearPedidoService;

/**
 *
 * @author Usuario
 */
@RestController()
@RequestMapping(value = "pedido/")
public class crearPedidoController {

    private crearPedidoService pedidoService;

    @Autowired
    public crearPedidoController(crearPedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping(value = "crear")
    public ResponseEntity<Map> crearPedido(@Valid @RequestBody PedidoDto pedidoDto) {

        pedidoService.crearPedido(pedidoDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of(
                        "mensaje",
                        "Querido usuario, su pedido se ha realizado con exito."));
    }

}
