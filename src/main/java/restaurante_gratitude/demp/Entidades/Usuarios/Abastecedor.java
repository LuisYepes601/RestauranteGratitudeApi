/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;
import restaurante_gratitude.demp.Entidades.ComprasSuministros.Compra;

/**
 *
 * @author Usuario
 */
@Entity
public class Abastecedor extends Empleado {

    @OneToMany(mappedBy = "abastecedor")
    private List<Compra> compras;
}
