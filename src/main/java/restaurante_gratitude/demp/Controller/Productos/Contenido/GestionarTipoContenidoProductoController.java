/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Productos.Contenido;

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
import restaurante_gratitude.demp.DTOS.Request.Productos.Contenido.TipoContenidoDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Productos.Contenido.GestionarTipoDeContenidoService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "tipoContenido")
public class GestionarTipoContenidoProductoController {

    private GestionarTipoDeContenidoService tipoDeContenidoService;

    @Autowired
    public GestionarTipoContenidoProductoController(GestionarTipoDeContenidoService tipoDeContenidoService) {
        this.tipoDeContenidoService = tipoDeContenidoService;
    }

    @PostMapping(value = "crear")
    public ResponseEntity<Map<String, String>> crearTipoDeContenido(@Valid
            @RequestBody TipoContenidoDto tipoContenidoDto) {

        tipoDeContenidoService.crearTipoDeContenido(tipoContenidoDto);

        Map<String, String> response = new HashMap<>();

        response.put("mensaje", "El tipo de contenido: " + tipoContenidoDto.getNombre() + " ha sido"
                + " agregado al sistema con exito.");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }
}
