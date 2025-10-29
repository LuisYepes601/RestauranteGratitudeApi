/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Promociones;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.DTOS.Request.Promociones.TipoPromocionDto;
import restaurante_gratitude.demp.Service.ServiceImplement.Promociones.GestionarTipoDePromocionService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "tipoPromociones/")
public class GestionarTipoPromocionesController {

    private GestionarTipoDePromocionService tipoDePromocionService;

    @Autowired
    public GestionarTipoPromocionesController(GestionarTipoDePromocionService tipoDePromocionService) {
        this.tipoDePromocionService = tipoDePromocionService;
    }

    @PostMapping(value = "crear/")
    ResponseEntity<Map> crearTipoPromocion(@Valid @RequestBody TipoPromocionDto promocionDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensaje", tipoDePromocionService.crearTipoPromocion(promocionDto)));
    }

    @GetMapping(value = "obtner/by/{id}")
    public ResponseEntity<Map> obtenerById(@PathVariable Integer id) {

        Map<String, TipoPromocionDto> respuesta = new HashMap<>();

        respuesta.put("mensaje", tipoDePromocionService.obtenerTipoPromocionPorId(id));
        return ResponseEntity.status(HttpStatus.OK)
                .body(respuesta);
    }

    @PostMapping(value = "actualizar/byId/{id}")
    ResponseEntity<Map> actualizarTipoDePromocion(@Valid @RequestBody TipoPromocionDto promocionDto,
            @PathVariable Integer id) {

        TipoPromocionDto tipoPromocionDto = tipoDePromocionService.actualizarTipoPromocion(
                id,
                promocionDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensaje",
                        "El tipo de promoción: " + tipoPromocionDto.getNombre() + " ha sido"
                        + " actualizada correctamente"));
    }

}
