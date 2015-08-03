package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.HotelClassDAO;
import lv.javaguru.java2.database.frontend.HotelDAO;
import lv.javaguru.java2.database.frontend.RoomDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Room;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RoomDAOImpl extends DAOImpl implements RoomDAO {

    private HotelDAO hotelDAO = new HotelDAOImpl();
    private HotelClassDAO hotelClassDAO = new HotelClassDAOImpl();

    public void create(Room room) throws DBException {
        if (room == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into rooms values (default, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, room.getRoomNumber());
            preparedStatement.setInt(2, room.getPersonCount());
            preparedStatement.setDouble(3, room.getPricePerDay());
            preparedStatement.setString(4, room.getDescription());
            preparedStatement.setLong(5, room.getHotelClass().getId());
            preparedStatement.setLong(6, room.getHotel().getId());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                room.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute RoomDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Room getById(long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from rooms where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Room room = null;
            if (resultSet.next()) {
                room = new Room();
                room.setId(resultSet.getLong("id"));
                room.setRoomNumber(resultSet.getInt("room_number"));
                room.setPersonCount(resultSet.getInt("person_count"));
                room.setPricePerDay(resultSet.getDouble("price_per_day"));
                room.setDescription(resultSet.getString("description_text"));
                room.setHotelClass(hotelClassDAO.getById(resultSet.getLong("hotel_class_id")));
                room.setHotel(hotelDAO.getById(resultSet.getLong("hotel_id")));
            }
            return room;
        } catch (Throwable e) {
            System.out.println("Exception while execute RoomDAOImpl.getById()");
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
                    .prepareStatement("delete from rooms where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute RoomDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(Room room) throws DBException {
        if (room == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update rooms set room_number = ?, person_count = ?, price_per_day = ?, description_text = ?, hotel_class_id = ?, " +
                            "hotel_id = ? where id = ?");
            preparedStatement.setInt(1, room.getRoomNumber());
            preparedStatement.setInt(2, room.getPersonCount());
            preparedStatement.setDouble(3, room.getPricePerDay());
            preparedStatement.setString(4, room.getDescription());
            preparedStatement.setLong(5, room.getHotelClass().getId());
            preparedStatement.setLong(6, room.getHotel().getId());
            preparedStatement.setLong(7, room.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute RoomDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Room> getAll() throws DBException {

        List<Room> hotels = new ArrayList<Room>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from rooms");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Room room = new Room();
                room.setId(resultSet.getLong("id"));
                room.setRoomNumber(resultSet.getInt("room_number"));
                room.setPersonCount(resultSet.getInt("person_count"));
                room.setPricePerDay(resultSet.getDouble("price_per_day"));
                room.setDescription(resultSet.getString("description_text"));
                room.setHotelClass(hotelClassDAO.getById(resultSet.getLong("hotel_class_id")));
                room.setHotel(hotelDAO.getById(resultSet.getLong("hotel_id")));
                hotels.add(room);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list RoomDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return hotels;
    }


}
