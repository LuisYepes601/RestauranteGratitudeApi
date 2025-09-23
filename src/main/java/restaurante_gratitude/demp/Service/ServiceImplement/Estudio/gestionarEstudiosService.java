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
import restaurante_gratitude.demp.ControlExeptions.Execptions.UsuarioNoEncontradoException;
import restaurante_gratitude.demp.DTOS.Request.Estudios.EstudioDto;
import restaurante_gratitude.demp.DTOS.Request.Estudios.RegistroInformacionEducativaDto;
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
    public RegistroInformacionEducativaDto agregarEstudios(RegistroInformacionEducativaDto informacionEducativaDto) {

        Optional<Usuario> usuario = usuarioRepo.findByEmail(informacionEducativaDto.getEmailEmpleado());

        if (usuario.isEmpty()) {
            throw new UsuarioNoEncontradoException("Usted no se ha registrado, para poder guardar la informacion  en "
                    + "el sistema primero debe "
                    + " registrar sus datos basicos");
        }

        List<Estudio> estudios = new ArrayList<>();

        Usuario u = usuario.get();

        Empleado empleado = u.getEmpleado();

        for (EstudioDto estudioActaul : informacionEducativaDto.getEstudios()) {

            Estudio estudio = new Estudio();
            estudio.setEmpleado(empleado);

            Optional<EstadoEstudio> estado = estadoEstudioRepo.findByNombre(estudioActaul.getEstadoEstudio());
            if (estado.isEmpty()) {
                throw new DatoNoExistenteEcxeption("Error: " + estudioActaul.getEstadoEstudio() + " no existe en el sistema. " + " El tipo de estado ingresado no se encuentra en el "
                        + "sistema intentelo nuevamente");
            }
            EstadoEstudio estadoEstudio = new EstadoEstudio();
            estadoEstudio = estado.get();

            estudio.setNombre(estudioActaul.getNombre());
            estudio.setFechaInicio(estudioActaul.getFechaInicio());
            estudio.setEstadoEstudio(estadoEstudio);

            Optional<Modalidad> modalidadValid = modalidadRepo.findByNombre(estudioActaul.getModalidad());

            if (modalidadValid.isEmpty()) {
                throw new DatoNoExistenteEcxeption("No se pudo guardar la información laboral. La modalidad: " + estudioActaul.getModalidad() + " no se encuentra registrada en el sistema");
            }

            Modalidad modalidad = new Modalidad();
            modalidad = modalidadValid.get();

            estudio.setModalidad(modalidad);

            Optional<NivelEstudio> nivelOptional = nivelEstudioRepo.findByNombre(estudioActaul.getNivelEstudio());

            if (nivelOptional.isEmpty()) {
                throw new DatoNoExistenteEcxeption("No se pudo guardar la información laboral. El nivel de estudio: "
                        + estudioActaul.getNivelEstudio() + " no se encuentra registrado en el sistema");

            }
            NivelEstudio nivelEstudio = new NivelEstudio();
            nivelEstudio = nivelOptional.get();

            estudio.setNivelEstudio(nivelEstudio);

            estudio.setNombreInstitucion(estudioActaul.getNombreInstitucion());
            estudios.add(estudio);

        }

        estudioRepo.saveAll(estudios);

        return informacionEducativaDto;
    }

}
