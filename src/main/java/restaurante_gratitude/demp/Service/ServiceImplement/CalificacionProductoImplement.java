/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.Entidades.RangoCalificacion.CalficacionProducto;
import restaurante_gratitude.demp.Repositorys.Calificaciones.CalificacionProductoRepository;
import restaurante_gratitude.demp.Service.CalificacionProductoService;

/**
 *
 * @author Usuario
 */
@Service
public class CalificacionProductoImplement implements CalificacionProductoService {
    
    @Autowired
    private CalificacionProductoRepository cal;

    @Override
    public List<CalficacionProducto> calficacionProductos() {
        
        cal.findAll();
        
        return new ArrayList<>();
    }

}
