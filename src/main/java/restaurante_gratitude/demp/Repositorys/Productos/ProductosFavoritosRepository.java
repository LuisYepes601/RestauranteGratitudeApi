/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.Productos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
import restaurante_gratitude.demp.Entidades.Productos.ProductosFavoritos;
import restaurante_gratitude.demp.Entidades.Productos.ProductosFavoritosId;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author Usuario
 */
@Repository
public interface ProductosFavoritosRepository extends JpaRepository<ProductosFavoritos, ProductosFavoritosId> {

    boolean existsByUsuarioAndProducto(Usuario usuario, Producto producto);
}
