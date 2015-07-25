package lv.javaguru.java2.database.frontend;

/**
 * Created by Aleksej_home on 2015.07.25..
 */
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Reservation;

import java.util.List;

public interface ReservationDAO {

    void create(Reservation rez) throws DBException;

    Reservation getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Reservation rez) throws DBException;

    List<Reservation> getAll() throws DBException;

}
