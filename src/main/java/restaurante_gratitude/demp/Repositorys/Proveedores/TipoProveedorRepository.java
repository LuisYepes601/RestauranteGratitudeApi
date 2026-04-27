/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.Proveedores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.Proveedores.TipoProveedor;

/**
 *
 * @author Usuario
 */
@Repository
public interface TipoProveedorRepository extends JpaRepository<TipoProveedor, Integer> {
    
}
