/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.InformacionLaboral;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import restaurante_gratitude.demp.Entidades.Contratos.Contrato;
import restaurante_gratitude.demp.Entidades.Contratos.TipoContrato;
import restaurante_gratitude.demp.Entidades.TipoHorario;

/**
 *
 * @author Usuario
 */
@Entity
public class InformacionLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private double salario;

    @OneToMany(mappedBy = "informacionLaboral")
    List<Experiencia> experiencias;

    @ManyToOne
    @JoinColumn(name = "id_tipo_horario")
    private TipoHorario tipoHorario;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato contrato;
}
