/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Direcciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.DTOS.Request.Direccion.DepartamentoDto;
import restaurante_gratitude.demp.Entidades.Direccion.Departamento;
import restaurante_gratitude.demp.Entidades.Direccion.Pais;
import restaurante_gratitude.demp.Repositorys.Direccion.DepartamentoRepository;
import restaurante_gratitude.demp.Repositorys.Direccion.PaisRepository;
import restaurante_gratitude.demp.Service.Direcciones.GestionarDepartamentos;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarDepartamentosService implements GestionarDepartamentos {

    private DepartamentoRepository depRepo;
    private PaisRepository paisRepo;

    @Autowired
    public GestionarDepartamentosService(DepartamentoRepository depRepo, PaisRepository paisRepo) {
        this.depRepo = depRepo;
        this.paisRepo = paisRepo;
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

        Pais pais = ValidacionesGlobales.obtenerSiExiste(paisRepo
                .findByNombre(departamentoDto.getPais()),
                "Error de regristrar un nuevo departamento. "
                + "El pais ingresado no se encuentra en el sistema"
                + ", le einvitamos a ingresar un pais valido.");

        departamento.setPais(pais);
        depRepo.save(departamento);

        return departamentoDto;
    }

}
