package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.SearchDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Hotel;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class SearchDAOImpl extends DAOImpl implements SearchDAO {

    @Override
    public List<Hotel> searchHotel(String searchSpec) throws DBException {
        List<Hotel> hotels = null;

        try {
            hotels = this.searchHotelByAddress(searchSpec);
            if (hotels.size() == 0) {
                hotels = this.searchHotelByDesc(searchSpec);
            }

            return hotels;
        } catch (Throwable e) {
            System.out.println("Exception while execute SearchDAOImpl.searchHotel()");
            e.printStackTrace();
            throw new DBException(e);
        }
    }

    @Override
    public List<Hotel> searchHotelByAddress(String searchSpec) throws DBException {
        List<Hotel> hotels = new ArrayList<Hotel>();
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from hotels where address like ?");
            preparedStatement.setString(1, "%" + searchSpec + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(resultSet.getLong("id"));
                hotel.setLabel(resultSet.getString("label"));
                hotel.setAddress(resultSet.getString("address"));
                hotel.setDescription(resultSet.getString("desc_text"));
                hotels.add(hotel);
            }
            return hotels;
        } catch (Throwable e) {
            System.out.println("Exception while execute SearchDAOImpl.searchHotelByAddress()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Hotel> searchHotelByDesc(String searchSpec) throws DBException {
        List<Hotel> hotels = new ArrayList<Hotel>();
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from hotels where desc_text like ?");
            preparedStatement.setString(1, "%" + searchSpec + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(resultSet.getLong("id"));
                hotel.setLabel(resultSet.getString("label"));
                hotel.setAddress(resultSet.getString("address"));
                hotel.setDescription(resultSet.getString("desc_text"));
                hotels.add(hotel);
            }
            return hotels;
        } catch (Throwable e) {
            System.out.println("Exception while execute SearchDAOImpl.searchHotelByDesc()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }


}
