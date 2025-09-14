/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Pedidos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import restaurante_gratitude.demp.Entidades.OfertsCupons.Cupones.Cupon;
import restaurante_gratitude.demp.Entidades.RangoCalificacion.RangoCalificacion;

/**
 *
 * @author Usuario
 */
@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaPedido;
    
    @Column(nullable = false)
    private double total;
    
    @Column(nullable = false)
    private int totalItems;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_pedido")
    private TipoPedido tipoPedido;
    
    @ManyToOne
    @JoinColumn(name = "id_estado_pedido")
    private EstadoPedido estadoPedido;
    
    @ManyToOne
    @JoinColumn(name = "id_rango_calificacion")
    private RangoCalificacion rangoCalificacion;
    
    @ManyToOne
    @JoinColumn(name = "id_cupon")
    private Cupon cupon;
    
    
    
    
    
    
    
    
    
}
