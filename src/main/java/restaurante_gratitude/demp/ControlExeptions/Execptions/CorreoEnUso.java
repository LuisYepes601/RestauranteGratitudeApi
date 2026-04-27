/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.ControlExeptions.Execptions;

/**
 *
 * @author User
 */
public class CorreoEnUso extends RuntimeException {

    public CorreoEnUso(String message) {
        super(message);
    }

    public CorreoEnUso(String message, Throwable cause) {
        super(message, cause);
    }

}
