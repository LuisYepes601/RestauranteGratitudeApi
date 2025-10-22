/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Inventario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.Response.Inventario.inventarioDto;
import restaurante_gratitude.demp.Entidades.InventarioStockProducto.StockProducto;
import restaurante_gratitude.demp.Repositorys.Inventario.StockProductoRepository;
import restaurante_gratitude.demp.Service.Inventario.ConsultarInventario;

/**
 *
 * @author Usuario
 */
@Service
public class ConsultarInventarioService implements ConsultarInventario {

    private StockProductoRepository stockRepo;

    @Autowired

    public ConsultarInventarioService(StockProductoRepository stockRepo) {
        this.stockRepo = stockRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<inventarioDto> getProductos() {

        List<inventarioDto> productosInventario = Conversiones.productosValidosIventario(stockRepo);

        if (productosInventario.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay productos que mostrar en el inventario");
        }
        
        return productosInventario;
    }

}
