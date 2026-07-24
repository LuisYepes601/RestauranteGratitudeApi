/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Inventario;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoInvalidoException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoNoExistenteEcxeption;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoYaExistenteException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.Global.BasicResponseDto;
import restaurante_gratitude.demp.DTOS.PageResponse;
import restaurante_gratitude.demp.DTOS.Request.Inventario.StockDto;
import restaurante_gratitude.demp.DTOS.Response.Inventario.InventarioDetailsDtoResp;
import restaurante_gratitude.demp.DTOS.Response.Inventario.inventarioDtoResponse;
import restaurante_gratitude.demp.Entidades.InventarioStockProducto.StockProducto;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
import restaurante_gratitude.demp.Repositorys.Inventario.StockProductoRepository;
import restaurante_gratitude.demp.Repositorys.Productos.ProductoRepository;
import restaurante_gratitude.demp.Service.Inventario.IInventario;
import restaurante_gratitude.demp.Utils.AuditableUtils;
import restaurante_gratitude.demp.Utils.PageResponseUtils;

/**
 *
 * @author luis
 */
@Service
public class AdminIventarioService implements IInventario {

    private StockProductoRepository sctockRepo;
    private ProductoRepository productoRepo;

    @Autowired
    public AdminIventarioService(StockProductoRepository sctockRepo, ProductoRepository productoRepo) {
        this.sctockRepo = sctockRepo;
        this.productoRepo = productoRepo;
    }

    @Caching(
            evict = {
                @CacheEvict(value = "stock", allEntries = true)
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addProduct(StockDto dto) {

        StockProducto stockProducto;

        Optional<StockProducto> optional = sctockRepo.findByProductoId(dto.getId_producto());

        if (optional.isPresent()) {

            stockProducto = optional.get();

            if (stockProducto.getProducto().isIsDelete() == false) {

                throw new DatoYaExistenteException("El producto ya se encuentra en stock");

            } else {

                validarCantidadMaxima(dto);
                stockProducto.setCantidad(dto.getCantidad());
                stockProducto.setCantidadMin(dto.getCantidad());
                stockProducto.setCantidadMax(dto.getCantidadMax());

                AuditableUtils.activate(
                        stockProducto,
                        "prueba",
                        "prueba");

                sctockRepo.save(stockProducto);

                return;

            }
        }

        validarCantidadMaxima(dto);
        stockProducto = new StockProducto();

        stockProducto.setCantidad(dto.getCantidad());
        stockProducto.setCantidadMin(dto.getCantidad());
        stockProducto.setCantidadMax(dto.getCantidadMax());

        Optional<Producto> optionalPro = productoRepo.findById(dto.getId_producto());

        if (optionalPro.isEmpty()) {

            throw new DatoNoExistenteEcxeption("El prodcuto no se encuentra en el sistema");
        }

        if (optionalPro.get().isIsDelete()) {
            throw new DatoNoExistenteEcxeption("El prodcuto no se encuentra activo en el sistema");
        }

        stockProducto.setProducto(optionalPro.get());

        AuditableUtils.create(stockProducto, "prueba", "sprueba");

        sctockRepo.save(stockProducto);

    }

    @Cacheable(value = "stock")
    @Transactional(readOnly = true)
    @Override
    public PageResponse<inventarioDtoResponse> getAll(
            String nombre,
            Integer category,
            Boolean isDelete,
            Double precioMin,
            Double precioMax,
            Pageable pageable) {

        Page<inventarioDtoResponse> page = sctockRepo.getAll(
                nombre, category, isDelete, precioMin, precioMax, pageable);

        if (page.isEmpty()) {

            throw new NoDatosQueMostrarExecption("No hay productos en el inventario");
        }
        return PageResponseUtils.CreatePageReponse(page);
    }

    @Caching(
            evict = {
                @CacheEvict(value = "stock", allEntries = true),
                @CacheEvict(value = "stock-individual", key = "id")
            }
    )
    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto deleteProduct(Integer idProduct) {

        StockProducto stockProducto = sctockRepo.findByProductoId(idProduct)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El producto no se encuentra en el sistema"));

        Producto producto = stockProducto.getProducto();

        if (stockProducto.isIsDelete()) {
            throw new DatoNoExistenteEcxeption("El producto no se encuetra activo en el sistema");
        }

        if (producto.isIsDelete()) {

            throw new DatoNoExistenteEcxeption("El prodcuto no se encuetra activo en el sistema");
        }

        AuditableUtils.delete(producto, "prueba", "prueba");

        stockProducto.setProducto(producto);

        productoRepo.save(producto);

        AuditableUtils.delete(stockProducto, "prueba", "prueba");

        sctockRepo.save(stockProducto);
        return new BasicResponseDto("El prodcuto ha sido eliminado con exito del sistema");

    }

    @Caching(
            cacheable = {
                @Cacheable(value = "stock-individual", key = "#id_product")
            })
    @Transactional(readOnly = true)
    @Override
    public InventarioDetailsDtoResp detailsProdcutInventary(Integer id_product) {

        return sctockRepo.getDetail(id_product)
                .orElseThrow(() -> new DatoNoExistenteEcxeption("El producto no exixte en el sistema."));

    }

    void validarCantidadMaxima(StockDto dto) {

        if (dto.getCantidadMin() >= dto.getCantidadMax()) {

            throw new DatoInvalidoException("La cantidad minima no debe de ser mayor ni "
                    + "igual a la cantidad maxima.");
        }
        if (dto.getCantidadMin() > dto.getCantidad()) {

            throw new DatoInvalidoException("La cantidad inicial no puede ser menor que la cantidad minima.");
        }
    }

    @Caching(evict = {
        @CacheEvict(
                value = "stock", allEntries = true),
        @CacheEvict(
                value = "stock-individual", key = "#id")
    })

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BasicResponseDto activateProduct(Integer id) {

        StockProducto stockProducto = sctockRepo.findByProductoId(id)
                .orElseThrow(()
                        -> new DatoNoExistenteEcxeption("El producto no se encuentra en el sistema."));

        Producto producto = stockProducto.getProducto();

        if (!stockProducto.isIsDelete()) {
            throw new DatoInvalidoException("El producto ya se encuentra activo en el sistema");
        }

        if (!producto.isIsDelete()) {
            throw new DatoInvalidoException("El producto ya se encuentra activo en el sistema");
        }

        AuditableUtils.activate(producto, "prueba", "prueba");

        productoRepo.save(producto);

        AuditableUtils.activate(stockProducto, "prueba", "prueba");

        sctockRepo.save(stockProducto);

        return new BasicResponseDto("");
    }

}
