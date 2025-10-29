/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Reservas;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoInvalidoException;
import restaurante_gratitude.demp.Controller.Reservas.ReservaDto;
import restaurante_gratitude.demp.Entidades.Reservas.Mesa;
import restaurante_gratitude.demp.Entidades.Reservas.Reserva;
import restaurante_gratitude.demp.Entidades.Reservas.TipoReserva;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Reservas.MesaRepository;
import restaurante_gratitude.demp.Repositorys.Reservas.ReservaRepository;
import restaurante_gratitude.demp.Repositorys.Reservas.TipoReservaRepository;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Reservas.ReservasGestion;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarCorreos.GestionarCorreosService;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarPlantillas.ReservaExitosaTemplate;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class ReservasGestionService implements ReservasGestion {

    private ReservaRepository reservaRepository;
    private MesaRepository mesaRepo;
    private TipoReservaRepository tipoReservaRepo;
    private UsuarioRepository usuarioRepo;
    private GestionarCorreosService correosService;
    private ReservaExitosaTemplate reservaExitosa;

    @Autowired
    public ReservasGestionService(ReservaRepository reservaRepository, MesaRepository mesaRepo, TipoReservaRepository tipoReservaRepo, UsuarioRepository usuarioRepo, GestionarCorreosService correosService, ReservaExitosaTemplate reservaExitosa) {
        this.reservaRepository = reservaRepository;
        this.mesaRepo = mesaRepo;
        this.tipoReservaRepo = tipoReservaRepo;
        this.usuarioRepo = usuarioRepo;
        this.correosService = correosService;
        this.reservaExitosa = reservaExitosa;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void crearReserva(ReservaDto reservaDto) {

        if (!reservaDto.getHoraInicio().before(reservaDto.getHoraFin())) {
            throw new DatoInvalidoException("La hora de inicio debe ser anterior a la hora de fin.");
        }

        if (reservaDto.getHoraInicio().equals(reservaDto.getHoraFin())) {
            throw new DatoInvalidoException("La hora de inicio y la hora de fin no pueden ser iguales.");
        }

        List<Reserva> reservas = reservaRepository.findReservasExistentes(
                reservaDto.getIdMesa(),
                reservaDto.getFecha(),
                reservaDto.getHoraInicio(),
                reservaDto.getHoraFin());

        if (!reservas.isEmpty()) {

            throw new DatoInvalidoException("Error datos invalidos, no hay mesas disponibles en esa fecha y horarios, "
                    + "le inviatmos a ingresar datos validos.");
        }

        Reserva reserva = new Reserva();

        reserva.setFecha(reservaDto.getFecha());
        reserva.setHoraInicio(reservaDto.getHoraInicio());
        reserva.setHoraFin(reservaDto.getHoraFin());

        Mesa mesa = ValidacionesGlobales.obtenerSiExiste(
                mesaRepo.findById(reservaDto.getIdMesa()),
                "La mesa seleccionada no se encuentra disponible en el sistema");

        reserva.setMesa(mesa);

        TipoReserva tipoReserva = ValidacionesGlobales.obtenerSiExiste(
                tipoReservaRepo.findById(reservaDto.getIdTipoReserva()),
                "Error, el tipo de reserva no existe.");
        reserva.setTipoReserva(tipoReserva);

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(usuarioRepo.
                findById(reservaDto.getIdUsuario()),
                "Erro el usuario no existe en el sistema.");
        reserva.setUsuario(usuario);

        reservaRepository.save(reserva);

        correosService.enviarCorreoConFormatoHtml(
                usuario.getEmail(),
                "Confirmación de reserva",
                reservaExitosa.reservaexistosa(
                        usuario.getPrimerNombre(),
                        reserva.getFecha(),
                        reserva.getHoraInicio(),
                        reserva.getHoraFin(),
                        mesa.getNumero(),
                        tipoReserva.getNombre()),
                "yepesluis006@gmail.com");

    }

    @Override
    public List<ReservaDto> obtenerReservas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ReservaDto obtenerReservaPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarReserva(Long id, ReservaDto reservaDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarReserva(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
