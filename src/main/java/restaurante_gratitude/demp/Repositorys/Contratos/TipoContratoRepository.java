/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package restaurante_gratitude.demp.Repositorys.Contratos;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import restaurante_gratitude.demp.Entidades.Contratos.TipoContrato;

/**
 *
 * @author User
 */
public interface TipoContratoRepository extends JpaRepository<TipoContrato, Integer> {

    public Optional<TipoContrato> findByNombre(String nombre);
}
