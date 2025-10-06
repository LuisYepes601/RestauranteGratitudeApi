/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionarPlantillas;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author Usuario
 */
@Service
public class CambioDeContraseñaServiceTemplate {

    private TemplateEngine templateEngine;

    @Autowired
    public CambioDeContraseñaServiceTemplate(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String ObtenerCambioContraseñaTemplate(Usuario usuario) {

        Context context = new Context();

        Map<String, Object> variables = new HashMap<>();

        variables.put("nombreUsuario", usuario.getPrimerNombre());

        context.setVariables(variables);

        return templateEngine.process("CambioDeContraseña", context);
    }

}
