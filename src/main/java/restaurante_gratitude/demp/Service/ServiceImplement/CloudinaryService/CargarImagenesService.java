/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.CloudinaryService;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
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

    public String cargarImagenPerfil(MultipartFile file, Usuario usuario) throws IOException {

        if (file.isEmpty()) {
            throw new NoDatosQueMostrarExecption("Error, no se puedo cargar la imagen, no hay imagen que cargar.");
        }

        Map resultadoCarga = cloudinary.uploader().upload(file, ObjectUtils.asMap(
                "public_id", "usuarios/perfil_ " + usuario.getPrimerNombre()
        ));

        return resultadoCarga.get("secure_url").toString();
    }

    public String cargarImagenProducto(MultipartFile file, Producto producto) throws IOException {

        if (file.isEmpty()) {
            throw new NoDatosQueMostrarExecption("Error, no se puedo cargar la imagen, no hay imagen que cargar.");
        }

        Map resultadoCarga = cloudinary.uploader().upload(file, ObjectUtils.asMap(
                "public_id", "productos/" + producto.getNombre()
        ));

        return resultadoCarga.get("secure_url").toString();
    }

}
