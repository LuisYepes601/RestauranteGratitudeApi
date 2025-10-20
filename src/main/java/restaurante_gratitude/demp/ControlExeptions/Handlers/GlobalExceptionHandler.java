/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.ControlExeptions.Handlers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import restaurante_gratitude.demp.ControlExeptions.Execptions.ContraseñaIncorrectaExecption;
import restaurante_gratitude.demp.ControlExeptions.Execptions.CorreoEnUso;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoInvalidoException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoNoExistenteEcxeption;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoYaExistenteException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.EliminarArchivoException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.ErrorAlSubirArchivoException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.ControlExeptions.Execptions.PaisYaCreado;
import restaurante_gratitude.demp.ControlExeptions.Execptions.RolNoExisteExecption;
import restaurante_gratitude.demp.ControlExeptions.Execptions.RolNoValidoException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.SesionExpiradaException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.UsuarioNoEncontradoException;

/**
 *
 * @author Usuario
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CorreoEnUso.class)
    public ResponseEntity<Map<String, String>> correoEnUsoHandlerExecption(CorreoEnUso ex) {

        Map<String, String> error = new HashMap<>();

        error.put("Error:", ex.getMessage());
        error.put("Causa", ex.getCause().toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }

    @ExceptionHandler(PaisYaCreado.class)
    public ResponseEntity<Map<String, String>> PaisYaCreadoHandlerException(PaisYaCreado ex) {

        Map<String, String> error = new HashMap<>();

        error.put("Error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, String> errores = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error
                -> errores.put("Error", error.getDefaultMessage())
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);

    }

    @ExceptionHandler(NoDatosQueMostrarExecption.class)
    public ResponseEntity<Map<String, String>> handleNoDatosQueMostrarExecption(NoDatosQueMostrarExecption ex) {

        Map<String, String> error = new HashMap<>();

        error.put("Error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

    @ExceptionHandler(RolNoExisteExecption.class)
    public ResponseEntity<Map<String, String>> handleRolNoExisteExecption(RolNoExisteExecption ex) {

        Map<String, String> error = new HashMap<>();

        error.put("Error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);

    }

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<?> handlerUsuarioNoEncontradoException(UsuarioNoEncontradoException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("Error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    @ExceptionHandler(DatoYaExistenteException.class)
    public ResponseEntity<?> handlerDatoYaExistenteException(DatoYaExistenteException ex) {

        Map<String, String> error = new HashMap<>();

        error.put("Error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(error);
    }

    @ExceptionHandler(DatoNoExistenteEcxeption.class)
    public ResponseEntity<?> handlerDatoNoExistenteEcxeption(DatoNoExistenteEcxeption ex) {

        Map<String, String> error = new HashMap<>();

        error.put("Error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);

    }

    @ExceptionHandler(RolNoValidoException.class)
    public ResponseEntity<?> handlerRolNoValidoException(RolNoValidoException ex) {

        Map<String, String> error = new HashMap<>();

        error.put("Error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(error);
    }

    @ExceptionHandler(ContraseñaIncorrectaExecption.class)
    public ResponseEntity<?> handlerContraseñaIncorrectaExecption(ContraseñaIncorrectaExecption ex) {

        Map<String, String> error = new HashMap<>();

        error.put("Error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);

    }

    @ExceptionHandler(ErrorAlSubirArchivoException.class)
    public ResponseEntity<?> handlerErrorAlSubirArchivoException(ErrorAlSubirArchivoException ex) {

        Map<String, String> error = new HashMap<>();

        error.put("Error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(error);
    }

    @ExceptionHandler(EliminarArchivoException.class)
    public ResponseEntity<?> handlerEliminarArchivoException(EliminarArchivoException ex) {

        Map<String, String> errores = new HashMap<>();

        errores.put("Error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errores);
    }

    @ExceptionHandler(SesionExpiradaException.class)
    public ResponseEntity<?> handlerSesionExpiradaException(SesionExpiradaException ex) {

        Map<String, String> errores = new HashMap<>();

        errores.put("error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("mensaje", ""));

    }

    @ExceptionHandler(DatoInvalidoException.class)
    public ResponseEntity<Map<String, String>> handlerDatoInvalidoException(DatoInvalidoException exception) {

        Map<String, String> errores = new HashMap<>();
        errores.put("error", exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errores);

    }
}
