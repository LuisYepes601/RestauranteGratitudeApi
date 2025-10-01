/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionarReportes.EstilosPdfService;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.properties.TextAlignment;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarFuentes.FontsService;

/**
 *
 * @author Usuario
 */
@Service
public class EstilosCeldasServices {

    private FontsService fontsService;

    @Autowired
    public EstilosCeldasServices(FontsService fontsService) {
        this.fontsService = fontsService;
    }

    public EstilosCeldasServices() {
    }

    public Cell celdasTitularesBasico() throws IOException {

        return new Cell()
                .setFontSize(14)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(new DeviceRgb(212, 212, 212))
                .setFontColor(new DeviceRgb(0, 0, 0))
                .setFont(fontsService.Roboto());

    }
}
