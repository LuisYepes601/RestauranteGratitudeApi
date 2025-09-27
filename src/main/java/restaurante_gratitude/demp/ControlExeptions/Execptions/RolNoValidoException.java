/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.ControlExeptions.Execptions;

/**
 *
 * @author Usuario
 */
public class RolNoValidoException extends RuntimeException{

    public RolNoValidoException(String message) {
        super(message);
    }

    public RolNoValidoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
