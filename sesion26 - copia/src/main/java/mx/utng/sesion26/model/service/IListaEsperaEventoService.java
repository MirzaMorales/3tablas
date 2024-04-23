package mx.utng.sesion26.model.service;

import mx.utng.sesion26.model.entity.ListaEsperaEvento;
import java.util.List;

public interface IListaEsperaEventoService {
    List<ListaEsperaEvento> list();
    void save (ListaEsperaEvento listaEsperaEvento); 
    ListaEsperaEvento getById(Long id); 
    void delete (Long id);
}
