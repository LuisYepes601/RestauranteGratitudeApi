/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivosCloudiny;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.ControlExeptions.Execptions.ErrorAlSubirArchivoException;
import restaurante_gratitude.demp.Service.GestionDeDocumentos.Imagenes.CargarArchivos;

/**
 *
 * @author User
 */
@Service(value = "fileService")
public class CargarFileService implements CargarArchivos {

    private Cloudinary cloudinary;

    @Autowired
    public CargarFileService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String cargarArchivo(FileCloudinary fileCloudinary) {

        if (fileCloudinary.getFile().isEmpty()) {
            throw new ErrorAlSubirArchivoException("Error, no se puedo cargar la imagen, no hay imagen que cargar.");
        }

        Map<String, String> resultadoCarga = new HashMap<>();

        try {
            resultadoCarga = cloudinary
                    .uploader()
                    .upload(fileCloudinary.getFile().getInputStream(), fileCloudinary.getObjectUtils());

        } catch (IOException ex) {
            throw new ErrorAlSubirArchivoException("Error, no se puedo cargar el archivo. Le invitamos "
                    + " a intentarlo nuevamente.");
        }

        return resultadoCarga.get("secure_url").toString();
    }

}
