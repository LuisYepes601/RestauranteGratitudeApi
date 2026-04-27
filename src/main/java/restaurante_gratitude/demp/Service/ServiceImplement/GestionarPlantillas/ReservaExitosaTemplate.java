/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionarPlantillas;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 *
 * @author Usuario
 */
@Service
public class ReservaExitosaTemplate {

    private TemplateEngine templateEngine;

    @Autowired
    public ReservaExitosaTemplate(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String reservaexistosa(String nombreUser, Date fecha, Date horaInicio, Date horafin, Integer mesa, String tipoReserva) {

        Context context = new Context();

        Map<String, Object> variables = new HashMap<>();

        variables.put("nombreUsuario", nombreUser);
        variables.put("fecha", fecha);
        variables.put("horaInicio", horaInicio.getTime());
        variables.put("horaFin", horafin.getTime());
        variables.put("mesa", mesa);
        variables.put("tipoReserva", tipoReserva);
        variables.put("loginUrl", "https://inicio-sesion-cqye.vercel.app/");

        context.setVariables(variables);

        String html = templateEngine.process("ReservaExitosa", context);

        return html;
    }

}
