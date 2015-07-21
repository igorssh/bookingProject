package lv.javaguru.java2.database.backend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.backend.Function;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21..
 */
public interface FunctionDAO {

    void create(Function func) throws DBException;

    Function getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Function func) throws DBException;

    List<Function> getAll() throws DBException;
}
