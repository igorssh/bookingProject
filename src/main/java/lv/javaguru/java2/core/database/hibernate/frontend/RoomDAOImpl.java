package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.Services.DBBehavior;
import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.RoomDAO;
import lv.javaguru.java2.core.domain.frontend.Room;
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
public class RoomDAOImpl implements RoomDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    DBBehavior dbBehavior;


    @Override
    public Room getById(long id, String[] args) throws DBException {
        Room room = (Room)sessionFactory.getCurrentSession().get(Room.class, id);
                dbBehavior.ignoreLazy(room, args);
        return room;
    }

    @Override
    public void create(Room room) throws DBException {
        sessionFactory.getCurrentSession().save(room);
    }

    @Override
    public Room getById(long id) throws DBException {
        return (Room)sessionFactory.getCurrentSession().get(Room.class, id);
    }

    @Override
    public void delete(long id) throws DBException {
        sessionFactory.getCurrentSession().delete(getById(id));
    }

    @Override
    public void update(Room room) throws DBException {
        sessionFactory.getCurrentSession().update(room);
    }

    @Override
    public List<Room> getAll() throws DBException {
        return (List<Room>) sessionFactory.getCurrentSession().createCriteria(Room.class).list();
    }
}
