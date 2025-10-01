/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionarFuentes;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoNoExistenteEcxeption;

/**
 *
 * @author Usuario
 */
@Service
public class FontsService {

    public FontsService() {
    }

    public PdfFont Roboto() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(
                "src\\main\\resources\\Fonts\\Roboto\\Roboto-VariableFont_wdth,wght.ttf");

        if (inputStream == null) {
            throw new DatoNoExistenteEcxeption("Error al cargar fuente, "
                    + "la fuente no se encuentra disponible en estos momentos, "
                    + "lo invitamos a intentarlo nuevamente");
        }

        FontProgram fontProgram = FontProgramFactory.createFont(inputStream.readAllBytes());

        PdfFont roboto = PdfFontFactory.createFont(fontProgram, PdfEncodings.WINANSI);

        return roboto;

    }
}
