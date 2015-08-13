package lv.javaguru.java2.database.hibernate.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.HotelDAO;
import lv.javaguru.java2.domain.frontend.Hotel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("HotelDAO")
public class HotelDAOImpl implements HotelDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    
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

    }

    @Override
    public List<Hotel> getAll() throws DBException {
        return null;
    }
}
