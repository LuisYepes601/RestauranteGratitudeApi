/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Devoluciones;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import restaurante_gratitude.demp.Entidades.Devoluciones.Reembolso.Reembolso;
import restaurante_gratitude.demp.Entidades.Pedidos.Pedido;
import restaurante_gratitude.demp.Entidades.Usuarios.Admin;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;

/**
 *
 * @author Usuario
 */
@Entity
public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "devolucion")
    private Reembolso reembolso;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoDevolucion tipoDevolucion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaDevolucion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaSolicitud;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoDevolucion estadoDevolucion;

    @OneToMany(mappedBy = "devolucion")
    private List<RespuestaDevolucion> respuestaDevoluciones;
    
    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Admin admin;
    
    
    
    
    
    

}
