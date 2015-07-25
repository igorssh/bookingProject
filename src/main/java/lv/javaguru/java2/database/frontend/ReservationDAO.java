package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Reservation;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21
 */

public interface ReservationDAO {
    void create(Reservation reservation) throws DBException;

    Reservation getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Reservation reservation) throws DBException;

    List<Reservation> getAll() throws DBException;
}
