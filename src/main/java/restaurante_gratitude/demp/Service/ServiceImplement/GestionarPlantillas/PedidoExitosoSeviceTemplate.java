/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionarPlantillas;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import restaurante_gratitude.demp.Entidades.Pedidos.DetallePedido;
import restaurante_gratitude.demp.Entidades.Pedidos.Pedido;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
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

    // FORZAR CARGA DE DETALLES (DOBLE SEGURIDAD)
    if (pedido.getDetalles() != null) {
        Hibernate.initialize(pedido.getDetalles());
    }

    List<DetallePedido> detalles = pedido.getDetalles();
    if (detalles == null || detalles.isEmpty()) {
        // AGREGAR MOCK PARA PRUEBA
        detalles = new ArrayList<>();
        DetallePedido mock = new DetallePedido();
        Producto p = new Producto();
        p.setNombre("Torta de Chocolate");
        p.setImagen("https://via.placeholder.com/50");
        mock.setProducto(p);
        mock.setCantidad(1);
        mock.setPrecioUnidad(15000.0);
        detalles.add(mock);
    }

    context.setVariable("nombre", usuario.getPrimerNombre());
    context.setVariable("pedidoId", pedido.getId());
    context.setVariable("detalles", detalles);
    context.setVariable("total", pedido.getTotal());

    return templateEngine.process("PedidoRealizado", context);
}

}
