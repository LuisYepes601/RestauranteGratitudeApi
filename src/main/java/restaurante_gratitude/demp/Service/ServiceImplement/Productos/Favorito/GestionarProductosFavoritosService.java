/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos.Favorito;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.DTOS.Request.ProductosFavoritos.ProductoFavoritoDtoRegistrar;
import restaurante_gratitude.demp.DTOS.Request.ProductosFavoritos.ProductoFavoritoEliminarDto;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
import restaurante_gratitude.demp.Entidades.Productos.ProductosFavoritos;
import restaurante_gratitude.demp.Entidades.Productos.ProductosFavoritosId;
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
        
        Optional<ProductosFavoritos> productoFav = productosFvoritosRepo.findById(
                new ProductosFavoritosId(usuario.getId(), producto.getId()
                ));
        
        ProductosFavoritos productosFavoritos = new ProductosFavoritos();
        
        if (productoFav.isEmpty()) {
            
            productosFavoritos.setProducto(producto);
            productosFavoritos.setUsuario(usuario);
            productosFavoritos.setFecha(LocalDate.now());
            
        }
        
        if (productoFav.isPresent()) {
            
            productosFavoritos = productoFav.get();
            productosFavoritos.setFecha(LocalDate.now());
            productosFavoritos.setIsDelete(false);
        }
        
        productosFvoritosRepo.save(productosFavoritos);
        
        return usuario.getPrimerNombre() + " haz agregado el producto: " + producto.getNombre() + " a  la lista de tus favoritos.";
        
    }
    
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void eliminarProductoFavorito(ProductoFavoritoEliminarDto ProductoFavoritoEliminarDto) {
        
        ProductosFavoritos productosFavoritos = ValidacionesGlobales.obtenerSiExiste(
                productosFvoritosRepo.findById(new ProductosFavoritosId(
                        ProductoFavoritoEliminarDto.getId_usuario(),
                        ProductoFavoritoEliminarDto.getId_producto())),
                "Error. El producto seleccionado no esta entre tus favoritos. ");
        
        productosFavoritos.setIsDelete(true);
        productosFavoritos.setFecha_eliminacion(LocalDate.now());
        productosFvoritosRepo.save(productosFavoritos);
        
    }
    
}
