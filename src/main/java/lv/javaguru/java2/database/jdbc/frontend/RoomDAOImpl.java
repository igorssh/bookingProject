package lv.javaguru.java2.database.jdbc.frontend;



import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.RoomDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Room;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * Created by Aleksej_home on 2015.07.22..
 */
public class RoomDAOImpl extends DAOImpl implements RoomDAO{
    public void create(Room room) throws DBException {
        if (room == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into rooms values (default, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, room.getNum());
            preparedStatement.setInt(2, room.getPcount());
            preparedStatement.setDouble(3, room.getPrice_per_day());
            preparedStatement.setString(4, room.getDesc());
            preparedStatement.setDate(5, room.getTexn_repo());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                //  ap.setUserId(rs.getLong(1));
                room.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Room getById(Long id) throws DBException {
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
                room.setNum(resultSet.getInt("num"));
                room.setPcount(resultSet.getInt("p_count"));
                room.setPrice_per_day(resultSet.getDouble("price_per_day"));
                room.setDesc(resultSet.getString("desc_text"));
                room.setTexn_repo(resultSet.getDate("texn_repo"));

            }
            return room;
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
                    .prepareStatement("delete from rooms where id = ?");
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

    public void update(Room room) throws DBException {
        if (room == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update rooms set num = ?, p_count = ?, price_per_day = ?, desc_text = ?, texn_repo = ? " +
                            "where id = ?");
            preparedStatement.setInt(1, room.getNum());
            preparedStatement.setInt(2, room.getPcount());
            preparedStatement.setDouble(3, room.getPrice_per_day());
            preparedStatement.setString(4, room.getDesc());
            preparedStatement.setDate(5, room.getTexn_repo());

            preparedStatement.setLong(6, room.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Room> getAll() throws DBException {
        List<Room> aps = new ArrayList<Room>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from apartaments");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Room room = new Room();
                room.setId(resultSet.getLong("id"));
                room.setNum(resultSet.getInt("num"));
                room.setPcount(resultSet.getInt("p_count"));
                room.setPrice_per_day(resultSet.getDouble("price_per_day"));
                room.setDesc(resultSet.getString("desc_text"));
                room.setTexn_repo(resultSet.getDate("texn_repo"));
                aps.add(room);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return aps;
    }



}
