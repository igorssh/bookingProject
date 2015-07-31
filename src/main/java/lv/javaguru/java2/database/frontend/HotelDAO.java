package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Hotel;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21
 */

public interface HotelDAO {

    void create(Hotel ap) throws DBException;

    Hotel getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Hotel ap) throws DBException;

    List<Hotel> getAll() throws DBException;
}
