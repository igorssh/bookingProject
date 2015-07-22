package lv.javaguru.java2.database.jdbc.frontend;


import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ThumbDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Thumb;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * Created by Aleksej_home on 2015.07.22..
 */
public class ThumbDAOImpl extends DAOImpl implements ThumbDAO{
    public void create(Thumb th) throws DBException {
        if (th == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into thumbs values (default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, th.getLabel());
            preparedStatement.setString(2, th.getDesc());
            preparedStatement.setString(3, th.getOrig());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                //  ap.setUserId(rs.getLong(1));
                th.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Thumb getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from thumbs where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Thumb th = null;
            if (resultSet.next()) {
                th = new Thumb();
                th.setId(resultSet.getLong("id"));
                th.setLabel(resultSet.getString("label"));
                th.setDesc(resultSet.getString("desc_text"));
                th.setOrig(resultSet.getString("orig"));
            }
            return th;
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
                    .prepareStatement("delete from thumbs where id = ?");
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

    public void update(Thumb th) throws DBException {
        if (th == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update thumbs set label = ?, desc_text = ?, orig = ? " +
                            "where id = ?");

            preparedStatement.setString(1, th.getLabel());
            preparedStatement.setString(2, th.getDesc());
            preparedStatement.setString(3, th.getOrig());
            preparedStatement.setLong(4, th.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Thumb> getAll() throws DBException {
        List<Thumb> aps = new ArrayList<Thumb>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from thumbs");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Thumb th = new Thumb();
                th.setId(resultSet.getLong("id"));
                th.setLabel(resultSet.getString("label"));
                th.setDesc(resultSet.getString("desc_text"));
                th.setOrig(resultSet.getString("orig"));
                aps.add(th);
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
