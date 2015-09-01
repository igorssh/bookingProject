package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.Services.DBBehavior;
import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.HotelDAO;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class HotelDAOImpl implements HotelDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    DBBehavior dbBehavior;

    @Override
    public Hotel getById(Long id, String[] args) throws DBException {
        Hotel hotel = (Hotel) sessionFactory.getCurrentSession().get(Hotel.class, id);
        if (args != null)
            for (String str : args){
                Hibernate.initialize(dbBehavior.ignoreLazy(hotel, str));
            }
        return hotel;
    }

    @Override
    public void create(Hotel hotel) throws DBException {
        sessionFactory.getCurrentSession().save(hotel);    
    }

    @Override
    public Hotel getById(Long id) throws DBException {
        return (Hotel) sessionFactory.getCurrentSession().get(Hotel.class, id);
    }

    @Override
    public void delete(Long id) throws DBException {
        sessionFactory.getCurrentSession().delete(getById(id));
    }

    @Override
    public void update(Hotel hotel) throws DBException {
        sessionFactory.getCurrentSession().update(hotel);
    }

    @Override
    public List<Hotel> getAll() throws DBException {
        return (List<Hotel>) sessionFactory.getCurrentSession().createCriteria(Hotel.class).list();
    }
}