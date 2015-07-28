package lv.javaguru.java2.database.jdbc.backend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.backend.FunctionDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.backend.Function;

import java.util.List;

public class FunctionDAOImpl extends DAOImpl implements FunctionDAO {
    public void create(Function func) throws DBException {
        
    }

    public Function getById(Long id) throws DBException {
        return null;
    }

    public void delete(Long id) throws DBException {

    }

    public void update(Function func) throws DBException {

    }

    public List<Function> getAll() throws DBException {
        return null;
    }
}
