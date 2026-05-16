/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Rol;

import java.util.ArrayList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import restaurante_gratitude.demp.DTOS.Request.Rol.RolDto;
import restaurante_gratitude.demp.Entidades.Roles.Rol;

/**
 *
 * @author Usuario
 */
public interface GestionarRoles {

    public RolDto crearRol(RolDto rolDto);
    public Page<Rol>finbyName(String nombre, Pageable pageable);
}
