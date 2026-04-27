/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Cuenta;

/**
 *
 * @author Usuario
 */
public interface ValidarPoliticasDeContraseñas {

    public boolean validarFormatoContraseña(String password);
    
    public boolean  validarIgualdadContraseñasEcriptadas(String contraseñaOriginal, String contraseñaEncriptada);
}
