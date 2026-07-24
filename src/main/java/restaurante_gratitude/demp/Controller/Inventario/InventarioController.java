/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Inventario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Request.Inventario.StockDto;
import restaurante_gratitude.demp.DTOS.Response.Inventario.InventarioDetailsDtoResp;
import restaurante_gratitude.demp.DTOS.Response.Inventario.inventarioDtoResponse;
import restaurante_gratitude.demp.Service.Inventario.IInventario;

/**
 *
 * @author luis
 */
@Tag(name = "Stock-Inventario",
        description = "Módulo encargado de administrar"
        + " las distintas funcionalidades del invetario de productos")
@RequestMapping(value = "/api/v1/stock")
@RestController
public class InventarioController {

    private IInventario iInventarioService;

    @Autowired
    public InventarioController(IInventario iInventarioService) {
        this.iInventarioService = iInventarioService;
    }

    @Operation(
            description = "Operación encargada de agregar prodcuctos al stock",
            method = "POST")
    @PostMapping
    public ResponseEntity<BasicResponseDto> addProductStock(
            @Valid
            @RequestBody StockDto dto) {

        iInventarioService.addProduct(dto);

        return ResponseEntity
                .ok()
                .body(new BasicResponseDto("El prodcuto ha sido agregado con exito al sistema"));
    }

    @Operation(
            description = "Operación encargada de traer los prodcutos que  existen en le inventario",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse<inventarioDtoResponse>> getAll(
            @RequestParam(
                    name = "nombre",
                    required = false) String nombre,
            @RequestParam(
                    name = "category",
                    required = false) Integer category,
            @RequestParam(
                    name = "isDelete",
                    required = false) Boolean isDelete,
            @RequestParam(
                    name = "precioMin",
                    required = false) Double precioMin,
            @RequestParam(
                    name = "precioMax",
                    required = false) Double precioMax,
            Pageable pageable
    ) {

        return ResponseEntity
                .ok()
                .body(iInventarioService.getAll(
                        nombre, category, isDelete, precioMin, precioMax, pageable));

    }

    @Operation(
            description = "Operacion encargada de elimir un prodcuto en el sistema.",
            method = "DELETE")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> deleteProductById(
            @PathVariable(
                    name = "id",
                    required = true) Integer id) {

        return ResponseEntity
                .ok()
                .body(iInventarioService.deleteProduct(id));

    }

    @Operation(
            description = "Operación encargada de mostrar los detalles de un proucto del inventario.",
            method = "GET")
    @GetMapping(value = "/{id_product}/details")
    public ResponseEntity<InventarioDetailsDtoResp> getDetails(
            @PathVariable(
                    name = "id_product",
                    required = true) Integer id_product) {

        return ResponseEntity
                .ok()
                .body(iInventarioService.detailsProdcutInventary(id_product));

    }

    @Operation(
            description = "Operación encargada de activar un producto",
            method = "PUT")
    @PutMapping(value = "/{id_product}/activate")
    public ResponseEntity<BasicResponseDto> activateProduct(
            @PathVariable(
                    name = "id_product",
                    required = true) Integer id_product) {

        return ResponseEntity
                .ok()
                .body(iInventarioService.activateProduct(id_product));

    }
}
