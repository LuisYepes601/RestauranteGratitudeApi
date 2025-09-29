/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionarCorreos;

import java.util.List;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.Service.CorreosGestion.GestionarCorreos;

/**
 *
 * @author User
 */
@Service
public class GestionarCorreosService implements GestionarCorreos {

    private JavaMailSender mailSender;

    @Override
    public String enviarCorreoSimple(String para, String remitente, String asunto, String body) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(remitente);
        simpleMailMessage.setTo(para);
        simpleMailMessage.setSubject(asunto);
        simpleMailMessage.setText(body);
        simpleMailMessage.setReplyTo(remitente);

        mailSender.send(simpleMailMessage);

        String mensaje = "El correo ha sido enviado con exito a la siguiente dirección: " + para;

        return mensaje;
    }

    @Override
    public String enviarCorreoSimpleManyDestinatarios(List<String> destinatarios, String remitente, String asunto, String body) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setBcc(destinatarios.toArray(new String[0]));
        simpleMailMessage.setFrom(remitente);
        simpleMailMessage.setSubject(asunto);
        simpleMailMessage.setText(body);
        simpleMailMessage.setReplyTo(remitente);

        mailSender.send(simpleMailMessage);

        String mensaje = "Los correos han sido enviado con exito.";

        return mensaje;
    }

    @Override
    public String enviarCorreoConFormatoRobusto(String para, String asunto, String body, String remitente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
