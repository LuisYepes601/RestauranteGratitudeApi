/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Inventario;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Inventario.editarCantidadtDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Inventario.GestionarCantidadMaximaService;
import restaurante_gratitude.demp.Service.ServiceImplement.Inventario.GestionarCantidadMinimaService;
import restaurante_gratitude.demp.Service.ServiceImplement.Inventario.GestionarStockService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "/gestion/inventario")
public class InventarioController {

    private GestionarCantidadMaximaService cantidadMaximaService;
    private GestionarCantidadMinimaService cantidadMinimaService;
    private GestionarStockService sttockService;

    @Autowired
    public InventarioController(GestionarCantidadMaximaService cantidadMaximaService, GestionarCantidadMinimaService cantidadMinimaService, GestionarStockService sttockService) {
        this.cantidadMaximaService = cantidadMaximaService;
        this.cantidadMinimaService = cantidadMinimaService;
        this.sttockService = sttockService;
    }

    @PostMapping(value = "/cantidadMaxima")
    public ResponseEntity editarCantidadMaxima(
            @Valid @RequestBody editarCantidadtDto cantidadtDto) {

        cantidadMaximaService.editarCantidadMaxima(
                cantidadtDto.getId_producto(),
                cantidadtDto.getCantidad());

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/cantidadMinima")
    public ResponseEntity editarCantidadMinima(
            @Valid @RequestBody editarCantidadtDto cantidadtDto) {

        cantidadMinimaService.editarCantidadMinima(
                cantidadtDto.getId_producto(),
                cantidadtDto.getCantidad());

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/cantidadActual")
    public ResponseEntity editarCantidadActual(
            @Valid @RequestBody editarCantidadtDto cantidadtDto) {

        sttockService.editarStock(
                cantidadtDto.getId_producto(),
                cantidadtDto.getCantidad());

        return ResponseEntity.ok().build();
    }

}
