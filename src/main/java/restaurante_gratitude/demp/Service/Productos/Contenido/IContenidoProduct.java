/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Productos.Contenido;

import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.Request.Productos.Contenido.ContenidoDto;
import restaurante_gratitude.demp.Entidades.Productos.Contenido;
import restaurante_gratitude.demp.Entidades.Productos.Producto;

/**
 *
 * @author luis
 */
public interface IContenidoProduct {

    public Contenido create(ContenidoDto contenidoDto);

    public Contenido updateByiD(
            Producto producto,
            Integer idTipoContent, String valor,
            Integer idContent);

    public BasicResponseDto deleteById(Integer id);
}
