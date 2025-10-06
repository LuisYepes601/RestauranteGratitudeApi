/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionarCorreos;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.Service.CorreosGestion.GestionarCorreos;

/**
 *
 * @author User
 */
@Service
public class GestionarCorreosService implements GestionarCorreos {

    private JavaMailSender mailSender;

    @Autowired
    public GestionarCorreosService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public JavaMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public String enviarCorreoSimple(String para, String remitente, String asunto, String body, String mensaje) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(remitente);
        simpleMailMessage.setTo(para);
        simpleMailMessage.setSubject(asunto);
        simpleMailMessage.setText(body);
        simpleMailMessage.setReplyTo(remitente);

        mailSender.send(simpleMailMessage);

        return mensaje;
    }

    @Override
    public String enviarCorreoSimpleManyDestinatarios(
            List<String> destinatarios, String remitente, String asunto, String body, String mensaje) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setBcc(destinatarios.toArray(new String[0]));
        simpleMailMessage.setFrom(remitente);
        simpleMailMessage.setSubject(asunto);
        simpleMailMessage.setText(body);
        simpleMailMessage.setReplyTo(remitente);

        mailSender.send(simpleMailMessage);

        return mensaje;
    }

    @Override
    public String enviarCorreoConFormatoRobusto(
            String para, String asunto, String body, String remitente, ByteArrayResource arrayResource,
            String mensaje) {

        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true, "UTF-8");

            mimeMessageHelper.setTo(para);
            mimeMessageHelper.setFrom(remitente);
            mimeMessageHelper.setSubject(asunto);
            mimeMessageHelper.setText(body, true);

            mimeMessageHelper.setReplyTo(remitente);

            mimeMessageHelper.addAttachment(
                    "Reporte usuarios registrados.pdf",
                    arrayResource);

            mailSender.send(message);

        } catch (MessagingException ex) {
            Logger.getLogger(GestionarCorreosService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mensaje;
    }

    @Override
    public void enviarCorreoConFormatoHtml(String para, String asunto, String body, String remitente) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setTo(para);
            messageHelper.setFrom(remitente);
            messageHelper.setReplyTo(remitente);
            messageHelper.setSubject(asunto);
            messageHelper.setText(body, true);

            FileSystemResource logo = new FileSystemResource(
                    new File("src\\main\\resources\\static\\images\\logoRestaurante.png")
            );

            messageHelper.addInline("logo", logo);

            mailSender.send(mimeMessage);

        } catch (MessagingException ex) {
            Logger.getLogger(GestionarCorreosService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
