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
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarRecuperacionContraseñasService implements GestionarRecuperacionDeContraseña {

    private UsuarioRepository usuarioRepo;
    private GestionarEncripatmientoContraseñasService encriptamientoContraseña;

    @Autowired
    public GestionarRecuperacionContraseñasService(UsuarioRepository usuarioRepo, GestionarEncripatmientoContraseñasService encriptamientoContraseña) {
        this.usuarioRepo = usuarioRepo;
        this.encriptamientoContraseña = encriptamientoContraseña;
    }

    public GestionarRecuperacionContraseñasService() {
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

        usuario.setContraseña(generarContraseña());
        usuarioRepo.save(usuario);

        return contraseñaByGmailDto;
    }

    @Override
    public RecuperarContraseñaByIdentificacionDto recuperarContraseñaPorIdentificacion(
            RecuperarContraseñaByIdentificacionDto contraseñaByIdentificacionDto) {
        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(usuarioRepo
                .findByNumeroDeIdentificacion(
                        contraseñaByIdentificacionDto.getIdentificacion()),
                "El número de identificacion  ingresado no esta asociado  a una cuenta, "
                + "le invitamos a ingresar un número valido.");

        usuario.setContraseña(generarContraseña());
        usuarioRepo.save(usuario);

        return contraseñaByIdentificacionDto;

    }

    public String generarContraseña() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        CharacterRule mayusculas = new CharacterRule(EnglishCharacterData.UpperCase, 1);
        CharacterRule digitos = new CharacterRule(EnglishCharacterData.Digit, 8);
        CharacterRule minuscula = new CharacterRule(EnglishCharacterData.LowerCase, 1);
        CharacterRule caracterEspecial = new CharacterRule(EnglishCharacterData.Special, 1);

        String contraseñaNueva = passwordGenerator.generatePassword(
                8,
                mayusculas, digitos, minuscula, caracterEspecial);

        ValidarContraseñasService validarContraseñasService = new ValidarContraseñasService();

        validarContraseñasService.validarFormatoContraseña(contraseñaNueva);

        String contraseñaEncriptada = encriptamientoContraseña
                .encriptarContraseñas(contraseñaNueva);

        return contraseñaEncriptada;
    }

}
