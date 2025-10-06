/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.Contraseña;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.DTOS.Request.Cuenta.RecuperarContraseñaByGmailDto;
import restaurante_gratitude.demp.DTOS.Request.Cuenta.RecuperarContraseñaByIdentificacionDto;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Cuenta.GestionarRecuperacionDeContraseña;
import restaurante_gratitude.demp.Service.ServiceImplement.Config.GestionarEncripatmientoContraseñasService;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarCorreos.GestionarCorreosService;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarPlantillas.RecuperacionCotraseña;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarRecuperacionContraseñasService implements GestionarRecuperacionDeContraseña {

    private UsuarioRepository usuarioRepo;
    private GestionarEncripatmientoContraseñasService encriptamientoContraseña;
    private ValidarContraseñasService validarContraseñasService;
    private GestionarCorreosService correosService;
    private RecuperacionCotraseña recuperacionContraseñaTemplate;

    public GestionarRecuperacionContraseñasService() {
    }

    @Autowired
    public GestionarRecuperacionContraseñasService(UsuarioRepository usuarioRepo, GestionarEncripatmientoContraseñasService encriptamientoContraseña, ValidarContraseñasService validarContraseñasService, GestionarCorreosService correosService, RecuperacionCotraseña recuperacionContraseñaTemplate) {
        this.usuarioRepo = usuarioRepo;
        this.encriptamientoContraseña = encriptamientoContraseña;
        this.validarContraseñasService = validarContraseñasService;
        this.correosService = correosService;
        this.recuperacionContraseñaTemplate = recuperacionContraseñaTemplate;
    }

    public UsuarioRepository getUsuarioRepo() {
        return usuarioRepo;
    }

    public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public GestionarEncripatmientoContraseñasService getEncriptamientoContraseña() {
        return encriptamientoContraseña;
    }

    public void setEncriptamientoContraseña(GestionarEncripatmientoContraseñasService encriptamientoContraseña) {
        this.encriptamientoContraseña = encriptamientoContraseña;
    }

    @Override
    public RecuperarContraseñaByGmailDto recuperarContraseñaPorEmail(RecuperarContraseñaByGmailDto contraseñaByGmailDto) {

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(usuarioRepo
                .findByEmail(contraseñaByGmailDto.getGmail()),
                "El correo ingresado no esta asociado  a una cuenta, "
                + "le invitamos a ingresar un correo valido.");

        String contraseña = generarContraseña();

        String contraseñaEncriptada = encriptamientoContraseña
                .encriptarContraseñas(contraseña);

        usuario.setContraseña(contraseñaEncriptada);

        usuarioRepo.save(usuario);

        correosService.enviarCorreoConFormatoHtml(
                usuario.getEmail(),
                "Recuperación de contraseña",
                recuperacionContraseñaTemplate.recuperacionContraseñTemplate(usuario, contraseña),
                "yepesluis006@gmail.com");

        return contraseñaByGmailDto;
    }

    @Override
    public RecuperarContraseñaByIdentificacionDto recuperarContraseñaPorIdentificacion(
            RecuperarContraseñaByIdentificacionDto contraseñaByIdentificacionDto) {

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(usuarioRepo
                .findByIdentificacion_Numero(
                        contraseñaByIdentificacionDto.getIdentificacion()),
                "El número de identificacion  ingresado no esta asociado  a una cuenta, "
                + "le invitamos a ingresar un número valido.");

        String contraseña = generarContraseña();

        String contraseñaEncriptada = encriptamientoContraseña
                .encriptarContraseñas(contraseña);

        usuario.setContraseña(contraseñaEncriptada);

        usuarioRepo.save(usuario);

        correosService.enviarCorreoConFormatoHtml(
                usuario.getEmail(),
                "Recuperación de contraseña",
                recuperacionContraseñaTemplate.recuperacionContraseñTemplate(usuario, contraseña),
                "yepesluis006@gmail.com");

        return contraseñaByIdentificacionDto;

    }

    public String generarContraseña() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        CharacterRule mayusculas = new CharacterRule(EnglishCharacterData.UpperCase, 1);
        CharacterRule digitos = new CharacterRule(EnglishCharacterData.Digit, 1);
        CharacterRule minuscula = new CharacterRule(EnglishCharacterData.LowerCase, 1);
        CharacterRule caracterEspecial = new CharacterRule(EnglishCharacterData.Special, 1);

        String contraseñaNueva = passwordGenerator.generatePassword(
                8,
                mayusculas, digitos, minuscula, caracterEspecial);

        validarContraseñasService.validarFormatoContraseña(contraseñaNueva);

        return contraseñaNueva;
    }

}
