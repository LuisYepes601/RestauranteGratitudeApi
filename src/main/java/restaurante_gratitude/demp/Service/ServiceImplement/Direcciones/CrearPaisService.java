/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Direcciones;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.PaisYaCreado;
import restaurante_gratitude.demp.DTOS.Request.Direccion.PaisDto;
import restaurante_gratitude.demp.Entidades.Direccion.Pais;
import restaurante_gratitude.demp.Repositorys.Direccion.PaisRepository;
import restaurante_gratitude.demp.Service.Direcciones.AgregarPais;

/**
 *
 * @author User
 */
@Service
public class CrearPaisService implements AgregarPais {

    private PaisRepository paisRepo;

    @Autowired
    public CrearPaisService(PaisRepository paisRepo) {
        this.paisRepo = paisRepo;
    }

    public CrearPaisService() {
    }

    public PaisRepository getPaisRepo() {
        return paisRepo;
    }

    public void setPaisRepo(PaisRepository paisRepo) {
        this.paisRepo = paisRepo;
    }

    @Override
    public PaisDto crearPais(PaisDto paisDto) {

        Pais pais = new Pais();

        Optional<Pais> existente = paisRepo.findByNombre(paisDto.getNombre());

        existente = paisRepo.findByNombre(paisDto.getNombre().toLowerCase());

        if (existente.isPresent()) {
            throw new PaisYaCreado("Error el pais ya ha existe en el sistema, no se puede agregar nuevamente.");
        }

        pais.setNombre(paisDto.getNombre());

        paisRepo.save(pais);
        return paisDto;
    }

}
