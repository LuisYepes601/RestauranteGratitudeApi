/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Genero;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoYaExistenteException;
import restaurante_gratitude.demp.DTOS.Request.Genero.GeneroDto;
import restaurante_gratitude.demp.Entidades.DatosBasicos.Genero;
import restaurante_gratitude.demp.Repositorys.DatosBasicos.GeneroRepository;
import restaurante_gratitude.demp.Service.Genero.GestionarGeneros;

/**
 *
 * @author Usuario
 */
@Service
public class GestionarGeneroService implements GestionarGeneros {

    private GeneroRepository generoRepo;

    @Autowired
    public GestionarGeneroService(GeneroRepository generoRepo) {
        this.generoRepo = generoRepo;
    }

    public GeneroRepository getGeneroRepo() {
        return generoRepo;
    }

    public void setGeneroRepo(GeneroRepository generoRepo) {
        this.generoRepo = generoRepo;
    }
    
    

    @Override
    public GeneroDto crearGenero(GeneroDto generoDto) {

        Optional<Genero> optional = generoRepo.findByNombre(generoDto.getNombre());

        if (optional.isPresent()) {
            throw new DatoYaExistenteException("El genero: " + generoDto.getNombre()
                    + " no se pudo agregar, por que ya existe en "
                    + "el sistems, lo invitamos a agregar un genero que no este creado ya.");
        }

        Genero genero = new Genero();
        genero.setNombre(generoDto.getNombre());

        generoRepo.save(genero);

        return generoDto;

    }

}
