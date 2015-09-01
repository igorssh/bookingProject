package lv.javaguru.java2.core.database.jdbc.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.RoomClassDAO;
import lv.javaguru.java2.core.database.jdbc.DAOImpl;
import lv.javaguru.java2.core.domain.frontend.RoomClass;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

//@Component
public class RoomClassDAOImpl extends DAOImpl implements RoomClassDAO {

    public void create(RoomClass roomClass) throws DBException {
     /*   if (roomClass == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into hotelclasses values (default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, roomClass.getClassId());
            preparedStatement.setString(2, roomClass.getDesc());
            preparedStatement.setInt(3, roomClass.getClassName());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                roomClass.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }*/

    }

    public RoomClass getById(long id) throws DBException {
      /*  Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from hotelclasses where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            RoomClass ap = null;
            if (resultSet.next()) {
                ap = new RoomClass();
                ap.setId(resultSet.getLong("id"));
                ap.setClassId(resultSet.getInt("classRating"));
                ap.setDesc(resultSet.getString("desc_text"));
                ap.setClassName(resultSet.getInt("num_id"));
            }
            return ap;
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }*/
        return null;
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

    public void update(RoomClass ap) throws DBException {
       /* if (ap == null) {
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
            preparedStatement.setInt(3, ap.getClassName());
            preparedStatement.setLong(4, ap.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }*/
    }

    public List<RoomClass> getAll() throws DBException {
      /*  List<RoomClass> roomClasses = new ArrayList<RoomClass>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from hotelclasses");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RoomClass roomClass = new RoomClass();
                roomClass.setId(resultSet.getLong("id"));
                roomClass.setClassId(resultSet.getInt("classRating"));
                roomClass.setDesc(resultSet.getString("desc_text"));
                roomClass.setClassName(resultSet.getInt("num_id"));
                roomClasses.add(roomClass);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return roomClasses;*/
        return null;
    }
}
