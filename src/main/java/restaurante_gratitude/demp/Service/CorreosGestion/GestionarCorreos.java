/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.CorreosGestion;

import java.util.List;
import org.springframework.core.io.ByteArrayResource;

/**
 *
 * @author User
 */
public interface GestionarCorreos {

    public String enviarCorreoSimple(String para, String remitente, String asunto, String body, String mensaje);

    public String enviarCorreoSimpleManyDestinatarios(List<String> destinatarios, String remitente, String asunto, String body, String mensaje);

    public String enviarCorreoConFormatoRobusto(
            String para, String asunto, String body, String remitente, ByteArrayResource byteArrayResource, String mensaje);

    public void enviarCorreoConFormatoHtml(String para, String asunto, String body, String remitente);

}
