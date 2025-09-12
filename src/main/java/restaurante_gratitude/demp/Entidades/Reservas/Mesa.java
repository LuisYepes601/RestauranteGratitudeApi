/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Reservas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author Usuario
 */
@Entity
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    @Column(nullable = false)
    private int numero;

    @Column(nullable = false)
    private int capacidad;

    private String ur_img_mesa;

    @ManyToOne
    @JoinColumn(name = "id_estado_mesa")
    private EstadoMesa estadoMesa;

    public Mesa(int id, int numero, int capacidad, String ur_img_mesa, EstadoMesa estadoMesa) {
        this.id = id;
        this.numero = numero;
        this.capacidad = capacidad;
        this.ur_img_mesa = ur_img_mesa;
        this.estadoMesa = estadoMesa;
    }

    public Mesa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getUr_img_mesa() {
        return ur_img_mesa;
    }

    public void setUr_img_mesa(String ur_img_mesa) {
        this.ur_img_mesa = ur_img_mesa;
    }

    public EstadoMesa getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(EstadoMesa estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

}
