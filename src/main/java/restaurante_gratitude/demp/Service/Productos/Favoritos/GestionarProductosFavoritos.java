/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Productos.Favoritos;

import restaurante_gratitude.demp.DTOS.Request.ProductosFavoritos.ProductoFavoritoDtoRegistrar;
import restaurante_gratitude.demp.DTOS.Request.ProductosFavoritos.ProductoFavoritoEliminarDto;

/**
 *
 * @author User
 */
public interface GestionarProductosFavoritos {

    public String agregarProductoFavorito(ProductoFavoritoDtoRegistrar favoritoDtoRegistrar);
    
    public void eliminarProductoFavorito(ProductoFavoritoEliminarDto productoFavoritoEliminarDto);

}
