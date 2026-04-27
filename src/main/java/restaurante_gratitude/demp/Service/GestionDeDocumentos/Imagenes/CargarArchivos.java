/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.GestionDeDocumentos.Imagenes;

import java.util.Map;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivosCloudiny.FileCloudinary;

/**
 *
 * @author User
 */
public interface CargarArchivos {

    public String cargarArchivo(FileCloudinary fileCloudinary);
}
