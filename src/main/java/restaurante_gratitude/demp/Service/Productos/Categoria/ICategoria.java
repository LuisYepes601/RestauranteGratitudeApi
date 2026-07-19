/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Productos.Categoria;

import org.springframework.data.domain.Pageable;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Request.Productos.Categoria.CategoriaProductoDto;
import restaurante_gratitude.demp.DTOS.Response.Productos.Categoria.CategoryDetailsDto;
import restaurante_gratitude.demp.DTOS.Response.Productos.Categoria.CategoryDtoResponse;

/**
 *
 * @author luis
 */
public interface ICategoria {

    public BasicResponseDto createCategory(CategoriaProductoDto categoriaProductoDto);

    public PageResponse<CategoryDtoResponse> findAll(String name, Boolean isDelete, Pageable pageable);

    public BasicResponseDto updateCategoryById(Integer id, CategoriaProductoDto categoriaProductoDto);

    public BasicResponseDto deleteById(Integer id);

    public BasicResponseDto activateById(Integer id);

    public CategoryDetailsDto getDetailsById(Integer id);

}
