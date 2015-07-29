package lv.javaguru.java2.database.backend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.backend.Role;

import java.util.List;

public interface RoleDAO {

    void create(Role role) throws DBException;

    Role getByRoleName(String roleName) throws DBException;

    Role getById(long id) throws DBException;

    void delete(long id) throws DBException;

    void update(Role role) throws DBException;

    List<Role> getAll() throws DBException;
}
