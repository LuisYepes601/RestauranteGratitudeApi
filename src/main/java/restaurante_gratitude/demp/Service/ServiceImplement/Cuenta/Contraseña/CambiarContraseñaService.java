/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.Contraseña;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import restaurante_gratitude.demp.DTOS.Request.Cuenta.CambiarContraseñaDto;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Cuenta.CambiarContraseña;
import restaurante_gratitude.demp.Service.ServiceImplement.Config.GestionarEncripatmientoContraseñasService;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarCorreos.GestionarCorreosService;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class CambiarContraseñaService implements CambiarContraseña {

    private UsuarioRepository usuarioRepo;
    private GestionarEncripatmientoContraseñasService encripatmientoContraseñasService;
    private BCryptPasswordEncoder passwordEncoder;
    private SpringTemplateEngine springTemplateEngine;
    private ValidarContraseñasService validarContraseñasService;
    private GestionarCorreosService correosService;

    @Autowired
    public CambiarContraseñaService(UsuarioRepository usuarioRepo, GestionarEncripatmientoContraseñasService encripatmientoContraseñasService, BCryptPasswordEncoder passwordEncoder, SpringTemplateEngine springTemplateEngine, ValidarContraseñasService validarContraseñasService, GestionarCorreosService correosService) {
        this.usuarioRepo = usuarioRepo;
        this.encripatmientoContraseñasService = encripatmientoContraseñasService;
        this.passwordEncoder = passwordEncoder;
        this.springTemplateEngine = springTemplateEngine;
        this.validarContraseñasService = validarContraseñasService;
        this.correosService = correosService;
    }

    public CambiarContraseñaService() {
    }

    public UsuarioRepository getUsuarioRepo() {
        return usuarioRepo;
    }

    public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public GestionarEncripatmientoContraseñasService getEncripatmientoContraseñasService() {
        return encripatmientoContraseñasService;
    }

    public void setEncripatmientoContraseñasService(GestionarEncripatmientoContraseñasService encripatmientoContraseñasService) {
        this.encripatmientoContraseñasService = encripatmientoContraseñasService;
    }

    public BCryptPasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public SpringTemplateEngine getSpringTemplateEngine() {
        return springTemplateEngine;
    }

    public void setSpringTemplateEngine(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override

    public void cambiarContraseña(CambiarContraseñaDto cambiarContraseñaDto) {

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(
                usuarioRepo.findByEmail(cambiarContraseñaDto.getEmail()),
                "No se encuentra una cuenta asociada a ese correo: " + cambiarContraseñaDto.getEmail());

        validarContraseñasService.validarIgualdadContraseñasEcriptadas(
                cambiarContraseñaDto.getContraseaActual(),
                usuario.getContraseña());

        validarContraseñasService.validarFormatoContraseña(
                cambiarContraseñaDto.getContraseñaNueva());

        String contraseñaEncripatada = encripatmientoContraseñasService.encriptarContraseñas(
                cambiarContraseñaDto.getContraseñaNueva());

        usuario.setContraseña(contraseñaEncripatada);

        usuarioRepo.save(usuario);

        Context context = new Context();
        context.setVariable(
                "nombreUsuario",
                usuario.getPrimerNombre());

        String html = springTemplateEngine.process(
                "CambioDeContraseña",
                context);

        correosService.enviarCorreoConFormatoHtml(
                usuario.getEmail(),
                "Cambio de contraseña",
                html,
                "yepesluis006@gmail.com");

    }

}
