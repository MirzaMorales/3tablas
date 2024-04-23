package mx.utng.sesion26.model.dao;

import java.util.List;
import mx.utng.sesion26.model.entity.RegistroHogarGasto;

public interface IRegistroHogarGastoDao {

    List<RegistroHogarGasto> list(); 
    void save(RegistroHogarGasto registroHogarGasto);
    RegistroHogarGasto getById(Long id);
    void delete (Long id);
    
}
