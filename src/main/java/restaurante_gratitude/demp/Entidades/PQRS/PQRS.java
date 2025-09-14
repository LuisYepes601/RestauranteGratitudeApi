/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.PQRS;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

/**
 *
 * @author Usuario
 */
@Entity
public class PQRS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoPqrs estadoPqrs;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoPqrs tipoPqrs;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_canal")
    private TipoCanal tipoCanal;
    
    @Column(nullable = false)
    private String adjunto;
    
    
    
    

}
