/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Direcciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.DTOS.Request.Direccion.PaisDto;
import restaurante_gratitude.demp.Entidades.Direccion.Pais;
import restaurante_gratitude.demp.Repositorys.Direccion.PaisRepository;
import restaurante_gratitude.demp.Service.Direcciones.AgregarPais;
import restaurante_gratitude.demp.Validaciones.ValidacionesGlobales;

/**
 *
 * @author User
 */
@Service
public class GestionarPaisService implements AgregarPais {

    private PaisRepository paisRepo;

 

    public GestionarPaisService() {
    }

    @Autowired
    public GestionarPaisService(PaisRepository paisRepo) {
        this.paisRepo = paisRepo;
    }

    public void setPaisRepo(PaisRepository paisRepo) {
        this.paisRepo = paisRepo;
    }
       public PaisRepository getPaisRepo() {
        return paisRepo;
    }

    @Override
    public PaisDto crearPais(PaisDto paisDto) {
        ValidacionesGlobales.validarExistencia(paisRepo.findByNombre(paisDto.getNombre()),
                "El pais: " + paisDto.getNombre() + " ya existe en el sistema lo invitamos a agregar un pais valido.");

        Pais pais = new Pais();
        pais.setNombre(paisDto.getNombre());

        paisRepo.save(pais);
        return paisDto;
    }

}
