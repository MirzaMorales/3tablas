package mx.utng.sesion26.model.service;

import mx.utng.sesion26.model.entity.RegistroHogarGasto;
import java.util.List;

public interface IRegistroHogarGastoService {
    
    List<RegistroHogarGasto> list();
    void save (RegistroHogarGasto registroHogarGasto); 
    RegistroHogarGasto getById(Long id); 
    void delete (Long id);
}
