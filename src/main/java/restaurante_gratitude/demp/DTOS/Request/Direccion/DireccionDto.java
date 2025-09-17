/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Direccion;

/**
 *
 * @author User
 */
public class DireccionDto {
    
    private String pais;
    private String barrio;
    private String departamento;
    private String ciudad;
    private String municipio;
    private String calle;
    private String tipoDireccion;

    public DireccionDto(String pais, String barrio, String departamento, String ciudad, String municipio, String calle, String tipoDireccion) {
        this.pais = pais;
        this.barrio = barrio;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.municipio = municipio;
        this.calle = calle;
        this.tipoDireccion = tipoDireccion;
    }

    public DireccionDto() {
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getTipoDireccion() {
        return tipoDireccion;
    }

    public void setTipoDireccion(String tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }
    
    
}
