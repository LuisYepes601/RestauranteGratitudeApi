/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.DatosPersonales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.DTOS.Request.Cuenta.EditarDatosBasicosDto.EditarDatosBasicosDto;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Genero;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Sexo;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.GeneroRepository;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.SexoRepository;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Cuenta.Perfil.EditarDatosBasicos;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class EditarDatosBasicosService implements EditarDatosBasicos {

    private UsuarioRepository usuarioRepository;
    private GeneroRepository generoRepo;
    private SexoRepository sexoRepo;

    @Autowired
    public EditarDatosBasicosService(UsuarioRepository usuarioRepository, GeneroRepository generoRepo, SexoRepository sexoRepo) {
        this.usuarioRepository = usuarioRepository;
        this.generoRepo = generoRepo;
        this.sexoRepo = sexoRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String editarInformacionPersonal(Integer id_user, EditarDatosBasicosDto datosBasicosDto) {

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(
                usuarioRepository.findById(id_user),
                "Error el susuario no se encuentra registrado en el sistema.");

        usuario.setPrimerNombre(datosBasicosDto.getPrimerNombre());
        usuario.setSegundoNombre(datosBasicosDto.getSegundoNombre());
        usuario.setPrimerApellido(datosBasicosDto.getPrimerApellido());
        usuario.setSegundoApellido(datosBasicosDto.getSegundoApellido());
        usuario.setEmail(datosBasicosDto.getCorreo());
        usuario.setTelefono(datosBasicosDto.getTelefono());

        Genero genero = ValidacionesGlobales.obtenerSiExiste(
                generoRepo.findByNombre(datosBasicosDto.getGenero()),
                "Error el genero no existe en el sistema.");

        usuario.setGenero(genero);

        Sexo sexo = ValidacionesGlobales.obtenerSiExiste(
                sexoRepo.findByNombre(datosBasicosDto.getSexo()),
                "Erroe el sexo no se encuentra en el sisetma");

        usuario.setSexo(sexo);
        
        usuarioRepository.save(usuario);

        return "Informacion personal editada con exito.";

    }

}
