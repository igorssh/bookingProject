package lv.javaguru.java2.database.jdbc.frontend;


import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.PaimentDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Paiment;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * Created by Aleksej_home on 2015.07.22..
 */
public class PaimentDAOImpl extends DAOImpl implements PaimentDAO {
    public void create(Paiment pa) throws DBException {
        if (pa == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into paiments values (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setDouble(1, pa.getMoney());
            preparedStatement.setString(2, pa.getDesc());
            preparedStatement.setShort(3, pa.getPay_type());
            preparedStatement.setString(4, pa.getReferent());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                //  ap.setUserId(rs.getLong(1));
                pa.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Paiment getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from paiments where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Paiment pa = null;
            if (resultSet.next()) {
                pa = new Paiment();
                pa.setId(resultSet.getLong("id"));
                pa.setMoney(resultSet.getDouble("money"));
                pa.setDesc(resultSet.getString("desc_text"));
                pa.setPay_type(resultSet.getShort("pay_type"));
                pa.setTimestamp(resultSet.getDate("time_stamp"));
                pa.setReferent(resultSet.getString("referent"));
            }
            return pa;
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
                    .prepareStatement("delete from paiments where id = ?");
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

    public void update(Paiment pa) throws DBException {
        if (pa == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update paiments set money = ?, desc_text = ?, pay_type = ?, referent = ? " +
                            "where id = ?");
            preparedStatement.setDouble(1, pa.getMoney());
            preparedStatement.setString(2, pa.getDesc());
            preparedStatement.setShort(3, pa.getPay_type());
            preparedStatement.setString(4, pa.getReferent());
            preparedStatement.setLong(5, pa.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Paiment> getAll() throws DBException {
        List<Paiment> aps = new ArrayList<Paiment>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from apartaments");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Paiment pa = new Paiment();
                pa.setId(resultSet.getLong("id"));
                pa.setMoney(resultSet.getDouble("money"));
                pa.setDesc(resultSet.getString("desc_text"));
                pa.setPay_type(resultSet.getShort("pay_type"));
                pa.setTimestamp(resultSet.getDate("time_stamp"));
                pa.setReferent(resultSet.getString("referent"));
                aps.add(pa);
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
