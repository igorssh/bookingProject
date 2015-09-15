package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.domain.frontend.Reservation;
import lv.javaguru.java2.core.generators.generics.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Aleksej_home on 2015.09.15..
 */
@Repository("Reservation_DAO")
public class ReservationGenericDAOImpl extends GenericDaoImpl<Reservation, Long> {
    public ReservationGenericDAOImpl() {
        super(Reservation.class);
    }
}
