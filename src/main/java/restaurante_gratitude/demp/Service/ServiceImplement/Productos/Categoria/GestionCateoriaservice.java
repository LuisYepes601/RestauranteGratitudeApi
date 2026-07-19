/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos.Categoria;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoNoExistenteEcxeption;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoYaExistenteException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Request.Productos.Categoria.CategoriaProductoDto;
import restaurante_gratitude.demp.DTOS.Response.Productos.Categoria.CategoryDetailsDto;
import restaurante_gratitude.demp.DTOS.Response.Productos.Categoria.CategoryDtoResponse;
import restaurante_gratitude.demp.Entidades.Auditory.Auditable;
import restaurante_gratitude.demp.Entidades.Productos.Categoria;
import restaurante_gratitude.demp.Repositorys.Productos.CategoriaProductoRepository;
import restaurante_gratitude.demp.Service.Productos.Categoria.ICategoria;
import restaurante_gratitude.demp.Utils.AuditableUtils;
import restaurante_gratitude.demp.Utils.PageResponseUtils;

/**
 *
 * @author luis
 */
@Service()
public class GestionCateoriaservice implements ICategoria {

    private CategoriaProductoRepository categoriaProductoRepository;

    @Autowired
    public GestionCateoriaservice(CategoriaProductoRepository categoriaProductoRepository) {
        this.categoriaProductoRepository = categoriaProductoRepository;
    }

    public GestionCateoriaservice() {
    }

    @CacheEvict(
            value = "categories",
            allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto createCategory(CategoriaProductoDto categoriaProductoDto) {

        Optional< Categoria> optional = categoriaProductoRepository.findByNombreIgnoreCase(categoriaProductoDto.getNombre().trim());

        if (optional.isPresent()) {

            throw new DatoYaExistenteException("La categoria ya existe en el sistema.");
        }

        Categoria categoria = new Categoria();

        categoria.setNombre(categoriaProductoDto.getNombre().trim());

        AuditableUtils.create(
                categoria,
                "prueba",
                "prueba");
        categoriaProductoRepository.save(categoria);

        if (categoriaProductoDto.getDescription() != null) {

            categoria.setDescription(categoriaProductoDto.getDescription());
        }

        return new BasicResponseDto("La categoria " + categoria.getNombre() + " ha sido agregada al sistema.");

    }

    @Cacheable(value = "categories")
    @Transactional(readOnly = true)
    @Override
    public PageResponse<CategoryDtoResponse> findAll(String name, Boolean isDelete, Pageable pageable) {

        Page<CategoryDtoResponse> page = categoriaProductoRepository.GetAll(name, isDelete, pageable);

        if (page.isEmpty()) {

            throw new NoDatosQueMostrarExecption("No hay categorias que mostrar");
        }

        PageResponse<CategoryDtoResponse> pageResponse = new PageResponse<>();

        return PageResponseUtils.CreatePageReponse(page);

    }

    @Caching(evict = {
        @CacheEvict(value = "categories", allEntries = true),
        @CacheEvict(value = "category-details", key = "#id")
    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto updateCategoryById(Integer id, CategoriaProductoDto categoriaProductoDto) {

        Categoria categoria = categoriaProductoRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La categoria a editar no existe en el sistema."));

        if (categoria.isIsDelete()) {

            throw new DatoNoExistenteEcxeption("La categoria a editar no existe en el sistema.");
        }

        Optional<Categoria> optional = categoriaProductoRepository.findByNombreIgnoreCase(categoriaProductoDto.getNombre().trim());

        if (optional.isPresent()
                && optional.get().getId() != categoria.getId()) {

            throw new DatoYaExistenteException("La categoria ya existe en el sistema.");

        }

        categoria.setNombre(categoriaProductoDto.getNombre().trim());

        if (categoriaProductoDto.getDescription() != null) {

            categoria.setDescription(categoriaProductoDto.getDescription());
        }

        AuditableUtils.update(categoria, "prueba", "prueba");

        categoriaProductoRepository.save(categoria);

        return new BasicResponseDto("La categoria ha sido actualizada con exito.");

    }

    @Caching(evict = {
        @CacheEvict(value = "categories", allEntries = true),
        @CacheEvict(value = "category-details", key = "#id")
    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto deleteById(Integer id) {

        Categoria categoria = categoriaProductoRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La categoria no exite en el sistema"));

        if (categoria.isIsDelete() == true) {

            throw new DatoNoExistenteEcxeption("La categoria no se encuentra activa en el sistema");

        }

        categoria.setIsDelete(true);
        AuditableUtils.delete(categoria, "prueba", "prueba");

        categoriaProductoRepository.save(categoria);

        return new BasicResponseDto("La categoria ha sido eliminado con exito.");

    }

    @Caching(evict = {
        @CacheEvict(value = "categories", allEntries = true),
        @CacheEvict(value = "category-details", key = "#id")
    })

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto activateById(Integer id) {

        Categoria categoria = categoriaProductoRepository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La categoria no se encuentra en el sistema."));

        if (!categoria.isIsDelete()) {

            throw new DatoYaExistenteException("La categoria ya se encuentra activa en el sistema");

        }

        categoria.setIsDelete(false);
        AuditableUtils.activate(categoria, "prueba", "prueba");

        categoriaProductoRepository.save(categoria);

        return new BasicResponseDto("La categoria ha sido activada correctamente.");

    }

    @Cacheable(value = "category-details", key = "#id")
    @Transactional(readOnly = true)
    @Override
    public CategoryDetailsDto getDetailsById(Integer id) {

        return categoriaProductoRepository.getDetails(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("La categoria no existe en el sistema."));
    }

}
