package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.ApClass;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21..
 */
public interface ApClassDAO {

    void create(ApClass ap) throws DBException;

    ApClass getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(ApClass ap) throws DBException;

    List<ApClass> getAll() throws DBException;
}
