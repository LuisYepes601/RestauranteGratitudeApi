/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.DatosPersonales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.DTOS.Request.Cuenta.EditarDatosBasicosDto.EditarDatosIdentificacionDto;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Identificaciones.Identificacion;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Identificaciones.TipoIdentificacion;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.Identificaciones.IdentificacionRepository;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.Identificaciones.TipoIdentificacionRepository;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Cuenta.Perfil.EditarDatosIdentificacion;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class EditarDatosIdentificacionService implements EditarDatosIdentificacion {

    private UsuarioRepository usuarioRepo;
    private TipoIdentificacionRepository tipoIdentRepo;
    private IdentificacionRepository identificacionRepo;

    @Autowired
    public EditarDatosIdentificacionService(UsuarioRepository usuarioRepo, TipoIdentificacionRepository tipoIdentRepo, IdentificacionRepository identificacionRepo) {
        this.usuarioRepo = usuarioRepo;
        this.tipoIdentRepo = tipoIdentRepo;
        this.identificacionRepo = identificacionRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editarDatosIdentificacion(Integer id_user, EditarDatosIdentificacionDto datosIdentificacionDto) {
        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(
                usuarioRepo.findById(id_user),
                "Error el susario no existe en el sistema.");

        Identificacion identificacion = ValidacionesGlobales.obtenerSiExiste(
                identificacionRepo.findById(usuario.getIdentificacion().getId()),
                "El usuario no se encuentra con los datos de identificacion");

        identificacion.setNumero(datosIdentificacionDto.getNumero());

        System.out.println(" **************************" + datosIdentificacionDto.getTipoIdentificacion());
        TipoIdentificacion tipoIdentificacion = ValidacionesGlobales.obtenerSiExiste(
                tipoIdentRepo.findByNombre(datosIdentificacionDto.getTipoIdentificacion()),
                "El tipo de identificacion no se encuentra en el sistema");

        identificacion.setTipoIdentificacion(tipoIdentificacion);

        identificacionRepo.save(identificacion);

        usuario.setIdentificacion(identificacion);

        usuarioRepo.save(usuario);

    }

}
