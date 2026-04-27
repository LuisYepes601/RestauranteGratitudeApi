/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos.Contenido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.DTOS.Request.Productos.Contenido.TipoContenidoDto;
import restaurante_gratitude.demp.Entidades.Productos.TipoContenidoProducto;
import restaurante_gratitude.demp.Repositorys.Productos.TipoContenidoProductoRepository;
import restaurante_gratitude.demp.Service.Productos.Contenido.GestionarTipoDeContenido;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarTipoDeContenidoService implements GestionarTipoDeContenido {

    private TipoContenidoProductoRepository tipoContenidoProductoRepository;

    @Autowired

    public GestionarTipoDeContenidoService(TipoContenidoProductoRepository tipoContenidoProductoRepository) {
        this.tipoContenidoProductoRepository = tipoContenidoProductoRepository;
    }

    public TipoContenidoProductoRepository getTipoContenidoProductoRepository() {
        return tipoContenidoProductoRepository;
    }

    public void setTipoContenidoProductoRepository(TipoContenidoProductoRepository tipoContenidoProductoRepository) {
        this.tipoContenidoProductoRepository = tipoContenidoProductoRepository;
    }

    @Override
    public TipoContenidoDto crearTipoDeContenido(TipoContenidoDto tipoContenidoDto) {

        ValidacionesGlobales.validarExistencia(
                tipoContenidoProductoRepository
                        .findByNombre(tipoContenidoDto.getNombre()),
                "El tipo de contenido de producto: " + tipoContenidoDto.getNombre() + " ya se encuentra"
                + " en el sistema, le invitamos que ingrese un nombre valido.");

        TipoContenidoProducto tipoContenidoProducto = new TipoContenidoProducto();

        tipoContenidoProducto.setNombre(tipoContenidoDto.getNombre());
        tipoContenidoProductoRepository.save(tipoContenidoProducto);

        return tipoContenidoDto;
    }

}
