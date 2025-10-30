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
import restaurante_gratitude.demp.Entidades.Pedidos.Pedido;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author Usuario
 */
@Service
public class PedidoExitosoSeviceTemplate {

    private TemplateEngine templateEngine;

    @Autowired
    public PedidoExitosoSeviceTemplate(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String pedidoExitoso(Usuario usuario, Pedido pedido) {

        Context context = new Context();

        Map<String, Object> propiedades = new HashMap<>();

        propiedades.put("nombre", usuario.getPrimerNombre());
        propiedades.put("pedidoId", pedido.getId());
        propiedades.put("detalles", pedido.getDetalles());
        propiedades.put("total", pedido.getTotal());
        context.setVariables(propiedades);

        String html = templateEngine.process("PedidoRealizado", context);
        return html;

    }

}
