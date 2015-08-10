package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Reservation;

import java.util.List;

public interface ReservationDAO {
    void create(Reservation reservation) throws DBException;

    Reservation getById(long id) throws DBException;

    void delete(long id) throws DBException;

    void update(Reservation reservation) throws DBException;

    List<Reservation> getAll() throws DBException;
}
