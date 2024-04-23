package mx.utng.sesion26.model.dao;
import java.util.List;
import mx.utng.sesion26.model.entity.ListaEsperaEvento;


public interface IListaEsperaEventoDao {
    List<ListaEsperaEvento> list(); 
    void save(ListaEsperaEvento listaEsperaEvento);
    ListaEsperaEvento getById(Long id);
    void delete (Long id);

}