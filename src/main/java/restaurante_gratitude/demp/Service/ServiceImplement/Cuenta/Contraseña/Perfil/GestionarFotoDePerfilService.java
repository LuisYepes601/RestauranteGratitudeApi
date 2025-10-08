/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.Contraseña.Perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivos.CargarImagenesService;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivos.EliminarImagenesService;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class GestionarFotoDePerfilService {

    private UsuarioRepository usuarioRepo;
    private CargarImagenesService imagenesService;
    private EliminarImagenesService eliminarImagenesService;

    @Autowired
    public GestionarFotoDePerfilService(UsuarioRepository usuarioRepo, CargarImagenesService imagenesService, EliminarImagenesService eliminarImagenesService) {
        this.usuarioRepo = usuarioRepo;
        this.imagenesService = imagenesService;
        this.eliminarImagenesService = eliminarImagenesService;
    }

    @Transactional(rollbackFor = Exception.class)
    public void subirFotoDePerfil(MultipartFile file, Integer id) {

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(
                usuarioRepo.findById(id),
                "Error el suuario no tiene una cuenta creada.");

        String foto = imagenesService.agregarFotoDePerfil(
                file,
                usuario);

        usuario.setFoto_perifl(foto);
        usuarioRepo.save(usuario);
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

}
