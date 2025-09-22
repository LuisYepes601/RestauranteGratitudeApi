/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.DTOS.Request.Estudios;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class EstudioDto {

    @NotBlank(message = "Nivel de estudio no puede estar vacio, "
            + "lo invitamos a rellenarlo para seguir con su regitro de informacion educativa")
    private String nivelEstudio;

    @NotBlank(message = "El campo institucion debe estar relleno, lo invitamos a rellenar el campo, "
            + "por ejemplo: Nombre: Universidad de los Andes")
    private String nombreInstitucion;

    @NotNull(message = "La fecha de inicio no  puede estar vacia")
    private Date fechaInicio;

    @NotBlank(message = "Estado de estudio no puede quedar vacio, escoja una opcion,"
            + " Por ejemplo: En proceso")
    private String estadoEstudio;

    @NotBlank(message = "El campo modalidad no puede quedar vacio, "
            + "lo invitamos a rellenar el campo, Por ejemplo: Modalidad: Presencial")
    private String modalidad;

    @NotNull(message = "El id de empleado no puede estar vacio")
    @Positive()
    private int id_empleado;

}
