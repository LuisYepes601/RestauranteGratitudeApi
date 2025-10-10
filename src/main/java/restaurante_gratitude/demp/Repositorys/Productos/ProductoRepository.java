/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.Productos;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.Productos.Producto;

/**
 *
 * @author Usuario
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    public Optional<Producto> findByNombre(String nombre);

    public List<Optional<Producto>> findByCategoria_nobre(String nombre);

}
