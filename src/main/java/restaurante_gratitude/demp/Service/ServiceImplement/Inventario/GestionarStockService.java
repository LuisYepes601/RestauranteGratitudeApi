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
import restaurante_gratitude.demp.Service.Inventario.GestionarStock;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarStockService implements GestionarStock {

    private StockProductoRepository stockProductoRepository;

    @Autowired
    public GestionarStockService(StockProductoRepository stockProductoRepository) {
        this.stockProductoRepository = stockProductoRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editarStock(Integer id_producto, Integer cantidad) {

        StockProducto stockProducto = ValidacionesGlobales.obtenerSiExiste(
                stockProductoRepository.findByProductoId(id_producto),
                "Error. El producto no se encuentra en eel inventario");

        if (cantidad < 0) {
            throw new DatoInvalidoException("Error la cantidad debe de ser mayor a cero 0");
        }

        if (cantidad > stockProducto.getCantidadMax()) {

            throw new DatoInvalidoException("Error la cantidad actual no puede superar la cantidad maxima."
                    + " Le invitamos a colocar un valor que no sobrepase la cantidad máxima.");
        }

        if (cantidad < stockProducto.getCantidadMin()) {
            throw new DatoInvalidoException("Error la acantidad actual no puede ser menor a la cantidad minima.");
        }

        stockProducto.setCantidad(cantidad);
        stockProductoRepository.save(stockProducto);

    }

}
