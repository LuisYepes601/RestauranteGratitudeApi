/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Inventario;

import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Request.Inventario.StockDto;
import restaurante_gratitude.demp.DTOS.Response.Inventario.InventarioDetailsDtoResp;
import restaurante_gratitude.demp.DTOS.Response.Inventario.inventarioDtoResponse;

/**
 *
 * @author luis
 */
public interface IInventario {

    public void addProduct(StockDto dto);

    public PageResponse<inventarioDtoResponse> getAll(
            String nombre,
            Integer category,
            Boolean isDelete,
            Double precioMin,
            Double precioMax,
            Pageable pageable);

    public BasicResponseDto deleteProduct(Integer id);

    public InventarioDetailsDtoResp detailsProdcutInventary(Integer id_product);

    public BasicResponseDto activateProduct(Integer id);

}
