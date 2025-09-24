/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.InformacionLaboral;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.ControlExeptions.Execptions.UsuarioNoEncontradoException;
import restaurante_gratitude.demp.DTOS.Request.InformacionLaboralDto.ExperienciaDto;
import restaurante_gratitude.demp.DTOS.Request.InformacionLaboralDto.InformacionLaboralDto;
import restaurante_gratitude.demp.Entidades.InformacionLaboral.Experiencia;
import restaurante_gratitude.demp.Entidades.InformacionLaboral.InformacionLaboral;
import restaurante_gratitude.demp.Entidades.Usuarios.Empleado;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.InformacionLaboral.ExperienciaRepository;
import restaurante_gratitude.demp.Repositorys.InformacionLaboral.InformacionLaboralRepository;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.InformacionLaboral.RegistroInformacionLaboral;

/**
 *
 * @author User
 */
@Service
public class RegistroInformacionLaboralService implements RegistroInformacionLaboral {

    private UsuarioRepository UsuarioRepository;
    private InformacionLaboralRepository infoLboralRepo;
    private ExperienciaRepository ExperienciaRepository;

    @Autowired
    public RegistroInformacionLaboralService(UsuarioRepository UsuarioRepository, InformacionLaboralRepository infoLboralRepo, ExperienciaRepository ExperienciaRepository) {
        this.UsuarioRepository = UsuarioRepository;
        this.infoLboralRepo = infoLboralRepo;
        this.ExperienciaRepository = ExperienciaRepository;
    }

    public RegistroInformacionLaboralService() {
    }

    public UsuarioRepository getUsuarioRepository() {
        return UsuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRepository UsuarioRepository) {
        this.UsuarioRepository = UsuarioRepository;
    }

    public InformacionLaboralRepository getInfoLboralRepo() {
        return infoLboralRepo;
    }

    public void setInfoLboralRepo(InformacionLaboralRepository infoLboralRepo) {
        this.infoLboralRepo = infoLboralRepo;
    }

    public ExperienciaRepository getExperienciaRepository() {
        return ExperienciaRepository;
    }

    public void setExperienciaRepository(ExperienciaRepository ExperienciaRepository) {
        this.ExperienciaRepository = ExperienciaRepository;
    }

    @Override
    public InformacionLaboralDto registrarInformacionLaboral(InformacionLaboralDto informacionLaboralDto) {

        Optional<Usuario> usuario = UsuarioRepository.findByEmail(informacionLaboralDto.getEmail());

        if (usuario.isEmpty()) {
            throw new UsuarioNoEncontradoException("Usuario no se encuentra registrado en el sistema");
        }

        Usuario usuarioActual = new Usuario();

        usuarioActual = usuario.get();

        InformacionLaboral informacionLaboral = new InformacionLaboral();

        infoLboralRepo.save(informacionLaboral);

        Empleado empleado = usuarioActual.getEmpleado();

        empleado.setInformacionLaboral(informacionLaboral);

        List<ExperienciaDto> experiencias = informacionLaboralDto.getExperiencias();

        if (experiencias.isEmpty()) {

            throw new NoDatosQueMostrarExecption("Error experiencia no puede estar vacio");
        }

        List<Experiencia> experienciasActual = new ArrayList<>();

        for (ExperienciaDto experiencia : experiencias) {

            Experiencia e = new Experiencia();
            e.setCargo(experiencia.getCargo());
            e.setCorreo(experiencia.getCorreo());
            e.setDuracion(experiencia.getDuracion());
            e.setInstitucion(experiencia.getInstitucion());
            e.setJefeInmediato(experiencia.getJefeInmediato());
            e.setTelefono(experiencia.getTelefono());
            e.setInformacionLaboral(informacionLaboral);
            e.setUrl_certificado(experiencia.getUrl_certificado());

            experienciasActual.add(e);

        }

        informacionLaboral.setExperiencias(experienciasActual);

        return informacionLaboralDto;
    }

}
