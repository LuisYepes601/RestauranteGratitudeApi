/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Login.Registros;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.DTOS.Request.Login.Registros.Empleado.ResgistroEmpleadoDto;
import restaurante_gratitude.demp.DTOS.Request.Login.Registros.RegistroUsuarioBasicoDto;
import restaurante_gratitude.demp.Entidades.Roles.Rol;
import restaurante_gratitude.demp.Entidades.Usuarios.Admin;
import restaurante_gratitude.demp.Entidades.Usuarios.Cocinero;
import restaurante_gratitude.demp.Entidades.Usuarios.Mesero;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Roles.RolRepository;
import restaurante_gratitude.demp.Repositorys.Users.AbastecedorRepository;
import restaurante_gratitude.demp.Repositorys.Users.AdminRepository;
import restaurante_gratitude.demp.Repositorys.Users.CocineroRepository;
import restaurante_gratitude.demp.Repositorys.Users.EmpleadoRepository;
import restaurante_gratitude.demp.Repositorys.Users.MeseroRepository;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Login.Registro.RegistroEmpleado.RegistroEmpleado;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class RegistroEmpleadoService implements RegistroEmpleado {

    private EmpleadoRepository empleadoRepo;
    private RegistroUsuarioBasico usuarioBasicoService;
    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private AdminRepository adminRepository;
    private CocineroRepository cocineroRepository;
    private MeseroRepository meseroRepository;
    private AbastecedorRepository abastecedorRepository;

    public RegistroEmpleadoService() {
    }

    @Autowired
    public RegistroEmpleadoService(EmpleadoRepository empleadoRepo, RegistroUsuarioBasico usuarioBasicoService, UsuarioRepository usuarioRepository, RolRepository rolRepository, AdminRepository adminRepository, CocineroRepository cocineroRepository, MeseroRepository meseroRepository, AbastecedorRepository abastecedorRepository) {
        this.empleadoRepo = empleadoRepo;
        this.usuarioBasicoService = usuarioBasicoService;
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.adminRepository = adminRepository;
        this.cocineroRepository = cocineroRepository;
        this.meseroRepository = meseroRepository;
        this.abastecedorRepository = abastecedorRepository;
    }

    @Override
    public ResgistroEmpleadoDto registrarEmpleado(ResgistroEmpleadoDto empleadoDto) {

        RegistroUsuarioBasicoDto usuarioBasicoDto = usuarioBasicoService.registrar(empleadoDto.getUsuarioBasicoDto());

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(usuarioRepository
                .findByEmail(empleadoDto.getUsuarioBasicoDto().getEmail()),
                "Error de registro, lo invitamos a registrar sus datos basicos en el sistema, para que se pueda regitrar con el perfil: "
                + empleadoDto.getUsuarioBasicoDto().getRol());

        if (usuario.getRol().getNombre().equalsIgnoreCase("admin")) {

            Admin admin = new Admin();
            admin.setUsuario(usuario);

        } else if (usuario.getRol().getNombre().equalsIgnoreCase("cocinero")) {

            Cocinero cocinero = new Cocinero();
            cocinero.setUsuario(usuario);
            cocineroRepository.save(cocinero);

        } else if (usuario.getRol().getNombre().equalsIgnoreCase("mesero")) {

            Mesero mesero = new Mesero();

            mesero.setUsuario(usuario);
            meseroRepository.save(mesero);
        }

        return empleadoDto;

    }

}
