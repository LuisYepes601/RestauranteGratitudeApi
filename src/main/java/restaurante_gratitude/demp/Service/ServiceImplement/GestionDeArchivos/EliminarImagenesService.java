/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivos;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.EliminarArchivoException;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.GestionDeDocumentos.Imagenes.eliminarFotos;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class EliminarImagenesService implements eliminarFotos {

    private Cloudinary cloudinary;
    private UsuarioRepository usuarioRepo;

    @Autowired
    public EliminarImagenesService(Cloudinary cloudinary, UsuarioRepository usuarioRepo) {
        this.cloudinary = cloudinary;
        this.usuarioRepo = usuarioRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void eliminarFotoDePerfil(int id_user) {

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(
                usuarioRepo.findById(id_user),
                "Error no se pudo eliminar la foto de perfil por que el usuario no tiene cuenta.");

        String id_publico = ExtraerIdPublico.extraerPublicId(usuario.getFoto_perifl());

        try {
            cloudinary.uploader().destroy(
                    id_publico,
                    ObjectUtils.asMap("invalidate", true));
        } catch (IOException ex) {
            throw new EliminarArchivoException("El archivo no se pudo eliminar, le invitamos a realizarlo nuevamente.");
        }
        usuario.setFoto_perifl("NO APLICA");

        usuarioRepo.save(usuario);
    }

}
