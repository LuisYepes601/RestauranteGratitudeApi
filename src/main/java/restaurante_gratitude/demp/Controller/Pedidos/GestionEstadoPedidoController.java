/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Pedidos;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.PedidoDto.EstadoPedidoDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Pedido.GestionEstadoPedidoService;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping(value = "estadoPedido/")
public class GestionEstadoPedidoController {

    private GestionEstadoPedidoService estadoPedidoService;

    @Autowired
    public GestionEstadoPedidoController(GestionEstadoPedidoService estadoPedidoService) {
        this.estadoPedidoService = estadoPedidoService;
    }

    @PostMapping(value = "crear")
    public ResponseEntity crearEstadoPedido(@Valid @RequestBody EstadoPedidoDto estadoPedidoDto) {

        estadoPedidoService.crearEstadoPedido(estadoPedidoDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

}
