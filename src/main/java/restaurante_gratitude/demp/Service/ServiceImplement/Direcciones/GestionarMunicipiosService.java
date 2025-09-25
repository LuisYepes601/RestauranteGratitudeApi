/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Direcciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.DTOS.Request.Direccion.MunicipioDto;
import restaurante_gratitude.demp.Entidades.Direccion.Municipio;
import restaurante_gratitude.demp.Repositorys.Direccion.MunicipioRepository;
import restaurante_gratitude.demp.Service.Direcciones.GestionarMunicipios;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarMunicipiosService implements GestionarMunicipios {

    private MunicipioRepository municipioRepo;

    @Autowired
    public GestionarMunicipiosService(MunicipioRepository municipioRepo) {
        this.municipioRepo = municipioRepo;
    }

    public GestionarMunicipiosService() {
    }

    public MunicipioRepository getMunicipioRepo() {
        return municipioRepo;
    }

    public void setMunicipioRepo(MunicipioRepository municipioRepo) {
        this.municipioRepo = municipioRepo;
    }

    @Override
    public MunicipioDto crearMunicipio(MunicipioDto municipioDto) {

        ValidacionesGlobales.validarExistencia(municipioRepo
                .findByNombre(municipioDto.getNombre()),
                "El municipio: " + municipioDto.getNombre() + " no se pudo agregar al sistema porque"
                + "ya existe, le invitamos a crear un municioio valido.");

        Municipio municipio = new Municipio();

        municipio.setNombre(municipioDto.getNombre());
        municipioRepo.save(municipio);
        return municipioDto;

    }

}
