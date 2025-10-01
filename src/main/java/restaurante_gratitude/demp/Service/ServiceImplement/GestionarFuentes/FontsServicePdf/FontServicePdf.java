/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionarFuentes.FontsServicePdf;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoNoExistenteEcxeption;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarFuentes.FontsService;

/**
 *
 * @author User
 */
@Service
public class FontServicePdf {

    private FontsService fontsService;

    @Autowired
    public FontServicePdf(FontsService fontsService) {
        this.fontsService = fontsService;
    }

    public FontServicePdf() {
    }

    public PdfFont Roboto() {

        try {
            FontProgram fontProgram = FontProgramFactory.createFont(fontsService.Roboto());
            PdfFont pdfFont = PdfFontFactory.createFont(fontProgram);
            return pdfFont;

        } catch (IOException ex) {
            throw new DatoNoExistenteEcxeption("El tipo de fuente no se encuentra disponible en "
                    + "este momento lo invitamos a intentarlo nuevamente.");
        }

    }

    public PdfFont robotoRegular() {
        FontProgram fontProgram;
        try {
            fontProgram = FontProgramFactory.createFont(fontsService.robotoRegular());

            PdfFont pdfFont = PdfFontFactory.createFont(fontProgram);
            return pdfFont;
        } catch (IOException ex) {
            throw new DatoNoExistenteEcxeption("El tipo de fuente no se encuentra disponible en "
                    + "este momento lo invitamos a intentarlo nuevamente.");
        }
    }

    public PdfFont Garamond() {
        try {
            FontProgram garamond = FontProgramFactory.createFont(fontsService.Garamond());
            PdfFont pdfFont = PdfFontFactory.createFont(garamond);
            return pdfFont;

        } catch (IOException ex) {
            throw new DatoNoExistenteEcxeption("El tipo de fuente no se encuentra disponible en "
                    + "este momento lo invitamos a intentarlo nuevamente.");
        }

    }
}
