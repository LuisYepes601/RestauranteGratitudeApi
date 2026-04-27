/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Cuenta.EditarDatosBasicosDto;

/**
 *
 * @author Usuario
 */
public class EditarDireccionDto {

    private String pais;
    private String departamento;
    private String ciudad;
    private String municipio;
    private String barrio;
    private String tipoDirecion;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getTipoDirecion() {
        return tipoDirecion;
    }

    public void setTipoDirecion(String tipoDirecion) {
        this.tipoDirecion = tipoDirecion;
    }

}
