/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Productos.Categoria;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Productos.Categoria.CategoriaProductoDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.GestionarCategoriaProductoService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "categoria")
public class GestionCategoriasController {

    private GestionarCategoriaProductoService categoriaProductoService;

    @Autowired
    public GestionCategoriasController(GestionarCategoriaProductoService categoriaProductoService) {
        this.categoriaProductoService = categoriaProductoService;
    }

    @PostMapping(value = "crear")
    public ResponseEntity<Map<String, String>> crearCategoria(@Valid
            @RequestBody CategoriaProductoDto categoriaProductoDto) {

        categoriaProductoService.agregarCategoria(categoriaProductoDto);

        Map<String, String> response = new HashMap<>();

        response.put("mensaje", "La categoria: " + categoriaProductoDto.getNombre() + " ha sido agregada"
                + "con exito al sistema.");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);

    }

}
