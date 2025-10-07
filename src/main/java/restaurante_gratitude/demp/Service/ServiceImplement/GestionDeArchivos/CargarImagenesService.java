/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivos;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.ControlExeptions.Execptions.ErrorAlSubirArchivoException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.Entidades.Productos.Producto;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author User
 */
@Service
public class CargarImagenesService {

    private Cloudinary cloudinary;

    @Autowired
    public CargarImagenesService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String cargarImagenPerfil(MultipartFile file, Usuario usuario) {

        if (file.isEmpty()) {
            throw new ErrorAlSubirArchivoException("Error, no se puedo cargar la imagen, no hay imagen que cargar.");
        }

        Map resultadoCarga = null;
        try {
            resultadoCarga = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                    "public_id", "usuarios/perfil_ " + usuario.getPrimerNombre(),
                    "transformation", new Transformation<>()
                            .quality("auto")
                            .fetchFormat("auto")
                            .crop("limit")
                            .width(400)
                            .height(400)
            ));
        } catch (IOException ex) {
            throw new ErrorAlSubirArchivoException("Error, no se puedo cargar el archivo. Le invitamos "
                    + " a intentarlo nuevamente.");
        }

        return resultadoCarga.get("secure_url").toString();
    }

    public String cargarImagenProducto(MultipartFile file, Producto producto) throws IOException {

        if (file.isEmpty()) {
            throw new NoDatosQueMostrarExecption("Error, no se puedo cargar la imagen, no hay imagen que cargar.");
        }

        Map resultadoCarga = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                "public_id", "productos/" + producto.getNombre(),
                "transformation", new Transformation<>()
                        .quality("auto")
                        .fetchFormat("auto")
                        .width(300)
                        .height(300)
                        .crop("limit")
        ));

        return resultadoCarga.get("secure_url").toString();
    }

}
