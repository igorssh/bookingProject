package lv.javaguru.java2.database.backend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.backend.User;

import java.util.List;

public interface UserDAO {

    void create(User user) throws DBException;

    User getById(long id) throws DBException;

    void delete(long id) throws DBException;

    void update(User user) throws DBException;

    List<User> getAll() throws DBException;

    User getUserByLogin(String login) throws DBException;
}
