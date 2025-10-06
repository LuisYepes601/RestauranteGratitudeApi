/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Login.InicioDeSesionService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.DTOS.Request.Login.InicioDeSesion.InicioSesionDto;
import restaurante_gratitude.demp.DTOS.Response.Login.LoginResponseDto;
import restaurante_gratitude.demp.Entidades.HistorialSesiones.HistorialSesiones;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.HistorialSesiones.HistorialSesionesReepository;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Login.InicioDeSesion.InicicioDeSesion;
import restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.Contraseña.ValidarContraseñasService;
import restaurante_gratitude.demp.Service.ServiceImplement.Sesiones.GestionarSesionesSevice;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class InicioDeSesionService implements InicicioDeSesion {

    private UsuarioRepository usuarioRepo;
    private BCryptPasswordEncoder passwordEncoder;
    private HistorialSesionesReepository historialSesionRepo;
    private GestionarSesionesSevice sesionesService;
    private ValidarContraseñasService validarContraseñaService;

    public InicioDeSesionService() {
    }

    @Autowired
    public InicioDeSesionService(UsuarioRepository usuarioRepo, BCryptPasswordEncoder passwordEncoder, HistorialSesionesReepository historialSesionRepo, GestionarSesionesSevice sesionesService, ValidarContraseñasService validarContraseñaService) {
        this.usuarioRepo = usuarioRepo;
        this.passwordEncoder = passwordEncoder;
        this.historialSesionRepo = historialSesionRepo;
        this.sesionesService = sesionesService;
        this.validarContraseñaService = validarContraseñaService;
    }

    public UsuarioRepository getUsuarioRepo() {
        return usuarioRepo;
    }

    public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public BCryptPasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public HistorialSesionesReepository getHistorialSesionRepo() {
        return historialSesionRepo;
    }

    public void setHistorialSesionRepo(HistorialSesionesReepository historialSesionRepo) {
        this.historialSesionRepo = historialSesionRepo;
    }

    public GestionarSesionesSevice getSesionesService() {
        return sesionesService;
    }

    public void setSesionesService(GestionarSesionesSevice sesionesService) {
        this.sesionesService = sesionesService;
    }

    @Override
    public LoginResponseDto iniciarSesion(InicioSesionDto inicioSesionDto, HttpServletRequest httpServletRequest) {
//VALIDAR EXISTENCIA DE USUARIO SEGN CREDENCIA INGRESADA
        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(usuarioRepo
                .findByEmail(inicioSesionDto.getCorreo()),
                "Error, no se pudo iniciar sesión, "
                + "porque el correo ingresado no tiene una cuenta activa en el sistema."
                + "Le invitamos a ingresar un usuario valido.");

        //VALIDAR QUE EL USUARIO SI ESTE ASOCIADO A LA CONTRASEÑA DADA
        validarContraseñaService.validarIgualdadContraseñasEcriptadas(
                inicioSesionDto.getContrasenia(),
                usuario.getContraseña());

        HistorialSesiones historialSesiones = sesionesService.agregarRegistroSesion(
                httpServletRequest,
                usuario);

        historialSesionRepo.save(historialSesiones);

        //CAMBIAR A ESTADO ACTIVO A USUARIO
        usuario.setEstado(true);

        usuarioRepo.save(usuario);

        //enviar la respuesta simulando un token para la avalidacion 
        //de las siguientes peticiones que tredra el usuario
        LoginResponseDto responseDto = new LoginResponseDto();
        responseDto.setNombre(usuario.getPrimerNombre());
        responseDto.setCorreo(usuario.getEmail());
        responseDto.setId(usuario.getId());
        responseDto.setRol(usuario.getRol().getNombre());

        return responseDto;
    }

}
