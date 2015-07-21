package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Klient;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21..
 */
public interface KlientDAO {

    void create(Klient kli) throws DBException;

    Klient getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Klient kli) throws DBException;

    List<Klient> getAll() throws DBException;
}
