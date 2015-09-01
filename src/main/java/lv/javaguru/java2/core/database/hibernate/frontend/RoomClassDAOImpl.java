package lv.javaguru.java2.core.database.hibernate.frontend;

/**
 * Created by Aleksej_home on 2015.08.30..
 */
import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.RoomClassDAO;
import lv.javaguru.java2.core.domain.frontend.RoomClass;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class RoomClassDAOImpl implements RoomClassDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void create(RoomClass ap) throws DBException {
        sessionFactory.getCurrentSession().save(ap);
    }

    @Override
    public RoomClass getById(long id) throws DBException {
        return (RoomClass) sessionFactory.getCurrentSession().get(RoomClass.class, id);
    }

    @Override
    public void delete(long id) throws DBException {
        sessionFactory.getCurrentSession().delete(getById(id));
    }

    @Override
    public void update(RoomClass ap) throws DBException {
        sessionFactory.getCurrentSession().update(ap);
    }

    @Override
    public List<RoomClass> getAll() throws DBException {
        return (List<RoomClass>) sessionFactory.getCurrentSession().createCriteria(RoomClass.class).list();
    }
}
