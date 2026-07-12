/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Rol;

import java.util.ArrayList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Request.Rol.RolDtoReq;
import restaurante_gratitude.demp.DTOS.Response.Rol.DetailsRolDtoResp;
import restaurante_gratitude.demp.DTOS.Response.Rol.RolDtoresponse;
import restaurante_gratitude.demp.Entidades.Roles.Rol;

/**
 *
 * @author Usuario
 */
public interface GestionarRoles {

    public void crearRol(RolDtoReq rolDto);

    public PageResponse<RolDtoresponse> findAll(String nombre, boolean isDelete, Pageable pageable);

    public DetailsRolDtoResp getDetailsRol(Integer id);

    public BasicResponseDto updateByid(Integer id, RolDtoReq dtoReq);
}
