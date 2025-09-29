/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Cuenta.Contraseña;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.DTOS.Request.Cuenta.EstadoCuentaDto;
import restaurante_gratitude.demp.Entidades.Cuenta.Estado_cuenta;
import restaurante_gratitude.demp.Repositorys.Cuenta.EstadoCuentaRepository;
import restaurante_gratitude.demp.Service.Cuenta.GestionarEstadoDeCuenta;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarEstadoDeCuentaService implements GestionarEstadoDeCuenta {

    private EstadoCuentaRepository estadoCuentaRepo;

    @Autowired
    public GestionarEstadoDeCuentaService(EstadoCuentaRepository estadoCuentaRepo) {
        this.estadoCuentaRepo = estadoCuentaRepo;
    }

    public GestionarEstadoDeCuentaService() {
    }

    public EstadoCuentaRepository getEstadoCuentaRepo() {
        return estadoCuentaRepo;
    }

    public void setEstadoCuentaRepo(EstadoCuentaRepository estadoCuentaRepo) {
        this.estadoCuentaRepo = estadoCuentaRepo;
    }

    @Override
    public EstadoCuentaDto agregarEstadoDeCuenta(EstadoCuentaDto estadoCuentaDto) {

        ValidacionesGlobales.validarExistencia(estadoCuentaRepo
                .findByNombre(estadoCuentaDto.getNombre()),
                "No se pudo agregar el estado de cuenta: " + estadoCuentaDto.getNombre()
                + " por que ya se encuentra en el sistema, lo invitamos a ingresar un valor valido.");

        Estado_cuenta estado_cuenta = new Estado_cuenta();
        estado_cuenta.setNombre(estadoCuentaDto.getNombre());

        estadoCuentaRepo.save(estado_cuenta);

        return estadoCuentaDto;
    }

}
