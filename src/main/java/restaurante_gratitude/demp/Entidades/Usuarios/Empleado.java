/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Entidades.Usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import restaurante_gratitude.demp.Entidades.Estudios.Estudio;
import restaurante_gratitude.demp.Entidades.InformacionLaboral.InformacionLaboral;

/**
 *
 * @author Usuario
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Empleado extends Usuario {

    @OneToOne
    @JoinColumn(name = "id_informacion_laboral")
    private InformacionLaboral informacionLaboral;

    @OneToMany(mappedBy = "empleado")
    private List<Estudio> estudios;

}
