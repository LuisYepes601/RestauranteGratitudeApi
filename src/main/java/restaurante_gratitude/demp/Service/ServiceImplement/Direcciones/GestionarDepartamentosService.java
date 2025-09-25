/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Direcciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.DTOS.Request.Direccion.DepartamentoDto;
import restaurante_gratitude.demp.Entidades.Direccion.Departamento;
import restaurante_gratitude.demp.Repositorys.Direccion.DepartamentoRepository;
import restaurante_gratitude.demp.Service.Direcciones.GestionarDepartamentos;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarDepartamentosService implements GestionarDepartamentos {

    private DepartamentoRepository depRepo;

    @Autowired
    public GestionarDepartamentosService(DepartamentoRepository depRepo) {
        this.depRepo = depRepo;
    }

    public GestionarDepartamentosService() {
    }

    public DepartamentoRepository getDepRepo() {
        return depRepo;
    }

    public void setDepRepo(DepartamentoRepository depRepo) {
        this.depRepo = depRepo;
    }

    @Override
    public DepartamentoDto agregarDepartamento(DepartamentoDto departamentoDto) {

        ValidacionesGlobales.validarExistencia(depRepo
                .findByNombre(departamentoDto.getNombre()),
                "Departamento: " + departamentoDto.getNombre() + " no se pudo agregar al sistema,"
                + " por que ya se encuentra registrado en el sistema."
                + "Le invitamos a agregar un departamento valido");

        Departamento departamento = new Departamento();
        departamento.setNombre(departamentoDto.getNombre());
        depRepo.save(departamento);

        return departamentoDto;
    }

}
