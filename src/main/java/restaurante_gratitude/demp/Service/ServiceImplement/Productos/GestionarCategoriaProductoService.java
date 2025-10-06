/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.DTOS.Request.Productos.Categoria.CategoriaProductoDto;
import restaurante_gratitude.demp.Entidades.Productos.Categoria;
import restaurante_gratitude.demp.Repositorys.Productos.CategoriaProductoRepository;
import restaurante_gratitude.demp.Service.Productos.GestionarCategoriaProductos;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarCategoriaProductoService implements GestionarCategoriaProductos {

    private CategoriaProductoRepository categoriaRepository;

    @Autowired
    public GestionarCategoriaProductoService(CategoriaProductoRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public GestionarCategoriaProductoService() {
    }

    @Override
    public CategoriaProductoDto agregarCategoria(CategoriaProductoDto categoriaProductoDto) {

        ValidacionesGlobales.validarExistencia(
                categoriaRepository
                        .findBynobre(categoriaProductoDto.getNombre()),
                "La categoria: " + categoriaProductoDto.getNombre()
                + " ingresada ya se encuentra en el sistema."
                + "Le invitamos a ingresar una valida.");

        Categoria categoria = new Categoria();

        categoria.setNobre(categoriaProductoDto.getNombre());
        categoriaRepository.save(categoria);

        return categoriaProductoDto;

    }

}
