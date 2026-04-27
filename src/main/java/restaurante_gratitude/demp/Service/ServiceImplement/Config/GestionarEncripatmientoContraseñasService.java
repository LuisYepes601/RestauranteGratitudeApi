/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.Service.Config.GestionarEncriptanientoContraseñas;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarEncripatmientoContraseñasService implements GestionarEncriptanientoContraseñas {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public GestionarEncripatmientoContraseñasService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public GestionarEncripatmientoContraseñasService() {
    }

    @Override
    public String encriptarContraseñas(String contrasenia) {

        String contraseñaEncriptada = passwordEncoder.encode(contrasenia);
        return contraseñaEncriptada;
    }

}
