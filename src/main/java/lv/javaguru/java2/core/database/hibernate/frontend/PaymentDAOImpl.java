package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.PaymentDAO;
import lv.javaguru.java2.core.domain.frontend.Payment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Component
//@Transactional
public class PaymentDAOImpl implements PaymentDAO{

    //@Autowired
    SessionFactory sessionFactory;
    
    @Override
    public void create(Payment payment) throws DBException {
        sessionFactory.getCurrentSession().save(payment);
    }

    @Override
    public Payment getById(Long id) throws DBException {
        return (Payment) sessionFactory.getCurrentSession().get(Payment.class, id);
    }

    @Override
    public void delete(Long id) throws DBException {
        sessionFactory.getCurrentSession().delete(getById(id));
    }

    @Override
    public void update(Payment payment) throws DBException {
        sessionFactory.getCurrentSession().update(payment);
    }

    @Override
    public List<Payment> getAll() throws DBException {
        return (List<Payment>) sessionFactory.getCurrentSession().createCriteria(Payment.class).list();
    }
}
