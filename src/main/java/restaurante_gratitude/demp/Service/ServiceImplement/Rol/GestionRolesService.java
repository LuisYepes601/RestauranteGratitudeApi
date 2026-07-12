/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Rol;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoNoExistenteEcxeption;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoYaExistenteException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Request.Rol.RolDtoReq;
import restaurante_gratitude.demp.DTOS.Response.Rol.DetailsRolDtoResp;
import restaurante_gratitude.demp.DTOS.Response.Rol.RolDtoresponse;
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

    @CacheEvict(value = "roles",
            allEntries = true)
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void crearRol(RolDtoReq rolDto) {

        Optional<Rol> optional = rolrepo.findByNombreIgnoreCase(rolDto.getNombre().trim());

        Rol rol;

        if (optional.isPresent()) {

            rol = optional.get();

            if (rol.isIsDelete()) {

                rol.setIsDelete(false);
                rol.setCreateAt(LocalDateTime.now());
                rol.setUpdateBy("luis");
                rol.setUpdateName("luis");
                rol.setCreatorName("luis");
                rol.setCreateBy("yepes");

                rolrepo.save(rol);
                return;

            } else {
                throw new DatoYaExistenteException("El rol: " + rolDto.getNombre() + " ya se encuentra en el sistema.");

            }

        }

        rol = new Rol();

        rol.setCreateAt(LocalDateTime.now());
        rol.setNombre(rolDto.getNombre());
        rol.setCreateBy("yepes");
        rol.setCreatorName("luis");
        rol.setUpdateBy("luis");
        rol.setUpdateName("luis");

        if (rolDto.getDescription() != null) {
            rol.setDescription(rolDto.getDescription());
        }

        rolrepo.save(rol);
        return;

    }

    @Cacheable(value = "roles")
    @Override
    @Transactional(readOnly = true)
    public PageResponse<RolDtoresponse> findAll(String nombre,
            boolean isDelete, Pageable pageable) {

        Page<RolDtoresponse> roles = rolrepo.findAll(
                nombre,
                isDelete,
                pageable);

        PageResponse<RolDtoresponse> pageResponse = new PageResponse<>();

        pageResponse.setContent(roles.getContent());
        pageResponse.setEmpty(roles.isEmpty());
        pageResponse.setNumber(roles.getNumber());
        pageResponse.setNumberOfElements(roles.getNumberOfElements());
        pageResponse.setPageNumber(roles.getPageable().getPageNumber());
        pageResponse.setPageSize(roles.getPageable().getPageSize());
        pageResponse.setSize(roles.getSize());
        pageResponse.setTotalElements(roles.getTotalElements());
        pageResponse.setTotalPages(roles.getTotalPages());

        if (roles.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay roles que mostrar.");
        }
        return pageResponse;

    }

    @Cacheable(value = "rol-detail", key = "#id")
    @Transactional(readOnly = true)
    @Override
    public DetailsRolDtoResp getDetailsRol(Integer id) {

        DetailsRolDtoResp detailsRolDtoResp = rolrepo.getDetails(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("Error el rol no exite en el sistema."));

        return detailsRolDtoResp;

    }

    @Caching(evict = {
        @CacheEvict(value = "roles", allEntries = true)
    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto updateByid(Integer id, RolDtoReq dtoReq) {

        Rol rol = rolrepo.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El rol no existe en el sistema"));

        if (rol.isIsDelete()) {

            throw new DatoNoExistenteEcxeption("El rol no existe en el sistema");
        }

        Rol rol1 = rolrepo.findByNombreIgnoreCase(dtoReq.getNombre().trim())
                .orElseThrow(() -> new DatoNoExistenteEcxeption("Error el rol no exite en el sistema."));

        if (rol1.getNombre().toUpperCase().contains(dtoReq.getNombre().trim().toLowerCase())
                && rol1.getId() != rol.getId()) {

            throw new DatoYaExistenteException("El rol ya existe en el sistema");
        }

        if (dtoReq.getDescription() != null) {
            rol.setDescription(dtoReq.getDescription());
        }

        rol.setNombre(dtoReq.getNombre());
        rol.setUpdateBy("luis");
        rol.setUpdateName("luyis");

        rolrepo.save(rol);

        return new BasicResponseDto("El Rol " + rol.getNombre() + " ha sisdo actualizado correctamente");

    }

    @Override
    public BasicResponseDto deleteById(Integer id) {

        Rol rol = rolrepo.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El rol no se encuentra en el sistema"));

        if (rol.isIsDelete()) {

            throw new DatoNoExistenteEcxeption("El rol no se encuentra en el sistema");
        }

        rol.setIsDelete(true);
        rol.setDeleteAt(LocalDateTime.now());
        rol.setDeleteBy("ll");
        rol.setDeleteName("llll");
        rol.setUpdateBy("dddd");
        rol.setUpdateName("hhhh");

        return new BasicResponseDto("El rol " + rol.getNombre().toUpperCase() + " ha sido eliminado del sistema.");
    }

}
