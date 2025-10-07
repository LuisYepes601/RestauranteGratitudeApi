/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.ControlExeptions.Execptions;

/**
 *
 * @author User
 */
public class ErrorAlSubirArchivoException extends RuntimeException{

    public ErrorAlSubirArchivoException(String message) {
        super(message);
    }

    public ErrorAlSubirArchivoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
