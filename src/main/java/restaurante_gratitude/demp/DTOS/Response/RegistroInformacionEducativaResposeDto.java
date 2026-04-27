/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Response;

/**
 *
 * @author Usuario
 */
public class RegistroInformacionEducativaResposeDto {

    private String mensaje;

    public RegistroInformacionEducativaResposeDto(String mensaje) {
        this.mensaje = mensaje;
    }

    public RegistroInformacionEducativaResposeDto() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
