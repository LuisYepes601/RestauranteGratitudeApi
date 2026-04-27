/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Direcciones;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.NoDatosQueMostrarExecption;
import restaurante_gratitude.demp.DTOS.Request.Direccion.PaisDto;
import restaurante_gratitude.demp.Entidades.Direccion.Pais;
import restaurante_gratitude.demp.Repositorys.Direccion.PaisRepository;
import restaurante_gratitude.demp.Service.Direcciones.ObtenerPaises;

/**
 *
 * @author User
 */
@Service
public class ObtenerPaisesService implements ObtenerPaises {
    
    private PaisRepository paisRepository;
    
    @Autowired
    public ObtenerPaisesService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }
    
    public ObtenerPaisesService() {
    }
    
    public PaisRepository getPaisRepository() {
        return paisRepository;
    }
    
    public void setPaisRepository(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }
    
    @Override
    public List<PaisDto> ObtenerPaises() {
        
        List<PaisDto> paises = new ArrayList<>();
        
        List<Pais> paisesSinMapeo = new ArrayList<>();
        
        paisesSinMapeo = paisRepository.findAll();
        
        if (paisesSinMapeo.isEmpty()) {
            throw new NoDatosQueMostrarExecption("No hay paises que mostrar, intentelo mas tarde.");
        }
        
        for (Pais pais : paisesSinMapeo) {
            PaisDto paisDto = new PaisDto();
            paisDto.setNombre(pais.getNombre());
            paises.add(paisDto);
        }
        
        return paises;
    }
    
}
