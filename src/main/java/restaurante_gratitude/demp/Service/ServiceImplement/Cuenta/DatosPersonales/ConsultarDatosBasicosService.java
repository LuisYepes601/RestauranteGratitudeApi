/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.DatosPersonales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.DTOS.Request.Users.UsuarioPerfilDto;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Cuenta.Perfil.consultarDatosBasicos;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class ConsultarDatosBasicosService implements consultarDatosBasicos {
    
    private UsuarioRepository usuarioRepo;
    
    @Autowired
    public ConsultarDatosBasicosService(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }
    
    @Transactional(rollbackFor = Exception.class)
    @Override
    public UsuarioPerfilDto consultarDatosPerfil(Integer id) {
        
        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(
                usuarioRepo.findById(id),
                "Error el usuario no existe en el sistema.");
        
        UsuarioPerfilDto usuarioPerfilDto = new UsuarioPerfilDto();
        
        usuarioPerfilDto.setPrimerNombre(usuario.getPrimerNombre());
        usuarioPerfilDto.setSegundoNombre(usuario.getSegundoNombre());
        usuarioPerfilDto.setPrimerApellido(usuario.getPrimerApellido());
        usuarioPerfilDto.setSegundoApellido(usuario.getSegundoApellido());
        usuarioPerfilDto.setTelefono(usuario.getTelefono());
        
        if (usuario.getEstado_cuenta() != null) {
            usuarioPerfilDto.setEstadoCuenta(usuario.getEstado_cuenta().getNombre());
        }
        
        if (usuario.getRol() != null) {
            usuarioPerfilDto.setRol(usuario.getRol().getNombre());
        }
        
        usuarioPerfilDto.setSexo(usuario.getSexo().getNombre());
        usuarioPerfilDto.setGenero(usuario.getGenero().getNombre());
        
        if (usuario.getDireccion() != null) {
            usuarioPerfilDto.setPais(usuario.getDireccion().getPais().getNombre());
            usuarioPerfilDto.setDepartamento(usuario.getDireccion().getDepartamento().getNombre());
            usuarioPerfilDto.setCiudad(usuario.getDireccion().getCiudad().getNombre());
            usuarioPerfilDto.setMunicipio(usuario.getDireccion().getMunicipio().getNombre());
            usuarioPerfilDto.setBarrio(usuario.getDireccion().getBarrio());
            
            if (usuario.getDireccion().getTipoDireccion() != null) {
                usuarioPerfilDto.setTipoDirecion(usuario.getDireccion().getTipoDireccion().getNombre());
            }
            
        }
        
        if (usuario.getIdentificacion() != null) {
            
            usuarioPerfilDto.setTipoIdertificacion(usuario.getIdentificacion().getTipoIdentificacion().getNombre());
            usuarioPerfilDto.setNumeroIdentificacion(usuario.getIdentificacion().getNumero());
            
        }
        
        usuarioPerfilDto.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioPerfilDto.setCorreo(usuario.getEmail());
        usuarioPerfilDto.setFotoPerfil(usuario.getFoto_perifl());
        
        return usuarioPerfilDto;
        
    }
    
}
