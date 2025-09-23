/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante_gratitude.demp.Service.ServiceImplement.Contratos.TipoContrato;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurante_gratitude.demp.ControlExeptions.Execptions.DatoYaExistenteException;
import restaurante_gratitude.demp.DTOS.Request.Contratos.tipoContratoDto;
import restaurante_gratitude.demp.Entidades.Contratos.TipoContrato;
import restaurante_gratitude.demp.Repositorys.Contratos.TipoContratoRepository;
import restaurante_gratitude.demp.Service.Contratos.TipoDeContrato.AgregarTipoContrato;

/**
 *
 * @author Usuario
 */
@Service
public class TipoContratoService implements AgregarTipoContrato {

    private TipoContratoRepository TipoContratoRepository;

    @Autowired
    public TipoContratoService(TipoContratoRepository TipoContratoRepository) {
        this.TipoContratoRepository = TipoContratoRepository;
    }

    public TipoContratoService() {
    }

    public TipoContratoRepository getTipoContratoRepository() {
        return TipoContratoRepository;
    }

    public void setTipoContratoRepository(TipoContratoRepository TipoContratoRepository) {
        this.TipoContratoRepository = TipoContratoRepository;
    }

    @Override
    public tipoContratoDto agregarTipoContrato(tipoContratoDto tipoContratoDto) {
        Optional<TipoContrato> optional = TipoContratoRepository.findByNombre(tipoContratoDto.getNombre());

        if (optional.isPresent()) {
            throw new DatoYaExistenteException("Tipo de contrato no agregado al sistema. "
                    + "El tipo de contrato que ingreso ya existe.");
        }

        TipoContrato tipoContrato = new TipoContrato();

        tipoContrato.setNombre(tipoContratoDto.getNombre());
        TipoContratoRepository.save(tipoContrato);

        return tipoContratoDto;
    }

}
