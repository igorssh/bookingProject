package lv.javaguru.java2.database.hibernate.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.CommentDAO;
import lv.javaguru.java2.domain.frontend.Comment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CommentDAOImpl implements CommentDAO{
    
    @Autowired
    SessionFactory sessionFactory;
            
    @Override
    public void create(Comment comment) throws DBException {
        sessionFactory.getCurrentSession().save(comment);
    }

    @Override
    public Comment getById(long id) throws DBException {
        return (Comment) sessionFactory.getCurrentSession().get(Comment.class, id);
    }

    @Override
    public void delete(long id) throws DBException {
        sessionFactory.getCurrentSession().delete(getById(id));
    }

    @Override
    public void update(Comment comment) throws DBException {
        sessionFactory.getCurrentSession().update(comment);
    }

    @Override
    public List<Comment> getAll() throws DBException {
        return (List<Comment>) sessionFactory.getCurrentSession().createCriteria(Comment.class).list();
    }
}
