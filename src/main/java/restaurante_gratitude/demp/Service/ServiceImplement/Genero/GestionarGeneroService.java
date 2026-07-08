/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Genero;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public GeneroDto crearGenero(GeneroDto generoDto) {

        Optional<Genero> optional = generoRepo.findByNombreIgnoreCase(generoDto.getNombre());

        Genero genero;

        if (optional.isEmpty()) {

            genero = new Genero();
            genero.setNombre(generoDto.getNombre());
            genero.setCreateAt(LocalDateTime.now());

            if (generoDto.getDescription() != null) {

                genero.setDescription(generoDto.getDescription());
            }

            generoRepo.save(genero);
            return generoDto;
        }

        genero = optional.get();

        if (genero.isIsDelete()) {

            genero.setIsDelete(false);
            genero.setCreateAt(LocalDateTime.now());

            if (genero.getDescription() != null) {

                genero.setDescription(generoDto.getDescription());
            }
            generoRepo.save(genero);
        } else {
            throw new DatoYaExistenteException("El genero ya existe en el sistema.");
        }

        return generoDto;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Page<GeneroDto> getGeneros(String name, boolean isDelete, Pageable pageable) {

        Page<GeneroDto> page = generoRepo.generos(name, isDelete, pageable);

        if (page.isEmpty()) {

            throw new NoDatosQueMostrarExecption("No hay generos que mostrar...");
        }

        return page;

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public GeneroDto updateGenreById(Integer id, GeneroDto dto) {

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

        System.out.println(dto.getDescription());
        genero.setNombre(dto.getNombre());

        if (dto.getDescription() != null) {

            genero.setDescription(dto.getDescription());

            System.out.println(dto.getDescription());
        }

        generoRepo.save(genero);

        return dto;

    }

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

        generoRepo.save(genero);
    }

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

        generoRepo.save(genero);

    }

}
