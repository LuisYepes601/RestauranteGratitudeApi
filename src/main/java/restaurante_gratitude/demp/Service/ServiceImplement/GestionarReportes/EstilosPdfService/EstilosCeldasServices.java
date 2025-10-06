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
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarFuentes.FontsServicePdf.FontServicePdf;

/**
 *
 * @author Usuario
 */
@Service
public class EstilosCeldasServices {

    FontServicePdf fontServicePdf;

    public EstilosCeldasServices() {
    }

    @Autowired
    public EstilosCeldasServices(FontServicePdf fontServicePdf) {
        this.fontServicePdf = fontServicePdf;
    }

    public FontServicePdf getFontServicePdf() {
        return fontServicePdf;
    }

    public void setFontServicePdf(FontServicePdf fontServicePdf) {
        this.fontServicePdf = fontServicePdf;
    }

    public Cell celdasTitularesBasico() throws IOException {

        return new Cell()
                .setFontSize(14)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(new DeviceRgb(212, 212, 212))
                .setFontColor(new DeviceRgb(0, 0, 0))
                .setFont(fontServicePdf.Roboto())
                .setPadding(10);

    }

    public Cell titularesGaramnod() {

        return new Cell()
                .setFont(fontServicePdf.Garamond())
                .setFontSize(14)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER)
                .setFontColor(new DeviceRgb(0, 0, 0))
                .setBackgroundColor(new DeviceRgb(212, 212, 212))
                .setPadding(5);
        

    }

    public Cell celdasBasicas() {
        return new Cell()
                .setFont(fontServicePdf.robotoRegular())
                .setFontSize(12);

    }
}
