/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos.Contenido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoNoExistenteEcxeption;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.Request.Productos.Contenido.ContenidoDto;
import restaurante_gratitude.demp.Entidades.Productos.Contenido;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
import restaurante_gratitude.demp.Repositorys.Productos.ContenidoProducto;
import restaurante_gratitude.demp.Repositorys.Productos.ProductoRepository;
import restaurante_gratitude.demp.Repositorys.Productos.TipoContenidoProductoRepository;
import restaurante_gratitude.demp.Service.Productos.Contenido.IContenidoProduct;
import restaurante_gratitude.demp.Utils.AuditableUtils;

/**
 *
 * @author luis
 */
@Service
public class ContenidoService implements IContenidoProduct {

    private TipoContenidoProductoRepository tipoContenidoRepo;
    private ContenidoProducto contenidoProductoRepo;
    private ProductoRepository productoRepo;

    @Autowired
    public ContenidoService(TipoContenidoProductoRepository tipoContenidoRepo, ContenidoProducto contenidoProductoRepo, ProductoRepository productoRepo) {
        this.tipoContenidoRepo = tipoContenidoRepo;
        this.contenidoProductoRepo = contenidoProductoRepo;
        this.productoRepo = productoRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Contenido create(ContenidoDto contenidoDto) {

        Contenido contenido = new Contenido();
        contenido.setTipo(tipoContenidoRepo
                .findById(contenidoDto.getId_type_product())
                .orElseThrow(()
                        -> new DatoNoExistenteEcxeption("El tipo de contenido no existe en el sistema")));

        contenido.setValor(contenidoDto.getValue());

        AuditableUtils.create(
                contenido,
                "prueba",
                "prueba");
        return contenidoProductoRepo.save(contenido);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Contenido updateByiD(Producto producto, Integer idTipoContent, String valor, Integer idContent) {

        Contenido contenido = contenidoProductoRepo.findById(idContent)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El contenido no existe en el sistema"));

        contenido.setTipo(tipoContenidoRepo
                .findById(idTipoContent)
                .orElseThrow(()
                        -> new DatoNoExistenteEcxeption("El tipo de contenido no existe en el sistema")));

        contenido.setValor(valor);

        AuditableUtils.update(
                contenido,
                "PRUEBA",
                "prueba");

        return contenidoProductoRepo.save(contenido);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto deleteById(Integer id) {

        Contenido contenido = contenidoProductoRepo.findById(id)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El contenido no existe en el sistema"));

        if (contenido.isIsDelete()) {

            throw new DatoNoExistenteEcxeption("El contenido no existe en el sistema.");
        }

        AuditableUtils.delete(
                contenido,
                "prueba",
                "prueba");

        contenidoProductoRepo.save(contenido);

        return new BasicResponseDto();

    }

}
