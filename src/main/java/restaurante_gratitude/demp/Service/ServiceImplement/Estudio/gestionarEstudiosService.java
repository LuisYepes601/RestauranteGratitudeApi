/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Estudio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoNoExistenteEcxeption;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.ControlExeptions.Execptions.UsuarioNoEncontradoException;
import restaurante_gratitude.demp.DTOS.Request.Estudios.EstudioDto;
import restaurante_gratitude.demp.DTOS.Request.Estudios.RegistroInformacionEducativaDto;
import restaurante_gratitude.demp.DTOS.Response.RegistroInformacionEducativaResposeDto;
import restaurante_gratitude.demp.Entidades.Estudios.EstadoEstudio;
import restaurante_gratitude.demp.Entidades.Estudios.Estudio;
import restaurante_gratitude.demp.Entidades.Estudios.Modalidad;
import restaurante_gratitude.demp.Entidades.Estudios.NivelEstudio;
import restaurante_gratitude.demp.Entidades.Usuarios.Empleado;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.EstudiosRepository.EstadoEstudioRepository;
import restaurante_gratitude.demp.Repositorys.EstudiosRepository.EstudiosRepository;
import restaurante_gratitude.demp.Repositorys.EstudiosRepository.ModalidadEstudioRepository;
import restaurante_gratitude.demp.Repositorys.EstudiosRepository.NivelEstudioRepository;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Estudios.agregarEstudios;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class gestionarEstudiosService implements agregarEstudios {

    private EstudiosRepository estudioRepo;
    private UsuarioRepository usuarioRepo;
    private EstadoEstudioRepository estadoEstudioRepo;
    private ModalidadEstudioRepository modalidadRepo;
    private NivelEstudioRepository nivelEstudioRepo;

    @Autowired
    public gestionarEstudiosService(EstudiosRepository estudioRepo, UsuarioRepository usuarioRepo, EstadoEstudioRepository estadoEstudioRepo, ModalidadEstudioRepository modalidadRepo, NivelEstudioRepository nivelEstudioRepo) {
        this.estudioRepo = estudioRepo;
        this.usuarioRepo = usuarioRepo;
        this.estadoEstudioRepo = estadoEstudioRepo;
        this.modalidadRepo = modalidadRepo;
        this.nivelEstudioRepo = nivelEstudioRepo;
    }

    public gestionarEstudiosService() {
    }

    public EstudiosRepository getEstudioRepo() {
        return estudioRepo;
    }

    public void setEstudioRepo(EstudiosRepository estudioRepo) {
        this.estudioRepo = estudioRepo;
    }

    public UsuarioRepository getUsuarioRepo() {
        return usuarioRepo;
    }

    public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public EstadoEstudioRepository getEstadoEstudioRepo() {
        return estadoEstudioRepo;
    }

    public void setEstadoEstudioRepo(EstadoEstudioRepository estadoEstudioRepo) {
        this.estadoEstudioRepo = estadoEstudioRepo;
    }

    public ModalidadEstudioRepository getModalidadRepo() {
        return modalidadRepo;
    }

    public void setModalidadRepo(ModalidadEstudioRepository modalidadRepo) {
        this.modalidadRepo = modalidadRepo;
    }

    public NivelEstudioRepository getNivelEstudioRepo() {
        return nivelEstudioRepo;
    }

    public void setNivelEstudioRepo(NivelEstudioRepository nivelEstudioRepo) {
        this.nivelEstudioRepo = nivelEstudioRepo;
    }

    @Override
    public RegistroInformacionEducativaResposeDto agregarEstudios(RegistroInformacionEducativaDto informacionEducativaDto) {
//VERIFICAMOS QUE HAYA UN USUARIO ASOCIOADO AL EMAIL INGRESADO
        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(
                usuarioRepo.findByEmail(informacionEducativaDto.getEmailEmpleado()),
                "No se pede agregar estudios al usuario ascoiado, por que no existe "
                + "en el sistema. Le invitamos que ingres un usuario valido");

        if (informacionEducativaDto.getEstudios().isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay estudios que agregar, "
                    + "le invitamos a agregar estudios a su perfil.");
        }

        List<Estudio> estudios = new ArrayList<>();

        Empleado empleado = usuario.getEmpleado();

        for (EstudioDto estudioActaul : informacionEducativaDto.getEstudios()) {

            Estudio estudio = new Estudio();
            estudio.setEmpleado(empleado);

            EstadoEstudio estadoEstudio
                    = ValidacionesGlobales.obtenerSiExiste(
                            estadoEstudioRepo.findByNombre(estudioActaul.getEstadoEstudio()),
                            "Error: " + estudioActaul.getEstadoEstudio() + " no existe en el sistema. "
                            + " El tipo de estado ingresado no se encuentra en el "
                            + "sistema intentelo nuevamente");

            estudio.setNombre(estudioActaul.getNombre());
            estudio.setFechaInicio(estudioActaul.getFechaInicio());
            estudio.setEstadoEstudio(estadoEstudio);

            Modalidad modalidad = ValidacionesGlobales.obtenerSiExiste(
                    modalidadRepo.findByNombre(estudioActaul.getModalidad()),
                    "Error: La modalidad: " + estudioActaul.getModalidad() + " no existe e el sistema, "
                    + "le invitamos a ingresar un valor valido.");

            estudio.setModalidad(modalidad);

            NivelEstudio nivelEstudio = ValidacionesGlobales.obtenerSiExiste(
                    nivelEstudioRepo.findByNombre(estudioActaul.getNivelEstudio()),
                    "No se pudo guardar la información laboral. El nivel de estudio: "
                    + estudioActaul.getNivelEstudio() + " no se encuentra registrado en el sistema");

            estudio.setNivelEstudio(nivelEstudio);

            estudio.setNombreInstitucion(estudioActaul.getNombreInstitucion());
            estudios.add(estudio);

        }

        estudioRepo.saveAll(estudios);

        RegistroInformacionEducativaResposeDto informacionEducativaResposeDto = new RegistroInformacionEducativaResposeDto();
        informacionEducativaResposeDto.setMensaje("Informacion educativa rgeistrada con exito.");

        return informacionEducativaResposeDto;
    }

}
