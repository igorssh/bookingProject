package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.HotelClassDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.HotelClass;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotelClassDAOImpl extends DAOImpl implements HotelClassDAO {

    public void create(HotelClass hotelClass) throws DBException {
        if (hotelClass == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into hotelclasses values (default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, hotelClass.getClassId());
            preparedStatement.setString(2, hotelClass.getDesc());
            preparedStatement.setInt(3, hotelClass.getNumId());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                hotelClass.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public HotelClass getById(long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from hotelclasses where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            HotelClass ap = null;
            if (resultSet.next()) {
                ap = new HotelClass();
                ap.setId(resultSet.getLong("id"));
                ap.setClassId(resultSet.getInt("classRating"));
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
                    .prepareStatement("delete from hotelclasses where id = ?");
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

    public void update(HotelClass ap) throws DBException {
        if (ap == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update hotelclasses set classRating = ?, desc_text = ?, num_id = ? " +
                            "where id = ?");
            preparedStatement.setInt(1, ap.getClassId());
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

    public List<HotelClass> getAll() throws DBException {
        List<HotelClass> hotelClasses = new ArrayList<HotelClass>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from hotelclasses");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HotelClass hotelClass = new HotelClass();
                hotelClass.setId(resultSet.getLong("id"));
                hotelClass.setClassId(resultSet.getInt("classRating"));
                hotelClass.setDesc(resultSet.getString("desc_text"));
                hotelClass.setNumId(resultSet.getInt("num_id"));
                hotelClasses.add(hotelClass);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return hotelClasses;
    }
}
