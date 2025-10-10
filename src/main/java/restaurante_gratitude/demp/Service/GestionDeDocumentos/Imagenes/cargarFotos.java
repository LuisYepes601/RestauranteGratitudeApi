/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.GestionDeDocumentos.Imagenes;

import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author User
 */
public interface cargarFotos {

    public String cargarFoto(MultipartFile imagen, String mensajeError, Map objectUtils, String nombreImagen);
}
