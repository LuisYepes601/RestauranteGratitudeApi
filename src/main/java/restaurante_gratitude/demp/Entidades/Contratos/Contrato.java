/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Contratos;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import restaurante_gratitude.demp.Entidades.TipoDuracion;

/**
 *
 * @author Usuario
 */
@Entity
public class Contrato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_contrato")
    private TipoContrato tipoContrato;
    
    @Column(nullable = false)
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_duaracion")
    private TipoDuracion tipoDuracion;
    
    
}
