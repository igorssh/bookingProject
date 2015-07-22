package lv.javaguru.java2.database.jdbc.frontend;


import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.RezervationDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Rezervation;

import java.util.List;
//import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * Created by Aleksej_home on 2015.07.22..
 */
public class RezervationDAOImpl extends DAOImpl implements RezervationDAO {
    public void create(Rezervation rez) throws DBException {
        if (rez == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into rezervations values (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, rez.getFrom());
            preparedStatement.setDate(2, rez.getTo());
            preparedStatement.setInt(3, rez.getP_count());
            preparedStatement.setBoolean(4, rez.isStatus());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                //  ap.setUserId(rs.getLong(1));
                rez.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Rezervation getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from rezervations where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Rezervation rez = null;
            if (resultSet.next()) {
                rez = new Rezervation();
                rez.setId(resultSet.getLong("id"));
                rez.setFrom(resultSet.getDate("from_date"));
                rez.setTo(resultSet.getDate("to_date"));
                rez.setP_count(resultSet.getInt("p_count"));
                rez.setTimestamp(resultSet.getDate("time_stamp"));
                rez.setStatus(resultSet.getBoolean("status"));

            }
            return rez;
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
                    .prepareStatement("delete from rezervations where id = ?");
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

    public void update(Rezervation rez) throws DBException {
        if (rez == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update rezervations set from_date = ?, to_date = ?, p_count = ?, status = ? " +
                            "where id = ?");

            preparedStatement.setDate(1, rez.getFrom());
            preparedStatement.setDate(2, rez.getTo());
            preparedStatement.setInt(3, rez.getP_count());
            preparedStatement.setBoolean(4, rez.isStatus());
            preparedStatement.setLong(5, rez.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Rezervation> getAll() throws DBException {
        List<Rezervation> aps = new ArrayList<Rezervation>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from rezervations");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Rezervation rez = new Rezervation();
                rez.setId(resultSet.getLong("id"));
                rez.setFrom(resultSet.getDate("from_date"));
                rez.setTo(resultSet.getDate("to_date"));
                rez.setP_count(resultSet.getInt("p_count"));
                rez.setTimestamp(resultSet.getDate("time_stamp"));
                rez.setStatus(resultSet.getBoolean("status"));

                aps.add(rez);
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
