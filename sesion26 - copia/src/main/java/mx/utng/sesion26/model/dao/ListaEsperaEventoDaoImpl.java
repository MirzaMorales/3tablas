package mx.utng.sesion26.model.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.sesion26.model.entity.ListaEsperaEvento;

 @Repository
public class ListaEsperaEventoDaoImpl implements IListaEsperaEventoDao{


    @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<ListaEsperaEvento> list() {
        return em.createQuery("from ListaEsperaEvento").getResultList();
        
    }

    @Override
    public void save(ListaEsperaEvento listaEsperaEvento) {
        if(listaEsperaEvento.getId()!=null && listaEsperaEvento.getId()>0){
            //Actualizar si registroHorario no es null 
            em.merge(listaEsperaEvento);
        }else{
            //Crear un nuevo registroHorario
            em.persist(listaEsperaEvento);
        }
        
    }

    @Override
    public ListaEsperaEvento getById(Long id) {
        //PARA ENCONTRAR A UN ESTUDIANTE CON EL id que esta en los PARAMETROS

        return em.find(ListaEsperaEvento.class, id);        
    }

    @Override
    public void delete(Long id) {
    ListaEsperaEvento listaEsperaEvento = getById(id); 
    em.remove(listaEsperaEvento);
    }
    
}
