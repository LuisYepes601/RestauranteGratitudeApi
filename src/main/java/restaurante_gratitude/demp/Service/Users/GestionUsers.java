/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Service.Users;

import restaurante_gratitude.demp.DTOS.Request.Users.UsuarioBasicDTO;

/**
 *
 * @author Usuario
 */
public interface GestionUsers {
    
    public UsuarioBasicDTO obtnerUsuarioByID(Integer id);
}
