/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos.Contenido;

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
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Request.Productos.Contenido.DetailsTipoContenidoProdcuct;
import restaurante_gratitude.demp.DTOS.Request.Productos.Contenido.TipoContenidoDto;
import restaurante_gratitude.demp.DTOS.Response.Productos.Contenido.TipoContenidoDtoResponse;
import restaurante_gratitude.demp.Entidades.Productos.TipoContenidoProducto;
import restaurante_gratitude.demp.Repositorys.Productos.TipoContenidoProductoRepository;
import restaurante_gratitude.demp.Service.Productos.Contenido.GestionarTipoDeContenido;
import restaurante_gratitude.demp.Utils.AuditableUtils;
import restaurante_gratitude.demp.Utils.PageResponseUtils;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarTipoDeContenidoService implements GestionarTipoDeContenido {

    private TipoContenidoProductoRepository repository;

    @Autowired
    public GestionarTipoDeContenidoService(TipoContenidoProductoRepository repository) {
        this.repository = repository;
    }

    public GestionarTipoDeContenidoService() {
    }

    @CacheEvict(value = "type_contents", allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto crearTipoDeContenido(TipoContenidoDto tipoContenidoDto) {

        Optional<TipoContenidoProducto> optional = repository.findByNombreIgnoreCase(tipoContenidoDto.getNombre().trim());

        TipoContenidoProducto tipoContenidoProducto;
        if (optional.isPresent()) {

            tipoContenidoProducto = optional.get();

            if (!tipoContenidoProducto.isIsDelete()) {

                throw new DatoYaExistenteException("El tipo de contenido ya existe en el sistema.");
            }

            AuditableUtils.activate(tipoContenidoProducto, "prueba", "prueba");

            if (tipoContenidoDto.getDescription() != null) {

                tipoContenidoProducto.setDescription(tipoContenidoDto.getDescription()
                        .trim()
                        .toUpperCase());
            }

            repository.save(tipoContenidoProducto);

            return new BasicResponseDto("El tipo de contenido ha sido agregado con exito al sistema.");

        }
        tipoContenidoProducto = new TipoContenidoProducto();

        tipoContenidoProducto.setNombre(tipoContenidoDto.getNombre().trim());

        if (tipoContenidoDto.getDescription() != null) {

            tipoContenidoProducto.setDescription(tipoContenidoDto.getDescription()
                    .trim()
                    .toUpperCase());
        }
        AuditableUtils.create(
                tipoContenidoProducto,
                "Prueba",
                "Prueba");

        repository.save(tipoContenidoProducto);

        return new BasicResponseDto("El tipo de contenido ha sido agregado con exito al sistema.");

    }

    @Cacheable(value = "type_contents")
    @Transactional(readOnly = true)
    @Override
    public PageResponse<TipoContenidoDtoResponse> getAll(String nombre, Boolean isDelete, Pageable pageable) {

        Page<TipoContenidoDtoResponse> page = repository.getAll(nombre, isDelete, pageable);

        return PageResponseUtils.CreatePageReponse(page);
    }

    @CacheEvict(value = "type_contents", allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto updateById(Integer id, TipoContenidoDto tipoContenidoDto) {

        TipoContenidoProducto tipoContenidoProducto = repository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El tipo de contenido no existe en el sistema"));

        Optional<TipoContenidoProducto> optional = repository.findByNombreIgnoreCase(tipoContenidoDto.getNombre().trim());

        if (optional.isPresent() && optional.get().getId() != tipoContenidoProducto.getId()) {

            throw new DatoYaExistenteException("El tipo de contenido ya existe en el sistema.");
        }

        tipoContenidoProducto.setNombre(tipoContenidoDto.getNombre().trim());

        if (tipoContenidoDto.getDescription() != null) {

            tipoContenidoProducto.setDescription(tipoContenidoDto.getDescription().trim());
        }

        repository.save(tipoContenidoProducto);

        return new BasicResponseDto("El tipo de contenido ha sido actualizado con exito en el sistema");
    }

    @Caching(
            evict = {
                @CacheEvict(value = "type_contents", allEntries = true),
                @CacheEvict(value = "detail-tcp", key = "#id")
            })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto deletebyId(Integer id) {

        TipoContenidoProducto tipoContenidoProducto = repository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El tipo de contenido no existe en el sistema."));

        if (tipoContenidoProducto.isIsDelete()) {

            throw new DatoNoExistenteEcxeption("El tipo de contenido no existe en el sistema.");
        }

        tipoContenidoProducto.setIsDelete(true);
        AuditableUtils.delete(
                tipoContenidoProducto,
                "prueba",
                "prueba");

        repository.save(tipoContenidoProducto);

        return new BasicResponseDto("El tipo de contendio ha sido eliminado exitosamente.");
    }

    @Caching(
            evict = {
                @CacheEvict(value = "type_contents", allEntries = true),
                @CacheEvict(value = "detail-tcp", key = "#id")

            })
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto activateById(Integer id) {

        TipoContenidoProducto tipoContenidoProducto = repository.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El tipo de contenido no existe en el sistema"));

        if (!tipoContenidoProducto.isIsDelete()) {

            throw new DatoYaExistenteException("El tipo de contenido ya se encuentra activo en el sistema");
        }

        AuditableUtils.activate(tipoContenidoProducto, "prueba", "prueba");

        repository.save(tipoContenidoProducto);

        return new BasicResponseDto("El tipo de contenido ha sido activado exitosamente.");
    }

    @Cacheable(value = "detail-tcp", key = "#id")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public DetailsTipoContenidoProdcuct getDeatil(Integer id) {

        return repository.getDetails(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El tipo de contendo no existe en el sistema"));

    }

}
