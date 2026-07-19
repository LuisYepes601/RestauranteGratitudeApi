/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos.Contenido;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoYaExistenteException;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
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

        if (optional.isPresent()) {

            throw new DatoYaExistenteException("El tipo de contenido ya existe en el sistema.");
        }

        TipoContenidoProducto tipoContenidoProducto = new TipoContenidoProducto();

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

        return new BasicResponseDto("El tipo de contenido ha sido agregado con exito al sistema.");

    }

    @Cacheable(value = "type_contents")
    @Transactional(readOnly = true)
    @Override
    public PageResponse<TipoContenidoDtoResponse> getAll(String nombre, Boolean isDelete, Pageable pageable) {

        Page<TipoContenidoDtoResponse> page = repository.getAll(nombre, isDelete, pageable);

        return PageResponseUtils.CreatePageReponse(page);
    }

}
