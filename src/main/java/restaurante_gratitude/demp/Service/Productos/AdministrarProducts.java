/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Productos;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.Request.Productos.CrearProductoDto;

/**
 *
 * @author luis
 */
public interface AdministrarProducts {

    public BasicResponseDto createProduct(
            MultipartFile primary,
            List<MultipartFile> gallery,
            CrearProductoDto productoDto);
}
