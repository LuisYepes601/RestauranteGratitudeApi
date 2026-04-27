/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.Contraseña;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.ContraseñaIncorrectaExecption;
import restaurante_gratitude.demp.Service.Cuenta.ValidarPoliticasDeContraseñas;

/**
 *
 * @author Usuario
 */
@Service
public class ValidarContraseñasService implements ValidarPoliticasDeContraseñas {

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public ValidarContraseñasService(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean validarFormatoContraseña(String password) {

        LengthRule lonLengthRule = new LengthRule(8, 30);

        CharacterRule mayusculas = new CharacterRule(EnglishCharacterData.UpperCase, 1);
        CharacterRule minusculas = new CharacterRule(EnglishCharacterData.LowerCase, 1);
        CharacterRule digitos = new CharacterRule(EnglishCharacterData.Digit, 1);
        CharacterRule especiales = new CharacterRule(EnglishCharacterData.Special, 1);

        WhitespaceRule espacios = new WhitespaceRule();

        PasswordValidator passwordValidator = new PasswordValidator(
                mayusculas,
                minusculas,
                digitos,
                especiales,
                espacios);

        PasswordData data = new PasswordData(password);

        RuleResult result = passwordValidator.validate(data);

        if (!result.isValid()) {
            throw new ContraseñaIncorrectaExecption("La contraseña ingresada no cumple con los "
                    + " requisitos solicitados, le invitamos a ingresar una contraseña valida.");
        }
        return true;
    }

    @Override
    public boolean validarIgualdadContraseñasEcriptadas(String contraseñaOriginal, String contraseñaEncriptada) {

        boolean isValid = passwordEncoder.matches(contraseñaOriginal, contraseñaEncriptada);

        if (!isValid) {
            throw new ContraseñaIncorrectaExecption("Error la contraseña ingresada no es igual a la "
                    + "del usuario seleccionado."
                    + "Le invitamos a ingresar una contraseña valida");
        }

        return true;

    }

}
