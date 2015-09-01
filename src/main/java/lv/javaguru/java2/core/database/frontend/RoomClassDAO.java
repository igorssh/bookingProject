package lv.javaguru.java2.core.database.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.domain.frontend.RoomClass;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21
 */

public interface RoomClassDAO {

    void create(RoomClass ap) throws DBException;

    RoomClass getById(long id) throws DBException;

    void delete(long id) throws DBException;

    void update(RoomClass ap) throws DBException;

    List<RoomClass> getAll() throws DBException;
}
