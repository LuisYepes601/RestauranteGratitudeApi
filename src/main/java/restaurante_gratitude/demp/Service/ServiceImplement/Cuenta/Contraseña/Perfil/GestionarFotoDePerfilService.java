/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.Contraseña.Perfil;

import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Cuenta.Perfil.GestionarFotoPerfil;
import restaurante_gratitude.demp.Service.GestionDeDocumentos.Imagenes.CargarArchivos;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivosCloudiny.EliminarImagenesService;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivosCloudiny.FileCloudinary;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class GestionarFotoDePerfilService implements GestionarFotoPerfil {

    private UsuarioRepository usuarioRepo;

    @Qualifier("fileService")
    private CargarArchivos cargarArchivos;

    private EliminarImagenesService eliminarImagenesService;

    @Autowired
    public GestionarFotoDePerfilService(UsuarioRepository usuarioRepo, CargarArchivos cargarArchivos, EliminarImagenesService eliminarImagenesService) {
        this.usuarioRepo = usuarioRepo;
        this.cargarArchivos = cargarArchivos;
        this.eliminarImagenesService = eliminarImagenesService;
    }

    public UsuarioRepository getUsuarioRepo() {
        return usuarioRepo;
    }

    public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public CargarArchivos getCargarArchivos() {
        return cargarArchivos;
    }

    public void setCargarArchivos(CargarArchivos cargarArchivos) {
        this.cargarArchivos = cargarArchivos;
    }

    public EliminarImagenesService getEliminarImagenesService() {
        return eliminarImagenesService;
    }

    public void setEliminarImagenesService(EliminarImagenesService eliminarImagenesService) {
        this.eliminarImagenesService = eliminarImagenesService;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void subirFotoDePerfil(MultipartFile file, Integer id) {

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(
                usuarioRepo.findById(id),
                "Error el suuario no tiene una cuenta creada.");

        Map<String, Object> utils = new HashMap<>();

        utils.put("public_id", "usuarios/perfil_ " + usuario.getPrimerNombre());
        utils.put("transformation", new Transformation<>()
                .quality("auto")
                .fetchFormat("auto")
                .crop("limit")
                .width(400)
                .height(400));

        String urlFoto = cargarArchivos.cargarArchivo(new FileCloudinary(utils, file));

        usuario.setFoto_perifl(urlFoto);
        usuarioRepo.save(usuario);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void eliminarFotoDePerfil(int id_user) {

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(
                usuarioRepo.findById(id_user),
                "Error no se pudo eliminar la foto de perfil por que el usuario no tiene cuenta.");

        eliminarImagenesService.eliminarFile(usuario.getFoto_perifl(),
                "No se pudo eliminar la foto de perfil en "
                + "estos momentos le invitamos a intentarlo nuevamente.");

        usuario.setFoto_perifl("NO_APLICA");

        usuarioRepo.save(usuario);
    }

}
