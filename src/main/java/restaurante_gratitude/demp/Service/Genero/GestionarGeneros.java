/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Genero;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import restaurante_gratitude.demp.DTOS.Request.Genero.GeneroDto;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Genero;

/**
 *
 * @author Usuario
 */
public interface GestionarGeneros {

    public GeneroDto crearGenero(GeneroDto generoDto);

    public Page<GeneroDto> getGeneros(String name, Pageable pageable);

}
