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
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.DTOS.Response.Rol.DetailsRolDtoResp;
import restaurante_gratitude.demp.DTOS.Response.Rol.RolDtoresponse;

import restaurante_gratitude.demp.Entidades.Roles.Rol;

/**
 *
 * @author User
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByNombreIgnoreCase(String nombre);

    @Query("SELECT new restaurante_gratitude.demp.DTOS.Response.Rol.RolDtoresponse("
            + " r.id,"
            + " r.nombre,"
            + " r.isDelete"
            + ", r.description,"
            + "r.createAt,"
            + "r.updateAt,"
            + "r.createBy"
            + ") "
            + "FROM  Rol r "
            + "WHERE (r.nombre LIKE CONCAT (:nombre,'%') OR :nombre IS NULL ) "
            + "AND (r.isDelete = :isDelete)")
    public Page<RolDtoresponse> findAll(
            @Param(value = "nombre") String nombre,
            @Param(value = "isDelete") boolean isDelete,
            Pageable pageable);

    @Query("SELECT new restaurante_gratitude.demp.DTOS.Response.Rol.DetailsRolDtoResp("
            + " r.deleteAt,"
            + " r.creatorName,"
            + " r.updateBy"
            + ", r.updateName,"
            + "r.deleteBy,"
            + "r.deleteName"
            + ") "
            + "FROM  Rol r "
            + "WHERE (r.id = :id)")
    public Optional<DetailsRolDtoResp> getDetails(
            @Param(value = "id") Integer id);

}
