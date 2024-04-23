package mx.utng.sesion26.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import mx.utng.sesion26.model.entity.RegistroHogarGasto;

@Repository
public class RegistroHorgarGastoDaoImpl implements IRegistroHogarGastoDao{
    
    @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<RegistroHogarGasto> list() {
        return em.createQuery("from RegistroHogarGasto").getResultList();
        
    }

    @Override
    public void save(RegistroHogarGasto registroHogarGasto) {
        if(registroHogarGasto.getId()!=null && registroHogarGasto.getId()>0){
            //Actualizar si registroHorario no es null 
            em.merge(registroHogarGasto);
        }else{
            //Crear un nuevo registroHogarGasto
            em.persist(registroHogarGasto);
        }
        
    }

    @Override
    public RegistroHogarGasto getById(Long id) {
        //PARA ENCONTRAR A UN ESTUDIANTE CON EL id que esta en los PARAMETROS

        return em.find(RegistroHogarGasto.class, id);        
    }

    @Override
    public void delete(Long id) {
    RegistroHogarGasto registroHogarGasto = getById(id); 
    em.remove(registroHogarGasto);
    }
}
