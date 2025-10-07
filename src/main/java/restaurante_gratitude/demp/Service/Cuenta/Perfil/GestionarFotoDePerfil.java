/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Cuenta.Perfil;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author User
 */
public interface GestionarFotoDePerfil {
    
    public String agregarFotoDePerfil(MultipartFile imagen, int id_user);
}
