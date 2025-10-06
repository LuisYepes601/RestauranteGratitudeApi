/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionarFuentes;

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

    public byte[] Roboto() {

        InputStream inputStream = getClass().getResourceAsStream(
                "/fonts/Roboto/Roboto-VariableFont_wdth,wght.ttf");

        if (inputStream == null) {
            throw new DatoNoExistenteEcxeption("El tipo de fuente no se encuentra disponible en "
                    + "este momento lo invitamos a intentarlo nuevamente.");
        }
        byte[] fuente;

        try {
            fuente = inputStream.readAllBytes();
        } catch (IOException ex) {
            throw new DatoNoExistenteEcxeption("El tipo de fuente no se encuentra disponible en "
                    + "este momento lo invitamos a intentarlo nuevamente.");
        }

        return fuente;
    }

    public byte[] robotoRegular() {
        InputStream inputStream = getClass()
                .getResourceAsStream( "/fonts/Roboto/static/Roboto-Regular.ttf");

        try {
            byte[] fuente = inputStream.readAllBytes();
            return fuente;

        } catch (IOException ex) {
            throw new DatoNoExistenteEcxeption("El tipo de fuente no se encuentra disponible en "
                    + "este momento lo invitamos a intentarlo nuevamente.");
        }
    }

    public byte[] Garamond() {

        InputStream inputStream = getClass()
                .getResourceAsStream("/fonts/EB_Garamond/EBGaramond-VariableFont_wght.ttf");

        if (inputStream == null) {
            throw new DatoNoExistenteEcxeption("El tipo de fuente no se encuentra disponible en "
                    + "este momento lo invitamos a intentarlo nuevamente.");
        }

        byte[] fuente;

        try {
            fuente = inputStream.readAllBytes();
        } catch (IOException ex) {
            throw new DatoNoExistenteEcxeption("El tipo de fuente no se encuentra disponible en "
                    + "este momento lo invitamos a intentarlo nuevamente.");
        }

        return fuente;
    }
}
