package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Rezervation;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21..
 */
public interface RezervationDAO {
    void create(Rezervation rez) throws DBException;

    Rezervation getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Rezervation rez) throws DBException;

    List<Rezervation> getAll() throws DBException;
}
