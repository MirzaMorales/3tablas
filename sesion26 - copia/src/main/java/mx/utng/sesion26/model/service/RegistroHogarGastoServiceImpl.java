package mx.utng.sesion26.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.sesion26.model.dao.IRegistroHogarGastoDao;
import mx.utng.sesion26.model.entity.RegistroHogarGasto;

@Service
public class RegistroHogarGastoServiceImpl implements IRegistroHogarGastoService{

    @Autowired
    private IRegistroHogarGastoDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<RegistroHogarGasto> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(RegistroHogarGasto registroHogarGasto) {
        dao.save(registroHogarGasto);
    }

    @Transactional(readOnly =  true)
    @Override
    public RegistroHogarGasto getById(Long id) {
       return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
       dao.delete(id);
    }
}
