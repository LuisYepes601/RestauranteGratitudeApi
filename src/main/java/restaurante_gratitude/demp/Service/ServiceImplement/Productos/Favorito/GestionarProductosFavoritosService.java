/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos.Favorito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoYaExistenteException;
import restaurante_gratitude.demp.DTOS.Request.ProductosFavoritos.ProductoFavoritoDtoRegistrar;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
import restaurante_gratitude.demp.Entidades.Productos.ProductosFavoritos;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Productos.ProductoRepository;
import restaurante_gratitude.demp.Repositorys.Productos.ProductosFavoritosRepository;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Productos.Favoritos.GestionarProductosFavoritos;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class GestionarProductosFavoritosService implements GestionarProductosFavoritos {

    private UsuarioRepository usuarioRepo;
    private ProductoRepository productoRepo;
    private ProductosFavoritosRepository productosFvoritosRepo;

    @Autowired
    public GestionarProductosFavoritosService(UsuarioRepository usuarioRepo, ProductoRepository productoRepo, ProductosFavoritosRepository productosFvoritosRepo) {
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
        this.productosFvoritosRepo = productosFvoritosRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String agregarProductoFavorito(ProductoFavoritoDtoRegistrar favoritoDtoRegistrar) {

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(usuarioRepo
                .findByEmail(favoritoDtoRegistrar.getEmail_user()),
                "El usuario ingresado no se encuentra registrado o logueado en el sistema. Le invitamos a iniciar sesion.");

        Producto producto = ValidacionesGlobales.obtenerSiExiste(productoRepo.
                findById(favoritoDtoRegistrar.getId_producto()),
                "El producto seleccionado no se encuentra en el sistema actualmente. Le invitamos a intentarlo nuevamente");

        if (productosFvoritosRepo.existsByUsuarioAndProducto(usuario, producto)) {

            throw new DatoYaExistenteException("Error, el producto seleccionado ya se encuentra entre sus favoritos."
                    + " Le invitamos a seleccionar un producto valido.");
        }

        ProductosFavoritos productosFavoritos = new ProductosFavoritos();

        productosFavoritos.setProducto(producto);
        productosFavoritos.setUsuario(usuario);

        productosFvoritosRepo.save(productosFavoritos);

        return usuario.getPrimerNombre() + " haz agregado el producto: " + producto.getNombre() + " a  la lista de tus favoritos.";

    }

}
