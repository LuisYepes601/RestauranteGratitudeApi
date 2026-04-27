/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Identificacion;

/**
 *
 * @author User
 */
public class IngresarIdentificacionDto {

    private String numero;

    private TipoIdentificacionDto tipoIdentificacionDto;

    public IngresarIdentificacionDto(String numero, TipoIdentificacionDto tipoIdentificacionDto) {
        this.numero = numero;
        this.tipoIdentificacionDto = tipoIdentificacionDto;
    }

    public IngresarIdentificacionDto() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoIdentificacionDto getTipoIdentificacionDto() {
        return tipoIdentificacionDto;
    }

    public void setTipoIdentificacionDto(TipoIdentificacionDto tipoIdentificacionDto) {
        this.tipoIdentificacionDto = tipoIdentificacionDto;
    }

}
