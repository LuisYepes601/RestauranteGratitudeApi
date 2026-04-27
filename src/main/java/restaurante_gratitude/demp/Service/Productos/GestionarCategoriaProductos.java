/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Productos;

import java.util.List;
import restaurante_gratitude.demp.DTOS.Request.Productos.Categoria.CategoriaProductoDto;

/**
 *
 * @author Usuario
 */
public interface GestionarCategoriaProductos {

    public CategoriaProductoDto agregarCategoria(CategoriaProductoDto categoriaProductoDto);

    public List<CategoriaProductoDto> obtnerCategorias();
}
