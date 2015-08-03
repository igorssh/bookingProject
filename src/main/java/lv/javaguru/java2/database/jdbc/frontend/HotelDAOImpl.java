package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.HotelDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotelDAOImpl extends DAOImpl implements HotelDAO {

    public void create(Hotel hotel) throws DBException {
        if (hotel == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into hotels values (default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, hotel.getLabel());
            preparedStatement.setString(2, hotel.getAddress());
            preparedStatement.setString(3, hotel.getDescription());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                hotel.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public Hotel getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from hotels where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Hotel hotel = null;
            if (resultSet.next()) {
                hotel = new Hotel();
                hotel.setId(resultSet.getLong("id"));
                hotel.setLabel(resultSet.getString("label"));
                hotel.setAddress(resultSet.getString("address"));
                hotel.setDescription(resultSet.getString("desc_text"));
            }
            return hotel;
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
                    .prepareStatement("delete from hotels where id = ?");
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

    public void update(Hotel hotel) throws DBException {
        if (hotel == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update hotels set label = ?, address = ?, desc_text = ? " +
                            "where id = ?");
            preparedStatement.setString(1, hotel.getLabel());
            preparedStatement.setString(2, hotel.getAddress());
            preparedStatement.setString(3, hotel.getDescription());
            preparedStatement.setLong(4, hotel.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Hotel> getAll() throws DBException {
        List<Hotel> hotels = new ArrayList<Hotel>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from hotels");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(resultSet.getLong("id"));
                hotel.setLabel(resultSet.getString("label"));
                hotel.setAddress(resultSet.getString("address"));
                hotel.setDescription(resultSet.getString("desc_text"));
                hotels.add(hotel);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return hotels;
    }


}
