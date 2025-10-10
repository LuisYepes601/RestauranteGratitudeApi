/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
import restaurante_gratitude.demp.Repositorys.Productos.ProductoRepository;
import restaurante_gratitude.demp.Service.Productos.EliminarProductos;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class EliminarProductoService implements EliminarProductos {

    private ProductoRepository productoRepo;

    @Autowired
    public EliminarProductoService(ProductoRepository productoRepo) {
        this.productoRepo = productoRepo;
    }

    @Transactional
    @Override
    public void eliminarProductoById(Integer id) {

        Producto producto = ValidacionesGlobales.obtenerSiExiste(
                productoRepo.findById(id),
                "Error el producto que ingreso no existe en el sistema."
                + " Le invitamos a ingresar un producto existente.");

        producto.setIsDelete(true);

        productoRepo.save(producto);

    }

}
