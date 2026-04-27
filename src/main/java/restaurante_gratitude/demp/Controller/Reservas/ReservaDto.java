/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Controller.Reservas;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ReservaDto {

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Bogota")
    @NotNull(message = "La fecha es obligatoria")
    private Date fecha;

    @JsonFormat(pattern = "HH:mm:ss", timezone = "America/Bogota")
    @NotNull(message = "La hora de inicio es obligatoria")
    private Date horaInicio;

    @JsonFormat(pattern = "HH:mm:ss", timezone = "America/Bogota")
    @NotNull(message = "La hora de fin es obligatoria")
    private Date horaFin;

    @NotNull(message = "El id del administrador es obligatorio")
    private Long idAdmin;

    @NotNull(message = "El id de la mesa es obligatorio")
    private Integer idMesa;

    @NotNull(message = "El id del tipo de reserva es obligatorio")
    private Integer idTipoReserva;

    @NotNull(message = "El id del usuario es obligatorio")
    private Integer idUsuario;

    public ReservaDto() {
    }

    public ReservaDto(Date fecha, Date horaInicio, Date horaFin, Long idAdmin, Integer idMesa, Integer idTipoReserva, Integer idUsuario) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.idAdmin = idAdmin;
        this.idMesa = idMesa;
        this.idTipoReserva = idTipoReserva;
        this.idUsuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public Integer getIdTipoReserva() {
        return idTipoReserva;
    }

    public void setIdTipoReserva(Integer idTipoReserva) {
        this.idTipoReserva = idTipoReserva;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

}
