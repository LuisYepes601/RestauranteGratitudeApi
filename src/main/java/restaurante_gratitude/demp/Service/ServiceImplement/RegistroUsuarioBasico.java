/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement;

import restaurante_gratitude.demp.DTOS.Request.Login.RegistroUsuarioBasicoDto;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Genero;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Identificaciones.Identificacion;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Identificaciones.TipoIdentificacion;
import restaurante_gratitude.demp.Entidades.Direccion.Ciudad;
import restaurante_gratitude.demp.Entidades.Direccion.Departamento;
import restaurante_gratitude.demp.Entidades.Direccion.Direccion;
import restaurante_gratitude.demp.Entidades.Direccion.Municipio;
import restaurante_gratitude.demp.Entidades.Direccion.Pais;
import restaurante_gratitude.demp.Entidades.Direccion.TipoDireccion;
import restaurante_gratitude.demp.Entidades.Roles.Rol;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.GeneroRepository;
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
public class RegistroUsuarioBasico implements RegistrarUsuariobasico {

    private UsuarioRepository ususrioRepository;
    private RolRepository rolRepo;
    private PaisRepository paisRepo;
    private DepartamentoRepository deptoRepo;
    private CiudadRepository ciudadRepo;
    private MunicipioRepository municipioRepo;
    private TipoDireccionRepository tipoDirRepo;
    private GeneroRepository generoRepository;

    @Override
    public RegistroUsuarioBasicoDto registrar(RegistroUsuarioBasicoDto usuarioBasicoDto) {

        Usuario usuario = new Usuario();
        usuario.setPrimerNombre(usuarioBasicoDto.getPrimerNombre());
        usuario.setSegundoNombre(usuarioBasicoDto.getSegundoNombre());
        usuario.setPrimerApellido(usuarioBasicoDto.getPrimerApellido());
        usuario.setSegundoApellido(usuarioBasicoDto.getSegundoApellido());
        usuario.setTelefono(usuarioBasicoDto.getTelefono());
        usuario.setEmail(usuarioBasicoDto.getEmail());

        Identificacion identificacion = new Identificacion();

        identificacion.setNumero(usuarioBasicoDto.getIngresarIdentificacionDto().getNumero());

        TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();

        tipoIdentificacion.setNombre(usuarioBasicoDto.getIngresarIdentificacionDto().getTipoIdentificacionDto().getNombre());

        identificacion.setTipoIdentificacion(tipoIdentificacion);

        usuario.setIdentificacion(identificacion);

        Rol rol = new Rol();
        rol = rolRepo.findByNombre(usuarioBasicoDto.getRolDto().getNombre().toLowerCase()).get();
        usuario.setRol(rol);

        Direccion direccion = new Direccion();
        direccion.setBarrio(usuarioBasicoDto.getDireccionDto().getBarrio());
        direccion.setCalle(usuarioBasicoDto.getDireccionDto().getCalle());

        Pais pais = new Pais();
        pais = paisRepo.findByNombre(usuarioBasicoDto.getDireccionDto().getPais().toLowerCase()).get();

        direccion.setPais(pais);

        Departamento departamento = new Departamento();
        departamento = deptoRepo.findByNombre(usuarioBasicoDto.getDireccionDto().getDepartamento()).get();

        direccion.setDepartamento(departamento);

        Ciudad ciudad = new Ciudad();
        ciudad = ciudadRepo.findByNombre(usuarioBasicoDto.getDireccionDto().getCiudad()).get();

        direccion.setCiudad(ciudad);

        Municipio municipio = new Municipio();
        municipio = municipioRepo.findByNombre(usuarioBasicoDto.getDireccionDto().getMunicipio()).get();

        direccion.setMunicipio(municipio);

        TipoDireccion tipoDireccion = new TipoDireccion();
        tipoDireccion = tipoDirRepo.findByNombre(usuarioBasicoDto.getDireccionDto().getTipoDireccion()).get();

        direccion.setTipoDireccion(tipoDireccion);

        usuario.setDireccion(direccion);

        Genero genero = new Genero();
        genero = generoRepository.findByNombre(usuarioBasicoDto.getGeneroByNameDto().getNombre()).get();
        
        usuario.setGenero(genero);

        ususrioRepository.save(usuario);
        return usuarioBasicoDto;

    }
}
