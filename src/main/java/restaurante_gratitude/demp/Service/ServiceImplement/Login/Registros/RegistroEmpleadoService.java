/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Login.Registros;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.DTOS.Request.InformacionLaboralDto.InformacionLaboralDto;
import restaurante_gratitude.demp.Entidades.InformacionLaboral.InformacionLaboral;
import restaurante_gratitude.demp.Entidades.Usuarios.Empleado;
import restaurante_gratitude.demp.Repositorys.InformacionLaboral.ExperienciaRepository;
import restaurante_gratitude.demp.Repositorys.InformacionLaboral.InformacionLaboralRepository;
import restaurante_gratitude.demp.Repositorys.Users.EmpleadoRepository;
import restaurante_gratitude.demp.Service.Login.Registro.RegistroEmpleado.RegistroInformacionLaboral;

/**
 *
 * @author Usuario
 */
@Service
public class RegistroEmpleadoService implements RegistroInformacionLaboral {

    private EmpleadoRepository empleadoRepo;
    private ExperienciaRepository experienciaRepo;
    private InformacionLaboralRepository inforLaboralrepository;
    private RegistroUsuarioBasico usuarioBasicoService;

    public RegistroEmpleadoService() {
    }

    @Autowired
    public RegistroEmpleadoService(EmpleadoRepository empleadoRepo, ExperienciaRepository experienciaRepo, InformacionLaboralRepository inforLaboralrepository) {
        this.empleadoRepo = empleadoRepo;
        this.experienciaRepo = experienciaRepo;
        this.inforLaboralrepository = inforLaboralrepository;
    }

    @Override
    public InformacionLaboralDto registrarInformacionLaboral(InformacionLaboralDto informacionLaboralDto) {

        Optional<Empleado> empleado = empleadoRepo.findById(informacionLaboralDto.getId());
        if (empleado.isEmpty()) {

        }

        InformacionLaboral informacionLaboral = new InformacionLaboral();
        inforLaboralrepository.save(informacionLaboral);

        Empleado empleado1 = new Empleado();
        empleado1.setInformacionLaboral(informacionLaboral);

        empleadoRepo.save(empleado1);

        return informacionLaboralDto;

    }

}
