package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Room;

import java.util.List;

public interface RoomDAO {
    void create(Room room) throws DBException;

    Room getById(long id) throws DBException;

    void delete(long id) throws DBException;

    void update(Room room) throws DBException;

    List<Room> getAll() throws DBException;
}
