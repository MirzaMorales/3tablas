package mx.utng.sesion26.model.dao;
import java.util.List;
import mx.utng.sesion26.model.entity.RegistroHorario;


public interface IRegistroHorarioDao {
    List<RegistroHorario> list(); 
    void save(RegistroHorario registroHorario);
    RegistroHorario getById(Long id);
    void delete (Long id);

}
