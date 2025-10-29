/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.DatosPersonales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurante_gratitude.demp.DTOS.Request.Cuenta.EditarDatosBasicosDto.EditarDireccionDto;
import restaurante_gratitude.demp.Entidades.Direccion.Ciudad;
import restaurante_gratitude.demp.Entidades.Direccion.Departamento;
import restaurante_gratitude.demp.Entidades.Direccion.Direccion;
import restaurante_gratitude.demp.Entidades.Direccion.Municipio;
import restaurante_gratitude.demp.Entidades.Direccion.Pais;
import restaurante_gratitude.demp.Entidades.Direccion.TipoDireccion;
import restaurante_gratitude.demp.Entidades.Usuarios.Usuario;
import restaurante_gratitude.demp.Repositorys.Direccion.CiudadRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.DepartamentoRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.DireccionRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.MunicipioRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.PaisRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.TipoDireccionRepository;
import restaurante_gratitude.demp.Repositorys.Users.UsuarioRepository;
import restaurante_gratitude.demp.Service.Cuenta.Perfil.EditarDatosDireccionPerfil;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class EditarDatosDireccionPerfilService implements EditarDatosDireccionPerfil {

    private PaisRepository paisRepo;
    private DepartamentoRepository depRepo;
    private CiudadRepository ciudadRepo;
    private MunicipioRepository munrepo;
    private UsuarioRepository usuarioRepo;
    private DireccionRepository dirRepo;
    private TipoDireccionRepository tipoDir;

    @Autowired
    public EditarDatosDireccionPerfilService(PaisRepository paisRepo, DepartamentoRepository depRepo, CiudadRepository ciudadRepo, MunicipioRepository munrepo, UsuarioRepository usuarioRepo, DireccionRepository dirRepo, TipoDireccionRepository tipoDir) {
        this.paisRepo = paisRepo;
        this.depRepo = depRepo;
        this.ciudadRepo = ciudadRepo;
        this.munrepo = munrepo;
        this.usuarioRepo = usuarioRepo;
        this.dirRepo = dirRepo;
        this.tipoDir = tipoDir;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editarMidireccion(Integer id_usuario, EditarDireccionDto direccionDto) {

        Usuario usuario = ValidacionesGlobales.obtenerSiExiste(
                usuarioRepo.findById(id_usuario),
                "Error el usuario no existe en el sistema.");

        Direccion direccion = ValidacionesGlobales.obtenerSiExiste(
                dirRepo.findById(usuario.getDireccion().getId()),
                "Error la direccion no existe");

        direccion.setBarrio(direccionDto.getBarrio());

        Pais pais = ValidacionesGlobales.obtenerSiExiste(
                paisRepo.findByNombre(direccionDto.getPais()),
                "Error el pais no existe en el sistema");

        direccion.setPais(pais);

        Departamento departamento = ValidacionesGlobales.obtenerSiExiste(
                depRepo.findByNombre(direccionDto.getDepartamento()),
                "Error el departamento no existe en el sistema.");

        direccion.setDepartamento(departamento);

        Ciudad ciudad = ValidacionesGlobales.obtenerSiExiste(
                ciudadRepo.findByNombre(direccionDto.getCiudad()),
                "Error la ciudad no existe en el sistema");

        direccion.setCiudad(ciudad);

        Municipio municipio = ValidacionesGlobales.obtenerSiExiste(
                munrepo.findByNombre(direccionDto.getMunicipio()),
                "Error el municipio no existe en el sistema");

        TipoDireccion tipoDireccion = ValidacionesGlobales.obtenerSiExiste(
                tipoDir.findByNombre(direccionDto.getTipoDirecion()),
                "El tipo de direccion no existe en el sistema.");

        direccion.setMunicipio(municipio);

        dirRepo.save(direccion);

        usuario.setDireccion(direccion);

        usuarioRepo.save(usuario);

    }

}
