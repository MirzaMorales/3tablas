package mx.utng.sesion26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.sesion26.model.dao.IListaEsperaEventoDao;
import mx.utng.sesion26.model.entity.ListaEsperaEvento;


@Service
public class ListaEsperaEventoServiceImpl implements IListaEsperaEventoService{

    @Autowired
    private IListaEsperaEventoDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<ListaEsperaEvento> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(ListaEsperaEvento listaEsperaEvento) {
        dao.save(listaEsperaEvento);
    }

    @Transactional(readOnly =  true)
    @Override
    public ListaEsperaEvento getById(Long id) {
       return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
       dao.delete(id);
    }

    

}
