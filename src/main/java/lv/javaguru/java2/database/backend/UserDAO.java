package lv.javaguru.java2.database.backend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.backend.User;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21..
 */
public interface UserDAO {

    void create(User user) throws DBException;

    User getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(User user) throws DBException;

    List<User> getAll() throws DBException;
}
