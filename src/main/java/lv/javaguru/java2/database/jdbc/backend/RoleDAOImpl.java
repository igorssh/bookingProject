package lv.javaguru.java2.database.jdbc.backend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.backend.RoleDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.backend.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDAOImpl extends DAOImpl implements RoleDAO {
    public void create(Role role) throws DBException {
        if (role == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into roles values (default, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, role.getLabel());
            preparedStatement.setString(2, role.getDesc());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                role.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute RoleDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Role getByRoleName(String roleName) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from roles where label = ?");
            preparedStatement.setString(1, roleName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Role role = null;
            if (resultSet.next()) {
                role = new Role();
                role.setId(resultSet.getLong("id"));
                role.setLabel(resultSet.getString("label"));
                role.setDesc(resultSet.getString("desc_text"));
            }
            return role;
        } catch (Throwable e) {
            System.out.println("Exception while execute RoleDAOImpl.getByRoleName()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Role getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from roles where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Role role = null;
            if (resultSet.next()) {
                role = new Role();
                role.setId(resultSet.getLong("id"));
                role.setLabel(resultSet.getString("label"));
                role.setDesc(resultSet.getString("desc_text"));
            }
            return role;
        } catch (Throwable e) {
            System.out.println("Exception while execute RoleDAOImpl.getByRoleName()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from roles where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute RoleDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(Role role) throws DBException {
        if (role == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update roles set label = ?, desc_text = ? " +
                            "where id = ?");
            preparedStatement.setString(1, role.getLabel());
            preparedStatement.setString(2, role.getDesc());
            preparedStatement.setLong(3, role.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute RoleDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Role> getAll() throws DBException {
        List<Role> roles = new ArrayList<Role>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from roles");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getLong("id"));
                role.setLabel(resultSet.getString("label"));
                role.setDesc(resultSet.getString("desc_text"));
                roles.add(role);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list RoleDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return roles;
    }
}
