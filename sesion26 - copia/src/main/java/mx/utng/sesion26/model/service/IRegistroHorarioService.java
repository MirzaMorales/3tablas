package mx.utng.sesion26.model.service;

import mx.utng.sesion26.model.entity.RegistroHorario;
import java.util.List;

public interface IRegistroHorarioService {
    List<RegistroHorario> list();
    void save (RegistroHorario registroHorario); 
    RegistroHorario getById(Long id); 
    void delete (Long id);
}
