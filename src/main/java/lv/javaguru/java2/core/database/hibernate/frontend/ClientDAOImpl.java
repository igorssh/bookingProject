package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.ClientDAO;
import lv.javaguru.java2.core.domain.frontend.Client;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ClientDAOImpl implements ClientDAO{
    
    @Autowired
    SessionFactory sessionFactory;
            
    @Override
    public void create(Client client) throws DBException {
        sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public Client getById(long id) throws DBException {
        return (Client) sessionFactory.getCurrentSession().get(Client.class, id);
    }

    @Override
    public void delete(long id) throws DBException {
        sessionFactory.getCurrentSession().delete(getById(id));
    }

    @Override
    public void update(Client client) throws DBException {
        sessionFactory.getCurrentSession().update(client);
    }

    @Override
    public List<Client> getAll() throws DBException {
        return (List<Client>) sessionFactory.getCurrentSession().createCriteria(Client.class).list();
    }
}
