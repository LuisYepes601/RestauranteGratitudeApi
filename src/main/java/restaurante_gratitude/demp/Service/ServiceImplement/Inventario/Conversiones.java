/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Inventario;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.Response.Inventario.inventarioDto;
import restaurante_gratitude.demp.Entidades.InventarioStockProducto.StockProducto;
import restaurante_gratitude.demp.Repositorys.Inventario.StockProductoRepository;

/**
 *
 * @author Usuario
 */
@Service
public class Conversiones {

    public static List<inventarioDto> productosValidosIventario(StockProductoRepository stockProductoRepository) {

        List<StockProducto> productosInventario = stockProductoRepository.findAll();
        List<inventarioDto> registrosValidos = new ArrayList<>();

        if (productosInventario.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay prodcutos que mostrar en el inventario.");
        }

        for (StockProducto registro : productosInventario) {

            if (!registro.getProducto().isIsDelete()) {

                inventarioDto dto = new inventarioDto();

                dto.setCantidad(registro.getCantidad());
                dto.setCantidadMin(registro.getCantidadMin());
                dto.setCantidadMax(registro.getCantidadMax());
                dto.setFechaIngreso(registro.getFecha_ingreso());
                dto.setId(registro.getId());

                if (registro.getProducto() != null) {

                    dto.setImagenProducto(registro.getProducto().getImagen());

                    Double precio = registro.getProducto().getPrecio();

                    dto.setPrecio(precio.toString());
                    dto.setIdProducto(registro.getProducto().getId());

                }

                registrosValidos.add(dto);
            }

        }

        return registrosValidos;
    }

}
