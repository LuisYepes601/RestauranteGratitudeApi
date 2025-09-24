/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Sexo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.DTOS.Request.Sexo.SexoDto;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Sexo;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.SexoRepository;
import restaurante_gratitude.demp.Service.Sexo.GestionarSexos;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class GestionarSexosService implements GestionarSexos {

    private SexoRepository sexoRepo;

    @Autowired
    public GestionarSexosService(SexoRepository sexoRepo) {
        this.sexoRepo = sexoRepo;
    }

    public GestionarSexosService() {
    }

    public SexoRepository getSexoRepo() {
        return sexoRepo;
    }

    public void setSexoRepo(SexoRepository sexoRepo) {
        this.sexoRepo = sexoRepo;
    }

    @Override
    public SexoDto agregarSexo(SexoDto sexoDto) {

        ValidacionesGlobales.validarExistencia(sexoRepo.findByNombre(sexoDto.getNombre()),
                "No se puede agregar el sexo: " + sexoDto.getNombre() + " por que ya está creado en el sistema, "
                + "le invitamos a agregar un nuevo sexo al sistema que sea valido.");

        Sexo sexo = new Sexo();

        sexo.setNombre(sexoDto.getNombre());
        sexoRepo.save(sexo);

        return sexoDto;
    }

}
