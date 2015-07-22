package lv.javaguru.java2.database.jdbc.frontend;


import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.KlientDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Klient;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * Created by Aleksej_home on 2015.07.22..
 */
public class KlientDAOImpl extends DAOImpl implements KlientDAO{
    public void create(Klient kli) throws DBException {
        if (kli == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into klients values (default, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, kli.getName());
            preparedStatement.setString(2, kli.getSurname());
            preparedStatement.setString(3, kli.getEmail());
            preparedStatement.setString(4, kli.getTele());
            preparedStatement.setString(5, kli.getReg_num());
            preparedStatement.setString(6, kli.getPers_num());
            preparedStatement.setString(7, kli.getCorp());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                //  ap.setUserId(rs.getLong(1));
                kli.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public Klient getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from klients where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Klient kli = null;
            if (resultSet.next()) {
                kli = new Klient();
                kli.setId(resultSet.getLong("id"));
                kli.setName(resultSet.getString("name"));
                kli.setSurname(resultSet.getString("surname"));
                kli.setEmail(resultSet.getString("email"));
                kli.setTele(resultSet.getString("tele"));
                kli.setReg_num(resultSet.getString("reg_num"));
                kli.setPers_num(resultSet.getString("pers_num"));
                kli.setCorp(resultSet.getString("corp"));
            }
            return kli;
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
                    .prepareStatement("delete from klients where id = ?");
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

    public void update(Klient kli) throws DBException {
        if (kli == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update klients set name = ?, surname = ?, email = ? " +
                            ", tele = ?, reg_num = ?, pers_num = ?, corp = ?" +
                            "where id = ?");
            preparedStatement.setString(1, kli.getName());
            preparedStatement.setString(2, kli.getSurname());
            preparedStatement.setString(3, kli.getEmail());
            preparedStatement.setString(4, kli.getTele());
            preparedStatement.setString(5, kli.getReg_num());
            preparedStatement.setString(6, kli.getPers_num());
            preparedStatement.setString(7, kli.getCorp());
            preparedStatement.setLong(8, kli.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Klient> getAll() throws DBException {
        List<Klient> aps = new ArrayList<Klient>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from klients");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Klient kli = new Klient();
                kli.setId(resultSet.getLong("id"));
                kli.setName(resultSet.getString("name"));
                kli.setSurname(resultSet.getString("surname"));
                kli.setEmail(resultSet.getString("email"));
                kli.setTele(resultSet.getString("tele"));
                kli.setReg_num(resultSet.getString("reg_num"));
                kli.setPers_num(resultSet.getString("pers_num"));
                kli.setCorp(resultSet.getString("corp"));
                aps.add(kli);
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
