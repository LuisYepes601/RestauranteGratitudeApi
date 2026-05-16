/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.Roles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.Roles.Rol;

/**
 *
 * @author User
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByNombre(String nombre);

    Optional<Rol> findBycodigoRol(String codigoRol);

    @Query("SELECT r.nombre FROM Rol r"
            + " WHERE (r.nombre = :nombre OR :nombre IS NULL)")
    public Page<Rol> findByName(String nombre, Pageable pageable);

}
