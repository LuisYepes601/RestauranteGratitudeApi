/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Users;

/**
 *
 * @author Usuario
 */
public class UsuarioBasicDTO {

    private int id;
    private String primerNombre;
    private String primerApellido;
    private String telefono;
    private String email;
    private String identificacion; // ID of Identificacion
    private String tipoIdntificacion; // ID of Direccion for delivery

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoIdntificacion() {
        return tipoIdntificacion;
    }

    public void setTipoIdntificacion(String tipoIdntificacion) {
        this.tipoIdntificacion = tipoIdntificacion;
    }

}
