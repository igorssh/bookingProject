package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.RoomDAO;
import lv.javaguru.java2.database.frontend.ThumbDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Thumb;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ThumbDAOImpl extends DAOImpl implements ThumbDAO {

    private RoomDAO roomDAO = new RoomDAOImpl();

    public void create(Thumb thumb) throws DBException {
        if (thumb == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into thumbs values (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, thumb.getLabel());
            preparedStatement.setString(2, thumb.getDesc());
            preparedStatement.setString(3, thumb.getOrig());
            preparedStatement.setLong(4, thumb.getRoom().getId());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                thumb.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Thumb getById(long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from thumbs where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Thumb thumb = null;
            if (resultSet.next()) {
                thumb = new Thumb();
                thumb.setId(resultSet.getLong("id"));
                thumb.setLabel(resultSet.getString("label"));
                thumb.setDesc(resultSet.getString("desc_text"));
                thumb.setOrig(resultSet.getString("orig"));
                thumb.setRoom(roomDAO.getById(resultSet.getLong("room_id")));
            }
            return thumb;
        } catch (Throwable e) {
            System.out.println("Exception while execute ThumbDAOImpl.getById()");
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
                    .prepareStatement("delete from thumbs where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute ThumbDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(Thumb thumb) throws DBException {
        if (thumb == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update thumbs set label = ?, desc_text = ?, orig = ? " +
                            "where id = ?");

            preparedStatement.setString(1, thumb.getLabel());
            preparedStatement.setString(2, thumb.getDesc());
            preparedStatement.setString(3, thumb.getOrig());
            preparedStatement.setLong(4, thumb.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute ThumbDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Thumb> getAll() throws DBException {

        List<Thumb> thumbs = new ArrayList<Thumb>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from thumbs");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Thumb thumb = new Thumb();
                thumb.setId(resultSet.getLong("id"));
                thumb.setLabel(resultSet.getString("label"));
                thumb.setDesc(resultSet.getString("desc_text"));
                thumb.setOrig(resultSet.getString("orig"));
                thumbs.add(thumb);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list ThumbDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return thumbs;
    }


}
