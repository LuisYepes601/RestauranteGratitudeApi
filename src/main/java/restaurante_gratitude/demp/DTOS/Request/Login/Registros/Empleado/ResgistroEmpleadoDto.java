/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Login.Registros.Empleado;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import restaurante_gratitude.demp.DTOS.Request.Login.Registros.RegistroUsuarioBasicoDto;

/**
 *
 * @author Usuario
 */
public class ResgistroEmpleadoDto {

    @Valid
    @NotNull(message = "El bloque usuarioBasicoDto no puede ser nulo")
    private RegistroUsuarioBasicoDto usuarioBasicoDto;

    public ResgistroEmpleadoDto(RegistroUsuarioBasicoDto usuarioBasicoDto) {
        this.usuarioBasicoDto = usuarioBasicoDto;

    }

    public ResgistroEmpleadoDto() {
    }

    public RegistroUsuarioBasicoDto getUsuarioBasicoDto() {
        return usuarioBasicoDto;
    }

    public void setUsuarioBasicoDto(RegistroUsuarioBasicoDto usuarioBasicoDto) {
        this.usuarioBasicoDto = usuarioBasicoDto;
    }

}
