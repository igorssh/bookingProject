package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ReservationDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Reservation;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Aleksej_home on 2015.07.22
 */

public class ReservationDAOImpl extends DAOImpl implements ReservationDAO {

    public void create(Reservation reservation) throws DBException {
        if (reservation == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into reservations values (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, reservation.getFrom());
            preparedStatement.setDate(2, reservation.getTill());
            preparedStatement.setInt(3, reservation.getPlacesCount());
            preparedStatement.setBoolean(4, reservation.isStatus());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                reservation.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Reservation getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from reservations where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Reservation reservation = null;
            if (resultSet.next()) {
                reservation = new Reservation();
                reservation.setId(resultSet.getLong("id"));
                reservation.setFrom(resultSet.getDate("from_date"));
                reservation.setTill(resultSet.getDate("to_date"));
                reservation.setPlacesCount(resultSet.getInt("p_count"));
                reservation.setTimestamp(resultSet.getDate("time_stamp"));
                reservation.setStatus(resultSet.getBoolean("status"));

            }
            return reservation;
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
                    .prepareStatement("delete from reservations where id = ?");
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

    public void update(Reservation reservation) throws DBException {
        if (reservation == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update reservations set from_date = ?, to_date = ?, p_count = ?, status = ? " +
                            "where id = ?");

            preparedStatement.setDate(1, reservation.getFrom());
            preparedStatement.setDate(2, reservation.getTill());
            preparedStatement.setInt(3, reservation.getPlacesCount());
            preparedStatement.setBoolean(4, reservation.isStatus());
            preparedStatement.setLong(5, reservation.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Reservation> getAll() throws DBException {

        List<Reservation> reservations = new ArrayList<Reservation>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from reservations");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(resultSet.getLong("id"));
                reservation.setFrom(resultSet.getDate("from_date"));
                reservation.setTill(resultSet.getDate("to_date"));
                reservation.setPlacesCount(resultSet.getInt("p_count"));
                reservation.setTimestamp(resultSet.getDate("time_stamp"));
                reservation.setStatus(resultSet.getBoolean("status"));

                reservations.add(reservation);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return reservations;
    }




}
