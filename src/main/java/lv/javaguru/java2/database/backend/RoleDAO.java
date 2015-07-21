package lv.javaguru.java2.database.backend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.backend.Role;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21..
 */
public interface RoleDAO {

    void create(Role role) throws DBException;

    Role getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Role role) throws DBException;

    List<Role> getAll() throws DBException;
}
