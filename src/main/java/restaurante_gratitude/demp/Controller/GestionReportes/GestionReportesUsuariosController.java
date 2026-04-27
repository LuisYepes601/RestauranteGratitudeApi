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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarReportes.ObtenerReportesUsuariosService;

/**
 *
 * @author User
 */
@RequestMapping(value = "/reporte")
@RestController
public class GestionReportesUsuariosController {

    private ObtenerReportesUsuariosService reportesUsuariosService;

    @Autowired
    public GestionReportesUsuariosController(ObtenerReportesUsuariosService reportesUsuariosService) {
        this.reportesUsuariosService = reportesUsuariosService;
    }

    
      @GetMapping(value = "/usuariosRegistrados")
    public ResponseEntity<?> usuariosRegistrados() {

        byte[] bytes = reportesUsuariosService.usuariosRegistrados();

        ByteArrayResource resource = new ByteArrayResource(bytes);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ReporteUsuariosRegistrados.pdf")
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}
