/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Login.Registros.Empleado;

import jakarta.validation.constraints.NotBlank;
import restaurante_gratitude.demp.DTOS.Request.Login.Registros.RegistroUsuarioBasicoDto;

/**
 *
 * @author Usuario
 */
public class ResgistroEmpleadoDto {

    private RegistroUsuarioBasicoDto usuarioBasicoDto;

    @NotBlank(message = "El código de rol es obligatorio para el registro, por ejemplo "
            + "rol: Admin , Codigo: 1250")
    private String codigoRol;

    public ResgistroEmpleadoDto(RegistroUsuarioBasicoDto usuarioBasicoDto, String codigoRol) {
        this.usuarioBasicoDto = usuarioBasicoDto;
        this.codigoRol = codigoRol;
    }

    public ResgistroEmpleadoDto() {
    }

    public RegistroUsuarioBasicoDto getUsuarioBasicoDto() {
        return usuarioBasicoDto;
    }

    public void setUsuarioBasicoDto(RegistroUsuarioBasicoDto usuarioBasicoDto) {
        this.usuarioBasicoDto = usuarioBasicoDto;
    }

    public String getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(String codigoRol) {
        this.codigoRol = codigoRol;
    }

}
