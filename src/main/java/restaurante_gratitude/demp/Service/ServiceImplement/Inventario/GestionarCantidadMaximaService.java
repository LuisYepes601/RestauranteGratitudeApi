/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoInvalidoException;
import restaurante_gratitude.demp.Entidades.InventarioStockProducto.StockProducto;
import restaurante_gratitude.demp.Repositorys.Inventario.StockProductoRepository;
import restaurante_gratitude.demp.Service.Inventario.GestionarCantidadMaxima;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarCantidadMaximaService implements GestionarCantidadMaxima {

    private StockProductoRepository stockproductoRepo;

    @Autowired
    public GestionarCantidadMaximaService(StockProductoRepository stockproductoRepo) {
        this.stockproductoRepo = stockproductoRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editarCantidadMaxima(Integer id_producto, Integer cantidad) {

        StockProducto stockProducto = ValidacionesGlobales.obtenerSiExiste(
                stockproductoRepo.findByProductoId(id_producto),
                "El producto no se encuentra en inventario.");

        if (cantidad <= stockProducto.getCantidadMin()) {

            throw new DatoInvalidoException("Error, la cantidad maxima no puede ser menor a la cantidad minima. "
                    + "Ingrese datos validos.");
        }

        stockProducto.setCantidadMax(cantidad);
        stockproductoRepo.save(stockProducto);
    }

}
