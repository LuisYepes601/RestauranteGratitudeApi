/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.ControlExeptions.Execptions;

/**
 *
 * @author Usuario
 */
public class ContraseñaIncorrectaExecption extends RuntimeException {

    public ContraseñaIncorrectaExecption(String message) {
        super(message);
    }

    public ContraseñaIncorrectaExecption(String message, Throwable cause) {
        super(message, cause);
    }

}
