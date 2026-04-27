/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Pedido;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.DTOS.PedidoDto.DetallePedidoDto;
import restaurante_gratitude.demp.DTOS.PedidoDto.PedidoDto;
import restaurante_gratitude.demp.Entidades.Pedidos.DetallePedido;
import restaurante_gratitude.demp.Entidades.Pedidos.DetallePedidoId;
import restaurante_gratitude.demp.Entidades.Pedidos.EstadoPedido;
import restaurante_gratitude.demp.Entidades.Pedidos.Pedido;
import restaurante_gratitude.demp.Entidades.Pedidos.TipoPedido;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Pedidos.DetallePedidoRepository;
import restaurante_gratitude.demp.Repositorys.Pedidos.EstadoPedidoRepository;
import restaurante_gratitude.demp.Repositorys.Pedidos.PedidoRepository;
import restaurante_gratitude.demp.Repositorys.Pedidos.TipoPedidoRepository;
import restaurante_gratitude.demp.Repositorys.Productos.ProductoRepository;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Pedidos.CrearPedido;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarCorreos.GestionarCorreosService;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarPlantillas.PedidoExitosoSeviceTemplate;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class crearPedidoService implements CrearPedido {

    private UsuarioRepository usuarioRepo;
    private ProductoRepository productoRepo;
    private DetallePedidoRepository detallePedidoRepo;
    private PedidoRepository pedidoRepo;
    private EstadoPedidoRepository estadoPedidoRepository;
    private TipoPedidoRepository tipoPedidoRepository;
    private GestionarCorreosService pedidoCorreo;
    private PedidoExitosoSeviceTemplate pedidoTemplate;

    @Autowired
    public crearPedidoService(UsuarioRepository usuarioRepo, ProductoRepository productoRepo, DetallePedidoRepository detallePedidoRepo, PedidoRepository pedidoRepo, EstadoPedidoRepository estadoPedidoRepository, TipoPedidoRepository tipoPedidoRepository, GestionarCorreosService pedidoCorreo, PedidoExitosoSeviceTemplate pedidoTemplate) {
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
        this.detallePedidoRepo = detallePedidoRepo;
        this.pedidoRepo = pedidoRepo;
        this.estadoPedidoRepository = estadoPedidoRepository;
        this.tipoPedidoRepository = tipoPedidoRepository;
        this.pedidoCorreo = pedidoCorreo;
        this.pedidoTemplate = pedidoTemplate;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void crearPedido(PedidoDto pedidoDto) {

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(
                usuarioRepo.findById(pedidoDto.getId_usuario()),
                "Error al realizar el pedido, el usuario no se encuentra disponible en el sistema."
        );

        Pedido pedido = new Pedido();
        pedido.setFechaPedido(new Date());

        EstadoPedido estadoPedido = ValidacionesGlobales.obtenerSiExiste(
                estadoPedidoRepository.findByNombre("Pendiente"),
                "Error al realizar el pedido, el estado Pendiente no está disponible"
        );
        pedido.setEstadoPedido(estadoPedido);

        TipoPedido tipoPedido = ValidacionesGlobales.obtenerSiExiste(
                tipoPedidoRepository.findByNombre("Online"),
                "Error no hay tipos de pedidos en el sistema."
        );
        pedido.setTipoPedido(tipoPedido);

        pedido.setUsuario(usuario);
        pedido.setTotal(0.0);      // temporal, luego calculamos
        pedido.setTotalItems(0);   // temporal, luego calculamos

        pedidoRepo.save(pedido); // Guardamos para obtener el ID

        double total = 0;
        int totalItems = 0;

        // 2️⃣ Crear detalles del pedido
        for (DetallePedidoDto item : pedidoDto.getDetalles()) {

            Producto producto = ValidacionesGlobales.obtenerSiExiste(
                    productoRepo.findById(item.getId_producto()),
                    "Error: uno o más productos no están disponibles."
            );

            DetallePedido detallePedido = new DetallePedido();
            DetallePedidoId detalleId = new DetallePedidoId();
            detalleId.setId_producto(producto.getId());
            detalleId.setId_pedido(pedido.getId()); // Ahora tenemos el id del pedido

            detallePedido.setDetallePedidoId(detalleId);
            detallePedido.setCantidad(item.getCantidad());
            detallePedido.setDecripcion(producto.getDescripcion());
            detallePedido.setFechaPedido(pedido.getFechaPedido());
            detallePedido.setPrecioUnidad(producto.getPrecio());
            detallePedido.setPedido(pedido);
            detallePedido.setProducto(producto);

            double subtotal = producto.getPrecio() * item.getCantidad();
            total += subtotal;
            totalItems += 1;
            detallePedido.setSubTotal(subtotal);
            detallePedido.setTotal(total);

            detallePedidoRepo.save(detallePedido);
        }

        pedido.setTotal(total);
        pedido.setTotalItems(totalItems);

        pedidoRepo.save(pedido);

        String body = pedidoTemplate.pedidoExitoso(usuario, pedido);

        pedidoCorreo.enviarCorreoConFormatoHtml(
                usuario.getEmail(),
                "Pedido realizado con exito",
                body,
                "yepesluis006@gmail.com");

    }

}
