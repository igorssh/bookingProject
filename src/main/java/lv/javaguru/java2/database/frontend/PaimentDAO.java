package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Paiment;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21..
 */
public interface PaimentDAO {

    void create(Paiment pa) throws DBException;

    Paiment getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Paiment pa) throws DBException;

    List<Paiment> getAll() throws DBException;
}
