package lv.javaguru.java2.core.database.hibernate.frontend;

/**
 * Created by Aleksej_home on 2015.08.31..
 */
import lv.javaguru.java2.core.Services.DBBehavior;
import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.ReservationDAO;
import lv.javaguru.java2.core.domain.frontend.Reservation;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ReservationDAOImpl implements ReservationDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    DBBehavior dbBehavior;
    

    @Override
    public Reservation getById(long id, String[] args) throws DBException {
        Reservation reservation = (Reservation) sessionFactory.getCurrentSession().get(Reservation.class, id);
        if (args != null)
        for (String str : args){
            Hibernate.initialize(dbBehavior.ignoreLazy(reservation, str));
        }
        return reservation;
    }

    @Override
    public void create(Reservation reservation) throws DBException {
        sessionFactory.getCurrentSession().save(reservation);
    }

    @Override
    public Reservation getById(long id) throws DBException {
        return (Reservation) sessionFactory.getCurrentSession().get(Reservation.class, id);
    }

    @Override
    public void delete(long id) throws DBException {
        sessionFactory.getCurrentSession().delete(getById(id));
    }

    @Override
    public void update(Reservation reservation) throws DBException {
        sessionFactory.getCurrentSession().update(reservation);
    }

    @Override
    public List<Reservation> getAll() throws DBException {
        return (List<Reservation>) sessionFactory.getCurrentSession().createCriteria(Reservation.class).list();
    }
}
