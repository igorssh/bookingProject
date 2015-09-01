package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.HotelClass;

import java.util.List;

public interface HotelClassDAO {

    void create(HotelClass hotelClass) throws DBException;

    HotelClass getById(long id) throws DBException;

    void delete(long id) throws DBException;

    void update(HotelClass hotelClass) throws DBException;

    List<HotelClass> getAll() throws DBException;
}
