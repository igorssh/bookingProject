package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ApartmentDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Apartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21
 */

public class ApartmentDAOImpl extends DAOImpl implements ApartmentDAO {

    public void create(Apartment ap) throws DBException {
        if (ap == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into apartments values (default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, ap.getLabel());
            preparedStatement.setString(2, ap.getAddress());
            preparedStatement.setString(3, ap.getDesc());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
              //  ap.setUserId(rs.getLong(1));
                ap.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public Apartment getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from apartments where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Apartment ap = null;
            if (resultSet.next()) {
                ap = new Apartment();
                ap.setId(resultSet.getLong("id"));
                ap.setLabel(resultSet.getString("label"));
                ap.setAddress(resultSet.getString("address"));
                ap.setDesc(resultSet.getString("desc_text"));
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

    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from apartments where id = ?");
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

    public void update(Apartment ap) throws DBException {
        if (ap == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update apartments set label = ?, address = ?, desc_text = ? " +
                            "where id = ?");
            preparedStatement.setString(1, ap.getLabel());
            preparedStatement.setString(2, ap.getAddress());
            preparedStatement.setString(3, ap.getDesc());
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

    public List<Apartment> getAll() throws DBException {
        List<Apartment> apartments = new ArrayList<Apartment>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from apartments");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Apartment ap = new Apartment();
                ap.setId(resultSet.getLong("id"));
                ap.setLabel(resultSet.getString("label"));
                ap.setAddress(resultSet.getString("address"));
                ap.setDesc(resultSet.getString("desc_text"));
                apartments.add(ap);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return apartments;
    }


}
