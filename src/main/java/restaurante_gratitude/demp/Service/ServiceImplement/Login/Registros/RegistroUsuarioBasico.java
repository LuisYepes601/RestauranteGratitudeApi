/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Login.Registros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.CorreoEnUso;
import restaurante_gratitude.demp.DTOS.Request.Login.RegistroUsuarioBasicoDto;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Genero;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Identificaciones.Identificacion;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Identificaciones.TipoIdentificacion;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Sexo;
import restaurante_gratitude.demp.Entidades.Direccion.Ciudad;
import restaurante_gratitude.demp.Entidades.Direccion.Departamento;
import restaurante_gratitude.demp.Entidades.Direccion.Direccion;
import restaurante_gratitude.demp.Entidades.Direccion.Municipio;
import restaurante_gratitude.demp.Entidades.Direccion.Pais;
import restaurante_gratitude.demp.Entidades.Direccion.TipoDireccion;
import restaurante_gratitude.demp.Entidades.Roles.Rol;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.GeneroRepository;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.Identificaciones.TipoIdentificacionRepository;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.SexoRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.CiudadRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.DepartamentoRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.MunicipioRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.PaisRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.TipoDireccionRepository;
import restaurante_gratitude.demp.Repositorys.Roles.RolRepository;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Login.Registro.RegistrarUsuariobasico;

/**
 *
 * @author User
 */
@Service
public class RegistroUsuarioBasico implements RegistrarUsuariobasico {

    private UsuarioRepository ususrioRepository;
    private RolRepository rolRepo;
    private PaisRepository paisRepo;
    private DepartamentoRepository deptoRepo;
    private CiudadRepository ciudadRepo;
    private MunicipioRepository municipioRepo;
    private TipoDireccionRepository tipoDirRepo;
    private GeneroRepository generoRepository;
    private SexoRepository sexoRepo;
    private TipoIdentificacionRepository tipoIdentificacionRepo;

    @Autowired
    public RegistroUsuarioBasico(UsuarioRepository ususrioRepository, RolRepository rolRepo, PaisRepository paisRepo, DepartamentoRepository deptoRepo, CiudadRepository ciudadRepo, MunicipioRepository municipioRepo, TipoDireccionRepository tipoDirRepo, GeneroRepository generoRepository, SexoRepository sexoRepo, TipoIdentificacionRepository tipoIdentificacionRepo) {
        this.ususrioRepository = ususrioRepository;
        this.rolRepo = rolRepo;
        this.paisRepo = paisRepo;
        this.deptoRepo = deptoRepo;
        this.ciudadRepo = ciudadRepo;
        this.municipioRepo = municipioRepo;
        this.tipoDirRepo = tipoDirRepo;
        this.generoRepository = generoRepository;
        this.sexoRepo = sexoRepo;
        this.tipoIdentificacionRepo = tipoIdentificacionRepo;
    }

    @Override
    public RegistroUsuarioBasicoDto registrar(RegistroUsuarioBasicoDto usuarioBasicoDto) {

        Usuario usuario = new Usuario();

        usuario = ususrioRepository.findByEmail(usuarioBasicoDto.getEmail()).get();

        if (usuario != null) {
            throw new CorreoEnUso("Error: Correo asociado a una cuenta existente: Lo invitamos a colocar un correo válido ");
        }

        usuario.setPrimerNombre(usuarioBasicoDto.getPrimerNombre());
        usuario.setSegundoNombre(usuarioBasicoDto.getSegundoNombre());
        usuario.setPrimerApellido(usuarioBasicoDto.getPrimerApellido());
        usuario.setSegundoApellido(usuarioBasicoDto.getSegundoApellido());
        usuario.setTelefono(usuarioBasicoDto.getTelefono());
        usuario.setEmail(usuarioBasicoDto.getEmail());

        Identificacion identificacion = new Identificacion();
        identificacion.setNumero(usuarioBasicoDto.getNumeroDeIdentificacion());

        TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();
        tipoIdentificacion = tipoIdentificacionRepo.findByNombre(usuarioBasicoDto.getTipoIdentificacion()).get();

        usuario.setIdentificacion(identificacion);

        Rol rol = new Rol();
        rol = rolRepo.findByNombre(usuarioBasicoDto.getRol().toLowerCase()).get();
        usuario.setRol(rol);

        Direccion direccion = new Direccion();
        direccion.setBarrio(usuarioBasicoDto.getBarrio());
        direccion.setCalle(usuarioBasicoDto.getCalle());

        Pais pais = new Pais();
        pais = paisRepo.findByNombre(usuarioBasicoDto.getPais()).get();
        direccion.setPais(pais);

        Departamento departamento = new Departamento();
        departamento = deptoRepo.findByNombre(usuarioBasicoDto.getDepartamento()).get();
        direccion.setDepartamento(departamento);

        Ciudad ciudad = new Ciudad();
        ciudad = ciudadRepo.findByNombre(usuarioBasicoDto.getCiudad()).get();
        direccion.setCiudad(ciudad);

        Municipio municipio = new Municipio();
        municipio = municipioRepo.findByNombre(usuarioBasicoDto.getMunicipio()).get();
        direccion.setMunicipio(municipio);

        TipoDireccion tipoDireccion = new TipoDireccion();
        tipoDireccion = tipoDirRepo.findByNombre(usuarioBasicoDto.getTipoDireccion()).get();
        direccion.setTipoDireccion(tipoDireccion);
        usuario.setDireccion(direccion);

        Genero genero = new Genero();
        genero = generoRepository.findByNombre(usuarioBasicoDto.getGenero()).get();
        usuario.setGenero(genero);

        Sexo sexo = new Sexo();
        sexo = sexoRepo.findByNombre(usuarioBasicoDto.getSexo()).get();
        usuario.setSexo(sexo);

        usuario.setFechaNacimiento(usuarioBasicoDto.getFechaNacimiento());
        usuario.setFechaRegistro(usuarioBasicoDto.getFechaRegistro());
        usuario.setContraseña(usuarioBasicoDto.getContraseña());

        ususrioRepository.save(usuario);

        return usuarioBasicoDto;

    }
}
