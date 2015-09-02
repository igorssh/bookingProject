package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.Services.DBBehavior;
import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.ThumbDAO;
import lv.javaguru.java2.core.domain.frontend.Thumb;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.08.30..
 */
@Component
@Transactional
public class ThumbDAOImpl implements ThumbDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    DBBehavior dbBehavior;

    @Override
    public Thumb getById(long id, String[] args) throws DBException {
        Thumb thumb = (Thumb) sessionFactory.getCurrentSession().get(Thumb.class, id);
                dbBehavior.ignoreLazy(thumb, args);
        return thumb;
    }

    @Override
    public void create(Thumb th) throws DBException {
        sessionFactory.getCurrentSession().save(th);
    }

    @Override
    public Thumb getById(long id) throws DBException {
        return (Thumb) sessionFactory.getCurrentSession().get(Thumb.class, id);
    }

    @Override
    public void delete(long id) throws DBException {
        sessionFactory.getCurrentSession().delete(getById(id));
    }

    @Override
    public void update(Thumb th) throws DBException {
        sessionFactory.getCurrentSession().update(th);
    }

    @Override
    public List<Thumb> getAll() throws DBException {
        return (List<Thumb>) sessionFactory.getCurrentSession().createCriteria(Thumb.class).list();
    }
}
