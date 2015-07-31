package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.HotelClass;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21
 */

public interface HotelClassDAO {

    void create(HotelClass ap) throws DBException;

    HotelClass getById(long id) throws DBException;

    void delete(long id) throws DBException;

    void update(HotelClass ap) throws DBException;

    List<HotelClass> getAll() throws DBException;
}
