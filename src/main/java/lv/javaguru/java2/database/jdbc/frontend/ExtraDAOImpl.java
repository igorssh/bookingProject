package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ExtraDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Extra;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ExtraDAOImpl extends DAOImpl implements ExtraDAO {

    public void create(Extra extra) throws DBException {

        if (extra == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into extras values (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, extra.getLabel());
            preparedStatement.setString(2, extra.getDesc());
            preparedStatement.setDouble(3, extra.getCost());
            preparedStatement.setString(4, extra.getPic());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                extra.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Extra getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from extras where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Extra ext = null;
            if (resultSet.next()) {
                ext = new Extra();
                ext.setId(resultSet.getLong("id"));
                ext.setLabel(resultSet.getString("label"));
                ext.setDesc(resultSet.getString("desc_text"));
                ext.setCost(resultSet.getDouble("cost"));
                ext.setPic(resultSet.getString("pic"));

            }
            return ext;
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
                    .prepareStatement("delete from extras where id = ?");
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

    public void update(Extra extra) throws DBException {

        if (extra == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update extras set label = ?, desc_text = ?, cost = ?, pic = ?  " +
                            "where id = ?");
            preparedStatement.setString(1, extra.getLabel());
            preparedStatement.setString(2, extra.getDesc());
            preparedStatement.setDouble(3, extra.getCost());
            preparedStatement.setString(4, extra.getPic());
            preparedStatement.setLong(5, extra.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Extra> getAll() throws DBException {
        List<Extra> aps = new ArrayList<Extra>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from extras");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Extra extra = new Extra();
                extra.setId(resultSet.getLong("id"));
                extra.setLabel(resultSet.getString("label"));
                extra.setDesc(resultSet.getString("desc_text"));
                extra.setCost(resultSet.getDouble("cost"));
                extra.setPic(resultSet.getString("pic"));
                aps.add(extra);
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


    public Extra getFirst() throws DBException{
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from extras order by id limit 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            Extra ext = null;
            if (resultSet.next()) {
                ext = new Extra();
                ext.setId(resultSet.getLong("id"));
                ext.setLabel(resultSet.getString("label"));
                ext.setDesc(resultSet.getString("desc_text"));
                ext.setCost(resultSet.getDouble("cost"));
                ext.setPic(resultSet.getString("pic"));

            }
            return ext;
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Extra> getAllThinExtras() throws DBException {
        List<Extra> aps = new ArrayList<Extra>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select id,label from extras");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Extra extra = new Extra();
                extra.setId(resultSet.getLong("id"));
                extra.setLabel(resultSet.getString("label"));

                aps.add(extra);
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
