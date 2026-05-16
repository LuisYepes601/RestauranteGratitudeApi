/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Rol;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoYaExistenteException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.Request.Rol.RolDto;
import restaurante_gratitude.demp.Entidades.Roles.Rol;
import restaurante_gratitude.demp.Repositorys.Roles.RolRepository;
import restaurante_gratitude.demp.Service.Rol.GestionarRoles;

/**
 *
 * @author Usuario
 */
@Service
public class GestionRolesService implements GestionarRoles {

    private RolRepository rolrepo;

    @Autowired
    public GestionRolesService(RolRepository rolrepo) {
        this.rolrepo = rolrepo;
    }

    public GestionRolesService() {
    }

    public void setRolrepo(RolRepository rolrepo) {
        this.rolrepo = rolrepo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RolDto crearRol(RolDto rolDto) {
        Optional<Rol> optional = rolrepo.findByNombre(rolDto.getNombre());

        if (optional.isPresent()) {
            throw new DatoYaExistenteException("No se pudo crear el rol: " + rolDto.getNombre()
                    + " por que ya esta creado en el sistema. Lo invitamos a crear uno no existente");
        }

        Rol rol = new Rol();

        rol.setNombre(rolDto.getNombre());

        if (rolDto.getCodigo() != null) {
            
            rol.setCodigoRol(rolDto.getCodigo());
        }

        rolrepo.save(rol);

        return rolDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Rol> finbyName(String nombre, Pageable pageable) {

        Page<Rol> roles = rolrepo.findByName(nombre, pageable);

        if (roles.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay roles qu emostrar");
        }
        return roles;

    }

}
