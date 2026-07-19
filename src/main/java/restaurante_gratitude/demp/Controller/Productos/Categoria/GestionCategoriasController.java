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
import restaurante_gratitude.demp.DTOS.Request.Productos.Categoria.CategoriaProductoDto;
import restaurante_gratitude.demp.DTOS.Response.Productos.Categoria.CategoryDetailsDto;
import restaurante_gratitude.demp.Service.Productos.Categoria.ICategoria;

/**
 *
 * @author Usuario
 */
@Tag(
        name = "Category Product",
        description = "Este módulo respresenta a la categoria de un prodcuto")
@RestController
@RequestMapping(value = "api/v1/categories")
public class GestionCategoriasController {

    private ICategoria iCategoria;

    @Autowired
    public GestionCategoriasController(ICategoria iCategoria) {
        this.iCategoria = iCategoria;
    }

    public GestionCategoriasController() {
    }

    public ICategoria getiCategoria() {
        return iCategoria;
    }

    public void setiCategoria(ICategoria iCategoria) {
        this.iCategoria = iCategoria;
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

    @Operation(
            description = "Operación encargada de actulizar categorias de productos en el sistema.",
            method = "PUT")
    @PutMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> updateById(
            @PathVariable(
                    name = "id",
                    required = true) Integer id,
            @RequestBody CategoriaProductoDto categoriaProductoDto) {

        return ResponseEntity
                .ok()
                .body(iCategoria.updateCategoryById(id, categoriaProductoDto));
    }

    @Operation(
            description = "Operación encargada de eliminar una categoria del sistema",
            method = "DELETE")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BasicResponseDto> deleteById(
            @PathVariable(
                    name = "id",
                    required = true) Integer id) {

        return ResponseEntity
                .ok()
                .body(iCategoria.deleteById(id));
    }

    @Operation(
            description = "Operación encargada de activar una categoria.",
            method = "PUT")
    @PutMapping(value = "/{id}/activate")
    public ResponseEntity<BasicResponseDto> activateById(
            @PathVariable(
                    name = "id",
                    required = true) Integer id) {

        return ResponseEntity
                .ok()
                .body(iCategoria.activateById(id));
    }

    @Operation(
            description = "Operación encargada de mostrar detalles de auditoria de una categoria.",
            method = "GET")
    @GetMapping(value = "/{id}/details")
    public ResponseEntity<CategoryDetailsDto> getDetailById(
            @PathVariable(
                    name = "id",
                    required = true) Integer id) {

        return ResponseEntity
                .ok()
                .body(iCategoria.getDetailsById(id));

    }

}
