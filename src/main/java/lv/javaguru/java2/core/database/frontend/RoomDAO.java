package lv.javaguru.java2.core.database.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.domain.frontend.Room;

import java.util.List;

public interface RoomDAO {
    void create(Room room) throws DBException;

    Room getById(long id) throws DBException;

    Room getById(long id, String[] args) throws DBException;

    void delete(long id) throws DBException;

    void update(Room room) throws DBException;

    List<Room> getAll() throws DBException;
}
