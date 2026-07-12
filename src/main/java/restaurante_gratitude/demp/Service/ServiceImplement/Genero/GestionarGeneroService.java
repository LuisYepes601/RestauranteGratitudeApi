/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Genero;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import restaurante_gratitude.demp.DTOS.Request.Genero.GeneroDto;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Genero;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.GeneroRepository;
import restaurante_gratitude.demp.Service.Genero.GestionarGeneros;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoInvalidoException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoNoExistenteEcxeption;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoYaExistenteException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Response.Genero.generoDetailsDto;

/**
 *
 * @author Usuario
 */
@Service(value = "generoService")
public class GestionarGeneroService implements GestionarGeneros {

    private GeneroRepository generoRepo;

    @Autowired
    public GestionarGeneroService(GeneroRepository generoRepo) {
        this.generoRepo = generoRepo;
    }

    public GeneroRepository getGeneroRepo() {
        return generoRepo;
    }

    public void setGeneroRepo(GeneroRepository generoRepo) {
        this.generoRepo = generoRepo;
    }

    @CacheEvict(value = "generos",
            allEntries = true)
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void crearGenero(GeneroDto generoDto) {

        Optional<Genero> optional = generoRepo.findByNombreIgnoreCase(generoDto.getNombre());

        Genero genero;

        if (optional.isEmpty()) {

            genero = new Genero();
            genero.setNombre(generoDto.getNombre());
            genero.setCreateAt(LocalDateTime.now());
            genero.setCreateBy("YEPESLUIS006@GMAIL.COM");
            genero.setCreatorName("luis yepes");
            genero.setUpdateName("Luis YEPPES");
            genero.setUpdateBy("YEPESLUIS006@GMAIL.COM");

            if (generoDto.getDescription() != null) {

                genero.setDescription(generoDto.getDescription());
            }

            generoRepo.save(genero);
            return;
        }

        genero = optional.get();

        if (genero.isIsDelete()) {

            genero.setIsDelete(false);
            genero.setCreateAt(LocalDateTime.now());
            genero.setCreateBy("YEPESLUIS006@GMAIL.COM");
            genero.setCreatorName("luis yepes");

            if (genero.getDescription() != null) {

                genero.setDescription(generoDto.getDescription());
            }
            generoRepo.save(genero);
        } else {
            throw new DatoYaExistenteException("El genero ya existe en el sistema.");
        }

    }

    @Cacheable(value = "generos")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageResponse<GeneroDto> getGeneros(String name, boolean isDelete, Pageable pageable) {

        Page<GeneroDto> page = generoRepo.generos(name, isDelete, pageable);

        if (page.isEmpty()) {

            throw new NoDatosQueMostrarExecption("No hay generos que mostrar...");
        }

        PageResponse<GeneroDto> pageResponse = new PageResponse();

        pageResponse.setContent(page.getContent());
        pageResponse.setEmpty(page.isEmpty());
        pageResponse.setNumber(page.getNumber());
        pageResponse.setNumberOfElements(page.getNumberOfElements());
        pageResponse.setPageNumber(page.getPageable().getPageNumber());
        pageResponse.setPageSize(page.getPageable().getPageSize());
        pageResponse.setSize(page.getSize());
        pageResponse.setTotalElements(page.getTotalElements());
        pageResponse.setTotalPages(page.getTotalPages());

        return pageResponse;

    }

    @Caching(
            put = {
                @CachePut(value = "genero", key = "#id"),
                @CachePut(value = "genero-detail", key = "#id")
            },
            evict = {
                @CacheEvict(value = "generos", allEntries = true),
                @CacheEvict(value = "genero-detail", key = "#id")
            })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateGenreById(Integer id, GeneroDto dto) {

        Optional<Genero> optional = generoRepo.findById(id);

        if (optional.isEmpty()) {

            throw new DatoNoExistenteEcxeption("El genero no se encuentra en el sistema");
        }

        Genero genero = optional.get();

        Optional<Genero> existe = generoRepo.findByNombreIgnoreCase(dto.getNombre());

        if (existe.isPresent()
                && existe.get().getId() != genero.getId()) {

            throw new DatoYaExistenteException("Ya existe un genero con ese nombre en el sistema.");

        }

        genero.setNombre(dto.getNombre());
        genero.setUpdateBy("YEPESLUIS008@GMAIL.COM");
        genero.setUpdateName("LUIS YEPES");

        if (dto.getDescription() != null) {

            genero.setDescription(dto.getDescription());

            System.out.println(dto.getDescription());
        }

        generoRepo.save(genero);

    }

    @Caching(evict = {
        @CacheEvict(value = "generos", allEntries = true),
        @CacheEvict(value = "genero-detail", key = "#id")
    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteGenreById(Integer id) {

        Optional<Genero> optional = generoRepo.findById(id);

        if (optional.isEmpty()) {

            throw new DatoNoExistenteEcxeption("El genero no existe en el sistema");
        }

        Genero genero = optional.get();

        if (genero.isIsDelete()) {

            throw new DatoNoExistenteEcxeption("El genero no existe en el sistema");

        }

        genero.setIsDelete(true);
        genero.setDeleteAt(LocalDateTime.now());
        genero.setDeleteName("LUIS YEPES");
        genero.setDeleteBy("LUIS YEPES");
        genero.setUpdateName("Luis YEPPES");
        genero.setUpdateBy("YEPESLUIS006@GMAIL.COM");

        generoRepo.save(genero);
    }

    @CacheEvict(value = "generos",
            allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void activate(Integer id) {

        Optional<Genero> optional = generoRepo.findById(id);

        if (optional.isEmpty()) {

            throw new DatoNoExistenteEcxeption("El genero seleccionado no existe en el sistema.");
        }

        Genero genero = optional.get();

        if (!genero.isIsDelete()) {

            throw new DatoInvalidoException("El genero ya se encuentra activo en el sistema.");
        }

        genero.setIsDelete(false);
        genero.setUpdateName("Luis YEPPES");
        genero.setUpdateBy("YEPESLUIS006@GMAIL.COM");

        generoRepo.save(genero);

    }

    @Cacheable(value = "genero-detail", key = "#id")
    @Transactional(readOnly = true)
    @Override
    public generoDetailsDto getDeatails(Integer id) {

        return generoRepo.getDetailById(id).
                orElseThrow(() -> new DatoNoExistenteEcxeption("El genero no existe en el sistema"));
    }

}
