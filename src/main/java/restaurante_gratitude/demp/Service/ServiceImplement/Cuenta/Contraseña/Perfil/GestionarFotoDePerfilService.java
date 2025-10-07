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
import restaurante_gratitude.demp.Service.Cuenta.Perfil.GestionarFotoDePerfil;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionDeArchivos.CargarImagenesService;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class GestionarFotoDePerfilService implements GestionarFotoDePerfil {

    private UsuarioRepository usuarioRepo;
    private CargarImagenesService imagenesService;

    @Autowired
    public GestionarFotoDePerfilService(UsuarioRepository usuarioRepo, CargarImagenesService imagenesService) {
        this.usuarioRepo = usuarioRepo;
        this.imagenesService = imagenesService;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String agregarFotoDePerfil(MultipartFile imagen, int id_user) {

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(
                usuarioRepo.findById(id_user),
                "Error al agregar foto de perfil."
                + "El usuario, no tiene una cuenta creada. LE INVITAMOS A REGISTRARCE");

        String foto = imagenesService.cargarImagenPerfil(imagen, usuario);

        usuario.setFoto_perifl(foto);
        usuarioRepo.save(usuario);

        return foto;
    }

}
