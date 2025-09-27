/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.InformacionLaboral;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.Request.InformacionLaboralDto.ExperienciaDto;
import restaurante_gratitude.demp.DTOS.Request.InformacionLaboralDto.InformacionLaboralDto;
import restaurante_gratitude.demp.Entidades.InformacionLaboral.Experiencia;
import restaurante_gratitude.demp.Entidades.InformacionLaboral.InformacionLaboral;
import restaurante_gratitude.demp.Entidades.TipoDuracion;
import restaurante_gratitude.demp.Entidades.Usuarios.Empleado;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.InformacionLaboral.ExperienciaRepository;
import restaurante_gratitude.demp.Repositorys.InformacionLaboral.InformacionLaboralRepository;
import restaurante_gratitude.demp.Repositorys.TipoDuracionRepository;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.InformacionLaboral.RegistroInformacionLaboral;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class RegistroInformacionLaboralService implements RegistroInformacionLaboral {
    
    private UsuarioRepository UsuarioRepository;
    private InformacionLaboralRepository infoLboralRepo;
    private ExperienciaRepository ExperienciaRepository;
    private TipoDuracionRepository tipoDuracionRepo;
    
    @Autowired
    public RegistroInformacionLaboralService(UsuarioRepository UsuarioRepository, InformacionLaboralRepository infoLboralRepo, ExperienciaRepository ExperienciaRepository, TipoDuracionRepository tipoDuracionRepo) {
        this.UsuarioRepository = UsuarioRepository;
        this.infoLboralRepo = infoLboralRepo;
        this.ExperienciaRepository = ExperienciaRepository;
        this.tipoDuracionRepo = tipoDuracionRepo;
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
    
    public TipoDuracionRepository getTipoDuracionRepo() {
        return tipoDuracionRepo;
    }
    
    public void setTipoDuracionRepo(TipoDuracionRepository tipoDuracionRepo) {
        this.tipoDuracionRepo = tipoDuracionRepo;
    }

    //METODO QUE PERMITE AGREGAR INFORMACION LABORAL Y ESXPERIENCIAS LABORALES
    // ASOCIADAS A UN EMPLEADO
    @Override
    public InformacionLaboralDto registrarInformacionLaboral(InformacionLaboralDto informacionLaboralDto) {
        
        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(UsuarioRepository
                .findByEmail(informacionLaboralDto.getEmail()),
                "No se puede registrar información laboral. "
                + "El usuario no existe en el sistema.");
        
        ValidacionesGlobales.esEmpleado(usuario.getRol().getNombre(),
                "El rol: " + usuario.getRol().getNombre() + " no es valido, "
                + "para agregar información laboral."
                + "Le invitanos a intentarlo nuevamente con otro tipo de rol.");
        
        InformacionLaboral informacionLaboral = new InformacionLaboral();
        
        Empleado empleado = usuario.getEmpleado();
        
        empleado.setInformacionLaboral(informacionLaboral);
        
        infoLboralRepo.save(informacionLaboral);

        //AGREGAR EXPERIENCIAS LABORALES ASOCIADAS A UN USUSARIO
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
            
            TipoDuracion tipoDuracion = ValidacionesGlobales.obtenerSiExiste(tipoDuracionRepo
                    .findByNombre(experiencia.getTipoDuracion()),
                    "Error el tipo de duración ingresado no existe en el sistema."
                    + "Le invitamos a ingresar un valor que sea correcto.");
            
            e.setTipoDuracion(tipoDuracion);
            
            experienciasActual.add(e);
            
        }
        
        ExperienciaRepository.saveAll(experienciasActual);
        
        return informacionLaboralDto;
    }
    
}
