package mx.utng.sesion26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.sesion26.model.dao.IRegistroHorarioDao;
import mx.utng.sesion26.model.entity.RegistroHorario;
/*
 * Una clase service, esta basada aen el patrón de diseño fachada 
 * Es un único punto de acceso hacia los DAO(Date access object).Dentro de la clase service, podemos operar
 * con distintas clases DAO.  donde atraves de la interfce de IStudentService.java en este 
 * apartado se extiende lo que se amplia las herramientas de moficacion de cada de las nuevas 
 */
@Service
public class RegistroHorarioServiceImpl implements IRegistroHorarioService {
    //Inyectamos la interfaz para utilizar los métodos de CRUD. 
    //C-Create, R-Read Retrieve, U-Update,D-Delete. 
    @Autowired
    private IRegistroHorarioDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<RegistroHorario> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(RegistroHorario registroHorario) {
        dao.save(registroHorario);
    }

    @Transactional(readOnly =  true)
    @Override
    public RegistroHorario getById(Long id) {
       return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
       dao.delete(id);
    }

    
}
