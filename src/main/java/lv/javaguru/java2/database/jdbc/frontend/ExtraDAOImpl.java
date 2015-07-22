package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ExrtraDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Extra;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Aleksej_home on 2015.07.22..
 */
public class ExtraDAOImpl extends DAOImpl implements ExrtraDAO{

    public void create(Extra ext) throws DBException {

        if (ext == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into extras values (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, ext.getLabel());
            preparedStatement.setString(2, ext.getDesc());
            preparedStatement.setDouble(3, ext.getCost());
            preparedStatement.setString(4, ext.getPic());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                //  ap.setUserId(rs.getLong(1));
                ext.setId(rs.getLong(1));
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

    public void update(Extra ext) throws DBException {

        if (ext == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update extras set label = ?, desc_text = ?, cost = ?, pic = ?  " +
                            "where id = ?");
            preparedStatement.setString(1, ext.getLabel());
            preparedStatement.setString(2, ext.getDesc());
            preparedStatement.setDouble(3, ext.getCost());
            preparedStatement.setString(4, ext.getPic());
            preparedStatement.setLong(5, ext.getId());
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
                Extra ext = new Extra();
                ext.setId(resultSet.getLong("id"));
                ext.setLabel(resultSet.getString("label"));
                ext.setDesc(resultSet.getString("desc_text"));
                ext.setCost(resultSet.getDouble("cost"));
                ext.setPic(resultSet.getString("pic"));
                aps.add(ext);
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
