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
import restaurante_gratitude.demp.ControlExeptions.Execptions.CorreoEnUso;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoYaExistenteException;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.ControlExeptions.Execptions.PaisYaCreado;
import restaurante_gratitude.demp.ControlExeptions.Execptions.RolNoExisteExecption;
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

}
