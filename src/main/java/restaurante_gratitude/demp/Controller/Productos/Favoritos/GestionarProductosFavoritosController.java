/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Productos.Favoritos;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.ProductosFavoritos.ProductoFavoritoDtoRegistrar;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.Favorito.GestionarProductosFavoritosService;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value = "productosFavoritos")
public class GestionarProductosFavoritosController {

    private GestionarProductosFavoritosService productosFavoritosService;

    @Autowired
    public GestionarProductosFavoritosController(GestionarProductosFavoritosService productosFavoritosService) {
        this.productosFavoritosService = productosFavoritosService;
    }

    @PostMapping(value = "agregar")
    public ResponseEntity<Map<String, String>> agregarProductoFavorito(@Valid
            @RequestBody ProductoFavoritoDtoRegistrar productoFavoritoDtoRegistrar) {

        String respuesta = productosFavoritosService.agregarProductoFavorito(productoFavoritoDtoRegistrar);

        Map<String, String> response = new HashMap<>();

        response.put("mensaje", respuesta);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

}
