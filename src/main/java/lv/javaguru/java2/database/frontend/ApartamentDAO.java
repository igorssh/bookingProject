package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Apartament;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21..
 */
public interface ApartamentDAO {

    void create(Apartament ap) throws DBException;

    Apartament getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Apartament ap) throws DBException;

    List<Apartament> getAll() throws DBException;
}
