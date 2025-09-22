/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Direccion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author User
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CiudadDto {

    private String name;

    public CiudadDto(String name) {
        this.name = name;
    }

    public CiudadDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
