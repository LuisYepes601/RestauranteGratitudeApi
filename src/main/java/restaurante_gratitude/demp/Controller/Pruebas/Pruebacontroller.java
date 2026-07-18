/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Response.Productos.ProductoBasicDtoResponse;
import restaurante_gratitude.demp.Repositorys.Productos.ProductoRepository;

/**
 *
 * @author luis
 */
@RestController
@RequestMapping(value = "/prueba")
public class Pruebacontroller {

    private ProductoRepository repository;

    @Autowired
    public Pruebacontroller(ProductoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Page<ProductoBasicDtoResponse>> get(
            @RequestParam(
                    name = "nombre",
                    required = false) String nombre,
            @RequestParam(
                    name = "precio",
                    required = false) Double precio,
            @RequestParam(
                    name = "category",
                    required = false) String category,
            Pageable pageable) {

        Page<ProductoBasicDtoResponse> page
                = repository.findAllBasic(nombre, precio, category, pageable);

        return ResponseEntity.ok(page);
    }

}
