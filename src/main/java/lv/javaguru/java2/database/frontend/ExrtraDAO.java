package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Extra;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21..
 */
public interface ExrtraDAO {

    void create(Extra ext) throws DBException;

    Extra getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Extra ext) throws DBException;

    List<Extra> getAll() throws DBException;
}
