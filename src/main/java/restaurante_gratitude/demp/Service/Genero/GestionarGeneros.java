/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Genero;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Request.Genero.GeneroDto;
import restaurante_gratitude.demp.DTOS.Response.Genero.generoDetailsDto;

/**
 *
 * @author Usuario
 */
public interface GestionarGeneros {

    public void crearGenero(GeneroDto generoDto);

    public PageResponse<GeneroDto> getGeneros(String name, boolean isDelete, Pageable pageable);

    public void updateGenreById(Integer id, GeneroDto dto);

    public void deleteGenreById(Integer id);

    public void activate(Integer id);

    public generoDetailsDto getDeatails(Integer id);
}
