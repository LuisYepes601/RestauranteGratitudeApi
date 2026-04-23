/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Templates;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import restaurante_gratitude.demp.Service.CorreosGestion.CrearTemplates;

/**
 *
 * @author luis
 */
@Service
public class templateService implements CrearTemplates {

    private TemplateEngine tempEngine;

    @Autowired
    public templateService(TemplateEngine tempEngine) {
        this.tempEngine = tempEngine;
    }

    @Override
    public String crearTemplate(Template template) {

        Context context = new Context();

        Map variables = template.getVariables();

        context.setVariables(variables);

        return tempEngine.process(template.getName(), context);

    }

}
