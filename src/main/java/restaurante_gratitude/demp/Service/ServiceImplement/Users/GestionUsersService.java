/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.DTOS.Request.Users.UsuarioBasicDTO;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Users.GestionUsers;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionUsersService implements GestionUsers {

    private UsuarioRepository userRepo;

    @Autowired
    public GestionUsersService(UsuarioRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public UsuarioBasicDTO obtnerUsuarioByID(Integer id) {

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(
                userRepo.findById(id),
                "Error el uusario no existe en sistema. Intentelo nuevamente");

        UsuarioBasicDTO basicDTO = new UsuarioBasicDTO();

        basicDTO.setEmail(usuario.getEmail());
        basicDTO.setId(usuario.getId());
        basicDTO.setPrimerNombre(usuario.getPrimerNombre());
        basicDTO.setPrimerApellido(usuario.getPrimerApellido());
        basicDTO.setTelefono(usuario.getTelefono());

        if (usuario.getIdentificacion() != null) {
            basicDTO.setIdentificacion(usuario.getIdentificacion().getNumero());

            basicDTO.setTipoIdntificacion(usuario.getIdentificacion().getTipoIdentificacion().getNombre());
        }

        return basicDTO;

    }
}
