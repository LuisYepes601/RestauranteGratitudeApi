/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivosCloudiny;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.ControlExeptions.Execptions.ErrorAlSubirArchivoException;
import restaurante_gratitude.demp.Service.GestionDeDocumentos.Imagenes.cargarFotos;

/**
 *
 * @author User
 */
@Service
public class CargarImagenesService implements cargarFotos {

    private Cloudinary cloudinary;

    @Autowired
    public CargarImagenesService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String cargarFoto(MultipartFile imagen, String mensajeError, Map objectUtils, String nombreImagen) {

        if (imagen.isEmpty()) {
            throw new ErrorAlSubirArchivoException("Error, no se puedo cargar la imagen, no hay imagen que cargar.");
        }

        Map resultadoCarga = null;
        try {
            resultadoCarga = cloudinary.uploader().upload(imagen.getBytes(),
                    objectUtils);
        } catch (IOException ex) {
            throw new ErrorAlSubirArchivoException("Error, no se puedo cargar el archivo. Le invitamos "
                    + " a intentarlo nuevamente.");
        }

        return resultadoCarga.get("secure_url").toString();
    }

}
