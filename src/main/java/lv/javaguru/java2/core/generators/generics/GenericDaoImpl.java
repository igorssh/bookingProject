package lv.javaguru.java2.core.generators.generics;

import lv.javaguru.java2.core.database.DBException;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.09.14..
 */


@Transactional
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    @Autowired
    SessionFactory sessionFactory;

    protected Class<T> typeParameterClass;

    @Override
    public void create(T t) throws DBException {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public T getById(PK id) throws DBException {
        return (T) sessionFactory.getCurrentSession().get(typeParameterClass, id);
    }

    @Override
    public void update(T t) throws DBException {
        sessionFactory.getCurrentSession().update(t);
    }

    @Override
    public void delete(PK id) throws DBException {
        sessionFactory.getCurrentSession().delete(getById(id));
    }

    @Override
    public List<T> getAll() throws DBException {
        return (List<T>) sessionFactory.getCurrentSession().createCriteria(typeParameterClass)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }

    public GenericDaoImpl(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }


}
