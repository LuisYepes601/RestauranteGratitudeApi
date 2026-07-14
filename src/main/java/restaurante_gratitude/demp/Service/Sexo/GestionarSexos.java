/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Sexo;

import org.springframework.data.domain.Pageable;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Request.Sexo.SexoDto;
import restaurante_gratitude.demp.DTOS.Response.Sexo.SexoDetailsDto;
import restaurante_gratitude.demp.DTOS.Response.Sexo.SexoResponseDto;

/**
 *
 * @author User
 */
public interface GestionarSexos {

    public BasicResponseDto agregarSexo(SexoDto sexoDto);

    public PageResponse<SexoResponseDto> getAll(String nombre, boolean isDelete, Pageable pageable);

    public BasicResponseDto updateById(Integer id, SexoDto sexoDto);

    public BasicResponseDto deleteById(Integer id);

    public BasicResponseDto activateById(Integer id);

    public SexoDetailsDto getDetails(Integer id);

}
