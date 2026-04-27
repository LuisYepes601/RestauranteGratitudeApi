/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import restaurante_gratitude.demp.Entidades.InformacionLaboral.InformacionLaboral;
import restaurante_gratitude.demp.Entidades.Pedidos.Pedido;

/**
 *
 * @author Usuario
 */
@Entity
public class Mesero extends Empleado {

    @OneToMany(mappedBy = "mesero")
    private List<Pedido> pedidos;

}
