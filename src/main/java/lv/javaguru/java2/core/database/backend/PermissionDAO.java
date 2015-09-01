package lv.javaguru.java2.core.database.backend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.domain.backend.Permission;

import java.util.List;

public interface PermissionDAO {

    void create(Permission permission) throws DBException;

    Permission getById(long id) throws DBException;

    void delete(long id) throws DBException;

    void update(Permission permission) throws DBException;

    List<Permission> getAll() throws DBException;
}
