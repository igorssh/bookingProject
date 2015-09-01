package lv.javaguru.java2.core.database.jdbc.backend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.backend.PermissionDAO;
import lv.javaguru.java2.core.database.backend.RoleDAO;
import lv.javaguru.java2.core.database.jdbc.DAOImpl;
import lv.javaguru.java2.core.domain.backend.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class PermissionDAOImpl extends DAOImpl implements PermissionDAO {

    @Autowired
    RoleDAO roleDAO;

    public void create(Permission permission) throws DBException {
        if (permission == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO permissions VALUES (default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, permission.getLabel());
            preparedStatement.setString(2, permission.getDesc());
            preparedStatement.setLong(3, permission.getRoleId());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                permission.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute PermissionDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Permission getById(long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM permissions WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Permission permission = null;
            if (resultSet.next()) {
                permission = new Permission();
                permission.setId(resultSet.getLong("id"));
                permission.setLabel(resultSet.getString("label"));
                permission.setDesc(resultSet.getString("desc_text"));
                permission.setRole(roleDAO.getById(resultSet.getLong("role_id")));
            }
            return permission;
        } catch (Throwable e) {
            System.out.println("Exception while execute RoleDAOImpl.getByRoleName()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void delete(long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM permissions WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute PermissionDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(Permission permission) throws DBException {
        if (permission == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE permissions SET label = ?, desc_text = ?, role_id = ? " +
                            "WHERE id = ?");
            preparedStatement.setString(1, permission.getLabel());
            preparedStatement.setString(2, permission.getDesc());
            preparedStatement.setLong(3, permission.getRoleId());
            preparedStatement.setLong(4, permission.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute PermissionDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Permission> getAll() throws DBException {
        List<Permission> permissions = new ArrayList<Permission>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM permissions");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Permission permission = new Permission();
                permission.setId(resultSet.getLong("id"));
                permission.setLabel(resultSet.getString("label"));
                permission.setDesc(resultSet.getString("desc_text"));
                permission.setRole(roleDAO.getById(resultSet.getLong("role_id")));
                permissions.add(permission);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list PermissionDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return permissions;
    }
}
