package lv.javaguru.java2.core.database.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.domain.frontend.Reservation;

import java.util.List;

public interface ReservationDAO {

    void create(Reservation reservation) throws DBException;

    Reservation getById(long id) throws DBException;

    void delete(long id) throws DBException;

    void update(Reservation reservation) throws DBException;

    List<Reservation> getAll() throws DBException;
}
