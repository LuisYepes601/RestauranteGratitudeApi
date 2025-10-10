/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.Contraseña.Perfil;

import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Cuenta.Perfil.GestionarFotoPerfil;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivosCloudiny.CargarImagenesService;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivosCloudiny.EliminarImagenesService;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class GestionarFotoDePerfilService implements GestionarFotoPerfil {

    private UsuarioRepository usuarioRepo;
    private CargarImagenesService imagenesService;
    private EliminarImagenesService eliminarImagenesService;

    @Autowired
    public GestionarFotoDePerfilService(UsuarioRepository usuarioRepo, CargarImagenesService imagenesService, EliminarImagenesService eliminarImagenesService) {
        this.usuarioRepo = usuarioRepo;
        this.imagenesService = imagenesService;
        this.eliminarImagenesService = eliminarImagenesService;
    }

    public UsuarioRepository getUsuarioRepo() {
        return usuarioRepo;
    }

    public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public CargarImagenesService getImagenesService() {
        return imagenesService;
    }

    public void setImagenesService(CargarImagenesService imagenesService) {
        this.imagenesService = imagenesService;
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

        String foto = imagenesService.cargarFoto(
                file,
                "La imagen no se puede cargar en estos momentos le inviatamos aintentarlo nuevamente.",
                ObjectUtils.asMap(
                        "public_id", "usuarios/perfil_ " + usuario.getPrimerNombre(),
                        "transformation", new Transformation<>()
                                .quality("auto")
                                .fetchFormat("auto")
                                .crop("limit")
                                .width(400)
                                .height(400)
                ),
                usuario.getPrimerNombre());

        usuario.setFoto_perifl(foto);
        usuarioRepo.save(usuario);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void eliminarFotoDePerfil(int id_user) {

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(
                usuarioRepo.findById(id_user),
                "Error no se pudo eliminar la foto de perfil por que el usuario no tiene cuenta.");

        eliminarImagenesService.eliminarFoto(usuario.getFoto_perifl(),
                "No se pudo eliminar la foto de perfil en "
                + "estos momentos le invitamos a intentarlo nuevamente.");

        usuario.setFoto_perifl("NO_APLICA");

        usuarioRepo.save(usuario);
    }

}
