package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ApClassDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.ApClass;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.22
 */

public class ApClassDAOImpl extends DAOImpl implements ApClassDAO {

    public void create(ApClass apClass) throws DBException {
        if (apClass == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into apclasses values (default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setShort(1, apClass.getClassId());
            preparedStatement.setString(2, apClass.getDesc());
            preparedStatement.setInt(3, apClass.getNumId());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                apClass.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public ApClass getById(long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from apclasses where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ApClass ap = null;
            if (resultSet.next()) {
                ap = new ApClass();
                ap.setId(resultSet.getLong("id"));
                ap.setClassId(resultSet.getShort("classId"));
                ap.setDesc(resultSet.getString("desc_text"));
                ap.setNumId(resultSet.getInt("num_id"));
            }
            return ap;
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getById()");
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
                    .prepareStatement("delete from apclasses where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(ApClass ap) throws DBException {
        if (ap == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update apclasses set classId = ?, desc_text = ?, num_id = ? " +
                            "where id = ?");
            preparedStatement.setShort(1, ap.getClassId());
            preparedStatement.setString(2, ap.getDesc());
            preparedStatement.setInt(3, ap.getNumId());
            preparedStatement.setLong(4, ap.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<ApClass> getAll() throws DBException {
        List<ApClass> apClasses = new ArrayList<ApClass>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from apclasses");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ApClass apClass = new ApClass();
                apClass.setId(resultSet.getLong("id"));
                apClass.setClassId(resultSet.getShort("classId"));
                apClass.setDesc(resultSet.getString("desc_text"));
                apClass.setNumId(resultSet.getInt("num_id"));
                apClasses.add(apClass);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return apClasses;
    }
}
