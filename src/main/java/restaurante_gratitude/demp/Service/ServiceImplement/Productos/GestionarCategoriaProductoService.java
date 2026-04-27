/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
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

    @Override
    public List<CategoriaProductoDto> obtnerCategorias() {

        List<Categoria> categorias = categoriaRepository.findAll();

        if (categorias.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay categorias disponibles en el sistema.");
        }

        List<CategoriaProductoDto> categoriaProductoDtos = new ArrayList<>();
        CategoriaProductoDto categoriaProductoDto = new CategoriaProductoDto();

        for (Categoria categoria : categorias) {
            categoriaProductoDto.setNombre(categoria.getNobre());

            categoriaProductoDtos.add(categoriaProductoDto);
        }

        return categoriaProductoDtos;

    }

}
