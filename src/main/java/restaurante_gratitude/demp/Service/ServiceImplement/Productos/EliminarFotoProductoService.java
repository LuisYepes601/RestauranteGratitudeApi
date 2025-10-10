/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
import restaurante_gratitude.demp.Repositorys.Productos.ProductoRepository;
import restaurante_gratitude.demp.Service.Productos.EliminarFotoProducto;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class EliminarFotoProductoService implements EliminarFotoProducto {

    private ProductoRepository productoRepo;

    @Autowired
    public EliminarFotoProductoService(ProductoRepository productoRepo) {
        this.productoRepo = productoRepo;
    }

    @Override
    public void eliminarFotoProducto(Integer id) {

        Producto producto = ValidacionesGlobales.obtenerSiExiste(
                productoRepo.findById(id),
                "El producto no se encuentra en el sistema actualmente.");

        producto.setImagen("NO_APLICA");

        productoRepo.save(producto);
    }

}
