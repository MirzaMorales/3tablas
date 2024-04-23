package mx.utng.sesion26.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.sesion26.model.entity.RegistroHorario;

 @Repository
public class RegistroHorarioDaoImpl implements IRegistroHorarioDao {

    //Entity manager y contexto de persistencia  = Gestor de entidad persistencia nos permite ver los datos mas de una vez como la base de datos donde puedes acceder a la info
    //Guarda internamente todas las entidades y utiliza como una chache datos de DB

     @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<RegistroHorario> list() {
        return em.createQuery("from RegistroHorario").getResultList();
        
    }

    @Override
    public void save(RegistroHorario registroHorario) {
        if(registroHorario.getId()!=null && registroHorario.getId()>0){
            //Actualizar si registroHorario no es null 
            em.merge(registroHorario);
        }else{
            //Crear un nuevo registroHorario
            em.persist(registroHorario);
        }
        
    }

    @Override
    public RegistroHorario getById(Long id) {
        //PARA ENCONTRAR A UN ESTUDIANTE CON EL id que esta en los PARAMETROS

        return em.find(RegistroHorario.class, id);        
    }

    @Override
    public void delete(Long id) {
    RegistroHorario registroHorario = getById(id); 
    em.remove(registroHorario);
    }
    
}
