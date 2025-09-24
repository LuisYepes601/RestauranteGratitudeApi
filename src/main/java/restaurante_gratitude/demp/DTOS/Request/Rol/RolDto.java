/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Rol;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author User
 */
public class RolDto {

    @NotBlank(message = "El campo nombre del rol, no puede estar vacio, lo invitamos a "
            + "rellenarlo, por ejemplo: Nombre: Admin")
    private String nombre;

    private String codigo;

    public RolDto(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public RolDto(String nombre) {
        this.nombre = nombre;
    }

    public RolDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
