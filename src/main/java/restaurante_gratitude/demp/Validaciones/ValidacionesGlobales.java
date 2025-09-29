/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Validaciones;

import java.util.Optional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoNoExistenteEcxeption;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoYaExistenteException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.RolNoValidoException;

/**
 *
 * @author User
 */
public class ValidacionesGlobales {

    public static <T> T obtenerSiExiste(Optional<T> optional, String mensajeError) {

        return optional.orElseThrow(() -> new DatoNoExistenteEcxeption(mensajeError));

    }

    public static void validarExistencia(Optional<?> optional, String mensaje) {

        if (optional.isPresent()) {
            throw new DatoYaExistenteException(mensaje);
        }
    }

    public static void verificarCodigoRol(String codigoEsperado, String codigoIngresado, String mensajeError) {
        if (!codigoEsperado.equalsIgnoreCase(codigoIngresado)) {
            throw new DatoNoExistenteEcxeption(mensajeError);
        }
    }

    public static void esEmpleado(String rol, String mensaje) {
        if (rol.toLowerCase().equalsIgnoreCase("usuario")) {
            throw new RolNoValidoException(mensaje);
        }
    }

}
