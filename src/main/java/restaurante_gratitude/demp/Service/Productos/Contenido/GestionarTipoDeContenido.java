/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Productos.Contenido;

import org.springframework.data.domain.Pageable;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Request.Productos.Contenido.TipoContenidoDto;
import restaurante_gratitude.demp.DTOS.Response.Productos.Contenido.TipoContenidoDtoResponse;

/**
 *
 * @author Usuario
 */
public interface GestionarTipoDeContenido {
    
    public BasicResponseDto crearTipoDeContenido(TipoContenidoDto tipoContenidoDto);
        
    public PageResponse<TipoContenidoDtoResponse>getAll(String nombre, Boolean isDelete, Pageable pageable);
      
}
