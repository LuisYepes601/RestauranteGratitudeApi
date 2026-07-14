/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Sexo;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
import restaurante_gratitude.demp.DTOS.Request.Sexo.SexoDto;
import restaurante_gratitude.demp.DTOS.Response.Sexo.SexoDetailsDto;
import restaurante_gratitude.demp.DTOS.Response.Sexo.SexoResponseDto;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Sexo;
import restaurante_gratitude.demp.Entidades.Roles.Rol;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.SexoRepository;
import restaurante_gratitude.demp.Service.Sexo.GestionarSexos;
import restaurante_gratitude.demp.Utils.AuditableUtils;

/**
 *
 * @author User
 */
@Service
public class GestionarSexosService implements GestionarSexos {
    
    private SexoRepository sexoRepo;
    
    @Autowired
    public GestionarSexosService(SexoRepository sexoRepo) {
        this.sexoRepo = sexoRepo;
    }
    
    public GestionarSexosService() {
    }
    
    public SexoRepository getSexoRepo() {
        return sexoRepo;
    }
    
    public void setSexoRepo(SexoRepository sexoRepo) {
        this.sexoRepo = sexoRepo;
    }
    
    @Caching(
            evict = {
                @CacheEvict(value = "sexos", allEntries = true)
            
            })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto agregarSexo(SexoDto sexoDto) {
        
        Optional<Sexo> optional = sexoRepo.findByNombreIgnoreCase(sexoDto.getNombre());
        
        Sexo sexo;
        
        if (optional.isEmpty()) {
            
            sexo = new Sexo();
            
            sexo.setNombre(sexoDto.getNombre());
            
            if (sexoDto.getDescription() != null) {
                
                sexo.setDescription(sexoDto.getDescription());
            }
            
            AuditableUtils.create(
                    sexo,
                    "luis",
                    "prueba");
            
            sexoRepo.save(sexo);
            return new BasicResponseDto("El genero ha sido creado exitosamente.");
        }
        
        sexo = optional.get();
        
        if (sexo.isIsDelete()) {
            
            AuditableUtils.activate(
                    sexo,
                    "prieba",
                    "prueba");
        } else {
            
            throw new DatoYaExistenteException("El genero" + sexoDto.getNombre() + " ya existe en el sistema.");
        }
        
        return new BasicResponseDto("El genero ha sido creado exitosamente.");
    }
    
    @Cacheable(value = "sexos")
    @Transactional(readOnly = true)
    @Override
    public PageResponse<SexoResponseDto> getAll(String nombre, boolean isDelete, Pageable pageable) {
        
        Page<SexoResponseDto> page = sexoRepo.getAll(nombre, isDelete, pageable);
        
        if (page.isEmpty()) {
            
            throw new NoDatosQueMostrarExecption("lista vacia");
        }
        PageResponse<SexoResponseDto> response = new PageResponse<>();
        
        response.setContent(page.getContent());
        response.setEmpty(page.isEmpty());
        response.setNumber(page.getNumber());
        response.setNumberOfElements(page.getNumberOfElements());
        response.setPageNumber(page.getPageable().getPageNumber());
        response.setPageSize(page.getPageable().getPageSize());
        response.setSize(page.getSize());
        response.setTotalElements(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        
        return response;
        
    }
    
    @Caching(
            evict = {
                @CacheEvict(value = "sexos", allEntries = true),
                @CacheEvict(value = "sexo-detail", key = "#id")
            
            })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto updateById(Integer id, SexoDto sexoDto) {
        
        Sexo sexo = sexoRepo.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El Sexo no se encuentra en el sistema."));
        
        if (sexo.isIsDelete()) {
            
            throw new DatoNoExistenteEcxeption("El Sexo no se encuentra activo en el sistema");
        }
        
        Optional<Sexo> optional = sexoRepo.findByNombreIgnoreCase(sexoDto.getNombre().trim());
        
        if (optional.isPresent()
                && optional.get().getId() != sexo.getId()) {
            
            throw new DatoYaExistenteException("El Sexo ya existe en el sistema");
        }
        
        sexo.setNombre(sexoDto.getNombre().trim());
        
        if (sexoDto.getDescription() != null) {
            
            sexo.setDescription(sexoDto.getDescription().trim());
        }
        
        AuditableUtils.update(sexo, "prueba", "prueba");
        
        sexoRepo.save(sexo);
        
        return new BasicResponseDto("El Sexo ha sido actualizado con exito");
    }
    
    @Caching(evict = {
        @CacheEvict(value = "sexos", allEntries = true),
        @CacheEvict(value = "sexo-detail", key = "#id")
    })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto deleteById(Integer id) {
        
        Sexo sexo = sexoRepo.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El sexo no existe en el sistema"));
        
        if (sexo.isIsDelete()) {
            
            throw new DatoNoExistenteEcxeption("El sexo no se ecnuetra activo en el sistema");
        }
        
        AuditableUtils.delete(
                sexo,
                "prueba",
                "prueba");
        
        return new BasicResponseDto("El sexo ha sido eliminado con exíto");
        
    }
    
    @Caching(
            evict = {
                @CacheEvict(value = "sexos", allEntries = true),
                @CacheEvict(value = "sexo-detail", key = "#id")
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto activateById(Integer id) {
        
        Sexo sexo = sexoRepo.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El sexo no se encuentra en el sistema"));
        
        if (sexo.isIsDelete()) {
            
            throw new DatoNoExistenteEcxeption("El sexo ya se encuentra activo");
        }
        
        AuditableUtils.activate(
                sexo,
                "prueba",
                "prueba");
        
        return new BasicResponseDto("Se ha activado con exíto el sexo en el sistema.");
        
    }
    
    @Cacheable(value = "sexo-detail", key = "#id")
    @Transactional(readOnly = true)
    @Override
    public SexoDetailsDto getDetails(Integer id) {
        
        SexoDetailsDto detailsDto = sexoRepo.getDetails(id)
                .orElseThrow(()
                        -> new DatoNoExistenteEcxeption("El sexo no tiene detalles en el sistema."));
        
        return detailsDto;
        
    }
    
}
