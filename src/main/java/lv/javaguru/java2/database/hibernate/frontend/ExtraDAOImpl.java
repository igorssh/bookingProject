package lv.javaguru.java2.database.hibernate.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ExtraDAO;
import lv.javaguru.java2.domain.frontend.Extra;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExtraDAOImpl implements ExtraDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void create(Extra extra) throws DBException {
        sessionFactory.getCurrentSession().save(extra);
    }

    @Override
    public Extra getById(Long id) throws DBException {
        return (Extra) sessionFactory.getCurrentSession().get(Extra.class, id);
    }

    @Override
    public void delete(Long id) throws DBException {
        sessionFactory.getCurrentSession().delete(getById(id));
    }

    @Override
    public void update(Extra extra) throws DBException {
        sessionFactory.getCurrentSession().update(extra);
    }

    @Override
    public List<Extra> getAll() throws DBException {
        return (List<Extra>) sessionFactory.getCurrentSession().createCriteria(Extra.class).list();
    }
}
