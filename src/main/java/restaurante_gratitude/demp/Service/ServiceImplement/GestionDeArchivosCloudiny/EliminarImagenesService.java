/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivosCloudiny;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.EliminarArchivoException;
import restaurante_gratitude.demp.Service.GestionDeDocumentos.Imagenes.eliminarFotos;

/**
 *
 * @author User
 */
@Service
public class EliminarImagenesService implements eliminarFotos {

    private Cloudinary cloudinary;

    @Autowired
    public EliminarImagenesService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;

    }

    @Override
    public void eliminarFoto(String url, String error) {

        String id_publico = ExtraerIdPublico.extraerPublicId(url);

        try {
            cloudinary.uploader().destroy(
                    id_publico,
                    ObjectUtils.asMap("invalidate", true));
        } catch (IOException ex) {
            throw new EliminarArchivoException("El archivo no se pudo eliminar, le invitamos a realizarlo nuevamente.");
        }
    }

}
