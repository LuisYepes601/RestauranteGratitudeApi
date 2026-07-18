/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Productos.Categoria;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Request.Productos.Categoria.CategoriaProductoDto;
import restaurante_gratitude.demp.Service.Productos.Categoria.ICategoria;

/**
 *
 * @author Usuario
 */
@Tag(
        name = "Category Product",
        description = "Este módulo respresenta a la categoria de un prodcuto")
@RestController
@RequestMapping(value = "api/v1/category")
public class GestionCategoriasController {

    private ICategoria iCategoria;

    @Autowired
    public GestionCategoriasController(ICategoria iCategoria) {
        this.iCategoria = iCategoria;
    }

    public GestionCategoriasController() {
    }

    @Operation(
            description = "Operación encargada de crear una categoria de un producto en el sistema",
            method = "POST")
    @PostMapping()
    public ResponseEntity<BasicResponseDto> createCategory(
            @Valid
            @RequestBody CategoriaProductoDto categoriaProductoDto) {

        return ResponseEntity
                .ok()
                .body(iCategoria.createCategory(categoriaProductoDto));
    }

    @Operation(
            description = "Operación que permite obtener todas las categorias de prouctos del sistema.",
            method = "GET")
    @GetMapping()
    public ResponseEntity<PageResponse> findAll(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "isDelete", required = false) Boolean isDelete,
            Pageable pageable) {

        return ResponseEntity
                .ok()
                .body(iCategoria.findAll(nombre, isDelete, pageable));

    }

    public ICategoria getiCategoria() {
        return iCategoria;
    }

    public void setiCategoria(ICategoria iCategoria) {
        this.iCategoria = iCategoria;
    }

}
