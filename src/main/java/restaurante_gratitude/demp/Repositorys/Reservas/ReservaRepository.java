/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.Reservas;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import restaurante_gratitude.demp.Entidades.Reservas.Reserva;

/**
 *
 * @author User
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    // Buscar reservas existentes para la misma mesa y fecha que se solapen con un rango de horas
    @Query(value = """
    SELECT * FROM reserva r
    WHERE r.id_mesa = :idMesa 
      AND r.fecha = :fecha
      AND (CAST(r.hora_inicio AS time) < CAST(:horaFin AS time)
      AND  CAST(r.hora_fin AS time) > CAST(:horaInicio AS time))
""", nativeQuery = true)
    List<Reserva> findReservasExistentes(
            @Param("idMesa") Integer idMesa,
            @Param("fecha") Date fecha,
            @Param("horaInicio") Date horaInicio,
            @Param("horaFin") Date horaFin
    );

    // Buscar reservas por usuario
    List<Reserva> findByUsuarioId(Integer idUsuario);

    // Buscar reservas por mesa
    List<Reserva> findByMesaId(Integer idMesa);

    // Buscar reservas por fecha
    List<Reserva> findByFecha(Date fecha);

}
