/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Direcciones;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import restaurante_gratitude.demp.DTOS.Request.Direccion.CiudadDto;
import restaurante_gratitude.demp.Entidades.Direccion.Ciudad;
import restaurante_gratitude.demp.Repositorys.Direccion.CiudadRepository;
import restaurante_gratitude.demp.Service.Direcciones.AgregarCiudades;

/**
 *
 * @author User
 */
@Service
public class gestionarCiudades implements AgregarCiudades {

    private CiudadRepository ciudadRepo;

    @Autowired
    public gestionarCiudades(CiudadRepository ciudadRepo) {
        this.ciudadRepo = ciudadRepo;
    }

    public gestionarCiudades() {
    }

    public CiudadRepository getCiudadRepo() {
        return ciudadRepo;
    }

    public void setCiudadRepo(CiudadRepository ciudadRepo) {
        this.ciudadRepo = ciudadRepo;
    }

    @Override
    public void agregarCiudades() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api-colombia.com/api/v1/City?sortBy=name&sortDirection=asc";

        List<?> rawList = restTemplate.getForObject(url, List.class);

        ObjectMapper mapper = new ObjectMapper();
        List<CiudadDto> ciudades = mapper.convertValue(
                rawList, new TypeReference<List<CiudadDto>>() {
        }
        );

        for (CiudadDto ciudadDto : ciudades) {
            Ciudad ciudad = new Ciudad();
            ciudad.setNombre(ciudadDto.getName());
            ciudadRepo.save(ciudad);
        }

    }

}
