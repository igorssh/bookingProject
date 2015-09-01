package lv.javaguru.java2.database.hibernate.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.HotelClassDAO;
import lv.javaguru.java2.domain.frontend.HotelClass;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class HotelClassDAOImpl implements HotelClassDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void create(HotelClass hotelClass) throws DBException {
        sessionFactory.getCurrentSession().save(hotelClass);
    }

    @Override
    public HotelClass getById(long id) throws DBException {
        return (HotelClass) sessionFactory.getCurrentSession().get(HotelClass.class, id);
    }

    @Override
    public void delete(long id) throws DBException {
        sessionFactory.getCurrentSession().delete(getById(id));
    }

    @Override
    public void update(HotelClass hotelClass) throws DBException {
        sessionFactory.getCurrentSession().update(hotelClass);
    }

    @Override
    public List<HotelClass> getAll() throws DBException {
        return (List<HotelClass>) sessionFactory.getCurrentSession().createCriteria(HotelClass.class).list();
    }
}
