/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.ComprasSuministros;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import restaurante_gratitude.demp.Entidades.Proveedores.Proveedor;

/**
 *
 * @author Usuario
 */
@Entity
public class Compra {
    
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;
    
    
}
