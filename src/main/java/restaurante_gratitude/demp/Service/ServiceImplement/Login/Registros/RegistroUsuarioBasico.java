/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Login.Registros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.DTOS.Request.Login.Registros.RegistroUsuarioBasicoDto;
import restaurante_gratitude.demp.Entidades.Cuenta.Estado_cuenta;
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
import restaurante_gratitude.demp.Repositorys.Cuenta.EstadoCuentaRepository;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.GeneroRepository;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.Identificaciones.IdentificacionRepository;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.Identificaciones.TipoIdentificacionRepository;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.SexoRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.CiudadRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.DepartamentoRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.DireccionRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.MunicipioRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.PaisRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.TipoDireccionRepository;
import restaurante_gratitude.demp.Repositorys.Roles.RolRepository;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Login.Registro.RegistrarUsuariobasico;
import restaurante_gratitude.demp.Service.ServiceImplement.Config.GestionarEncripatmientoContraseñasService;
import restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.Contraseña.ValidarContraseñasService;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarCorreos.GestionarCorreosService;
import restaurante_gratitude.demp.Service.ServiceImplement.GestionarPlantillas.RegistroExitoTemplate;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

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
    private GestionarEncripatmientoContraseñasService encriptarContraseñas;
    private DireccionRepository direccionRepo;
    private IdentificacionRepository identificacionRepo;
    private EstadoCuentaRepository estadoCuentaRepo;
    private ValidarContraseñasService validarContraseñasService;
    RegistroExitoTemplate exitoTemplate;
    private GestionarCorreosService correosService;

    @Autowired
    public RegistroUsuarioBasico(UsuarioRepository ususrioRepository, RolRepository rolRepo, PaisRepository paisRepo, DepartamentoRepository deptoRepo, CiudadRepository ciudadRepo, MunicipioRepository municipioRepo, TipoDireccionRepository tipoDirRepo, GeneroRepository generoRepository, SexoRepository sexoRepo, TipoIdentificacionRepository tipoIdentificacionRepo, GestionarEncripatmientoContraseñasService encriptarContraseñas, DireccionRepository direccionRepo, IdentificacionRepository identificacionRepo, EstadoCuentaRepository estadoCuentaRepo, ValidarContraseñasService validarContraseñasService, RegistroExitoTemplate exitoTemplate, GestionarCorreosService correosService) {
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
        this.encriptarContraseñas = encriptarContraseñas;
        this.direccionRepo = direccionRepo;
        this.identificacionRepo = identificacionRepo;
        this.estadoCuentaRepo = estadoCuentaRepo;
        this.validarContraseñasService = validarContraseñasService;
        this.exitoTemplate = exitoTemplate;
        this.correosService = correosService;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RegistroUsuarioBasicoDto registrar(RegistroUsuarioBasicoDto usuarioBasicoDto) {

        ValidacionesGlobales.validarExistencia(ususrioRepository.findByEmail(usuarioBasicoDto.getEmail()), "Error este correo ya esta asociado a una cuenta, "
                + "lo invitamos a ingresar uno valido. ");

        Usuario usuario = new Usuario();

        usuario.setPrimerNombre(usuarioBasicoDto.getPrimerNombre());
        usuario.setSegundoNombre(usuarioBasicoDto.getSegundoNombre());
        usuario.setPrimerApellido(usuarioBasicoDto.getPrimerApellido());
        usuario.setSegundoApellido(usuarioBasicoDto.getSegundoApellido());
        usuario.setTelefono(usuarioBasicoDto.getTelefono());
        usuario.setEmail(usuarioBasicoDto.getEmail());

        ValidacionesGlobales.validarExistencia(
                identificacionRepo.findByNumero(usuarioBasicoDto.getNumeroDeIdentificacion()),
                "Error en el registro, el número de identificacion ya esta asociado a una cuenta");

        Identificacion identificacion = new Identificacion();
        identificacion.setNumero(usuarioBasicoDto.getNumeroDeIdentificacion());

        TipoIdentificacion tipoIdentificacion = ValidacionesGlobales.obtenerSiExiste(tipoIdentificacionRepo
                .findByNombre(usuarioBasicoDto.getTipoIdentificacion()), "El tipo de identificación selecciona no existe en el sistema, "
                + "lo(a) invitamos a selecionar una opcion correcta para contiunuar el registro.");

        identificacion.setTipoIdentificacion(tipoIdentificacion);

        identificacionRepo.save(identificacion);

        usuario.setIdentificacion(identificacion);

        Rol rol = ValidacionesGlobales.obtenerSiExiste(rolRepo.findByNombre(usuarioBasicoDto.getRol()),
                "El rol: " + usuarioBasicoDto.getRol() + " no se encuentra en el sistema, lo invitamos a seleccionar una"
                + " opcion correcta, para ccontinuar con el registro.");

        System.out.println("rollllllllllllllllllllllllll:     " + usuarioBasicoDto.getRol());
        System.out.println("codigooooooooooooooooooooooo:" + rol.getCodigoRol());
        System.out.println("codigo ingresado:" + usuarioBasicoDto.getCodigoRol());

        if (!usuarioBasicoDto.getRol().toLowerCase().equalsIgnoreCase("usuario")) {
            ValidacionesGlobales.verificarCodigoRol(rol.getCodigoRol(),
                    usuarioBasicoDto.getCodigoRol(),
                    "Error de registro, "
                    + "el código de rol que ingreso no es valido para el rol que usted selecciono, "
                    + "lo invitamos a verificar la información ingresada.");
        }

        usuario.setRol(rol);

        Direccion direccion = new Direccion();
        direccion.setBarrio(usuarioBasicoDto.getBarrio());
        direccion.setCalle(usuarioBasicoDto.getCalle());

        Pais pais = ValidacionesGlobales.obtenerSiExiste(paisRepo
                .findByNombre(usuarioBasicoDto.getPais()),
                "El pais que ingreso no se encuentra disponible ene el sistema, le invitamos a seleccionar un pais válido");

        direccion.setPais(pais);

        Departamento departamento = ValidacionesGlobales.obtenerSiExiste(deptoRepo
                .findByNombre(usuarioBasicoDto.getDepartamento()),
                "El departamento que ingreso no se encuentra disponible en el sistema le "
                + "invitamos a selleccionar un válido. ");

        direccion.setDepartamento(departamento);

        Ciudad ciudad = ValidacionesGlobales.obtenerSiExiste(ciudadRepo
                .findByNombre(usuarioBasicoDto.getCiudad()),
                "La ciudad que selecciono no se encuentra disponible en el sistema, "
                + "le invitamos a seleccionar una ciudad que sea valida para continuar con el registro.");

        direccion.setCiudad(ciudad);

        Municipio municipio = ValidacionesGlobales.obtenerSiExiste(municipioRepo
                .findByNombre(usuarioBasicoDto.getMunicipio()),
                "El municipio seleccionado no se encuentra disponible en el sistema, "
                + "le invitamos a seleccionar un municipio que sea valido para continuar el registro");

        direccion.setMunicipio(municipio);

        TipoDireccion tipoDireccion = ValidacionesGlobales.obtenerSiExiste(tipoDirRepo
                .findByNombre(usuarioBasicoDto.getTipoDireccion()),
                "El tipo de dirección ingresada no se encuentra disponible en el sistema, le invitamos "
                + "a seleccionar un tipo de dirección valida, para continuar con el registro");

        direccion.setTipoDireccion(tipoDireccion);
        direccionRepo.save(direccion);

        usuario.setDireccion(direccion);

        Genero genero = ValidacionesGlobales.obtenerSiExiste(generoRepository.findByNombre(usuarioBasicoDto.getGenero()),
                "El tipo de genero ingresado, no se encuentra en el sistema, le invitamos a seleccionar un genero valido"
                + "para continuar con el registro.");

        usuario.setGenero(genero);

        Sexo sexo = ValidacionesGlobales.obtenerSiExiste(sexoRepo.findByNombre(usuarioBasicoDto.getSexo()),
                "El tipo de sexo que ingreso no se encuentra en el sistema");

        usuario.setSexo(sexo);

        usuario.setFechaNacimiento(usuarioBasicoDto.getFechaNacimiento());
        usuario.setFechaRegistro(usuarioBasicoDto.getFechaRegistro());

        validarContraseñasService.validarFormatoContraseña(usuarioBasicoDto.getContraseña());

        usuario.setContraseña(encriptarContraseñas
                .encriptarContraseñas(usuarioBasicoDto.getContraseña()));

        String estado_cuenta = "Activa";

        Estado_cuenta estado_cuenta1 = ValidacionesGlobales.obtenerSiExiste(estadoCuentaRepo
                .findByNombre(estado_cuenta),
                "El estado de cuenta: " + estado_cuenta
                + " no existe en el sistema, le einvitamos a ingresar o valor valido.");

        usuario.setEstado_cuenta(estado_cuenta1);

        ususrioRepository.save(usuario);

        correosService.enviarCorreoConFormatoHtml(usuario.getEmail(),
                "Regitro de usuario.",
                exitoTemplate.registroExitoso(usuario),
                "yepesluis006@gmail.com");

        return usuarioBasicoDto;

    }

}
