package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Room;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21..
 */
public interface RoomDAO {
    void create(Room room) throws DBException;

    Room getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Room room) throws DBException;

    List<Room> getAll() throws DBException;
}
