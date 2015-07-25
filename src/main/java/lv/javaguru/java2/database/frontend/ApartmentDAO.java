package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Apartment;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21
 */

public interface ApartmentDAO {

    void create(Apartment ap) throws DBException;

    Apartment getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Apartment ap) throws DBException;

    List<Apartment> getAll() throws DBException;
}
