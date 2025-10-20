/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoInvalidoException;
import restaurante_gratitude.demp.Entidades.InventarioStockProducto.StockProducto;
import restaurante_gratitude.demp.Repositorys.Inventario.StockProductoRepository;
import restaurante_gratitude.demp.Service.Inventario.GestionarCantidadMinima;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarCantidadMinimaService implements GestionarCantidadMinima {

    private StockProductoRepository stockProductoRepository;

    @Autowired
    public GestionarCantidadMinimaService(StockProductoRepository stockProductoRepository) {
        this.stockProductoRepository = stockProductoRepository;
    }

    @Override
    public void editarCantidadMinima(Integer id_producto, Integer cantidad) {

        StockProducto stockProducto = ValidacionesGlobales.obtenerSiExiste(
                stockProductoRepository.findByProductoId(id_producto),
                "El producto no tiene stock en el inventario. Le invitamos a agregarlo.");

        if (cantidad >= stockProducto.getCantidadMax()) {

            throw new DatoInvalidoException("Error, la cantidad minima no puede ser mayor a la "
                    + "cantidad maxima.");
        }

        stockProducto.setCantidadMin(cantidad);
        stockProductoRepository.save(stockProducto);

    }
}
