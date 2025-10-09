/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.GestionDeDocumentos.Imagenes;

import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author User
 */
public interface cargarFotos {

    public String agregarFotoDePerfil(MultipartFile imagen, Usuario usuario);

    public String agregarFotoDeProdcuto(MultipartFile imagen, Producto producto);

    public String agregarFotoBasica(MultipartFile imagen);
}
