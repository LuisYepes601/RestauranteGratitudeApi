/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.GestionReportes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarReportes.ObtenerReporteProductosService;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/reporte")
public class ObtenerReportesProductos {

    private ObtenerReporteProductosService reporteProductosService;

    @Autowired
    public ObtenerReportesProductos(ObtenerReporteProductosService reporteProductosService) {
        this.reporteProductosService = reporteProductosService;
    }

    @GetMapping(value = "/productosValidos")
    public ResponseEntity<?> ProductosValidos() {

        byte[] bytes = reporteProductosService.productosValidos();

        ByteArrayResource resource = new ByteArrayResource(bytes);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=productosValidos.pdf")
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }

    @GetMapping(value = "/productos/by/categoria/{categoria}")
    public ResponseEntity<?> ProductosByCategoria(@PathVariable String categoria) {

        byte[] bytes = reporteProductosService.productosByCategoria(categoria);

        ByteArrayResource resource = new ByteArrayResource(bytes);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=productosPorCategoria.pdf")
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }

}
