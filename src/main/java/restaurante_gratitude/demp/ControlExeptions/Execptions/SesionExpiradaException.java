/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.ControlExeptions.Execptions;

/**
 *
 * @author User
 */
public class SesionExpiradaException extends RuntimeException {

    public SesionExpiradaException(String message) {
        super(message);
    }

    public SesionExpiradaException(String message, Throwable cause) {
        super(message, cause);
    }

}
