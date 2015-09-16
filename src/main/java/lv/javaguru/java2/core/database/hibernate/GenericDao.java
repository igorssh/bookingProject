package lv.javaguru.java2.core.database.hibernate;

import lv.javaguru.java2.core.database.DBException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.09.14..
 */
public interface GenericDao<T, PK extends Serializable> {

    void create(T t) throws DBException;
    T getById(PK id) throws DBException;
    void update(T t) throws DBException;
    void delete(PK id) throws DBException;
    List<T> getAll() throws DBException;
    T getByFieldName(String field, String value) throws DBException;

}
