package lv.javaguru.java2.core.database.jdbc.frontend;


import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.ReservationDAO;
import lv.javaguru.java2.core.database.jdbc.DAOImpl;
import lv.javaguru.java2.core.domain.frontend.Reservation;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

//@Component
public class ReservationDAOImpl extends DAOImpl implements ReservationDAO {

   /* @Autowired
    private RoomDAO roomDAO;

    @Autowired
    private ClientDAO clientDAO;*/

    @Override
    public Reservation getById(long id, String[] args) throws DBException {
        return null;
    }

    public void create(Reservation reservation) throws DBException {
      /*  if (reservation == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into reservations values (default, ?, ?, ?, default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setTimestamp(1, reservation.getFrom());
            preparedStatement.setTimestamp(2, reservation.getTill());
            preparedStatement.setInt(3, reservation.getPersonsCount());
            preparedStatement.setBoolean(4, reservation.getStatus());
            preparedStatement.setLong(5, reservation.getRoom().getId());
            preparedStatement.setLong(6, reservation.getClient().getId());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                reservation.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute ReservationDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }*/
    }

    public Reservation getById(long id) throws DBException {
       /* Connection connection = null;

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
                reservation.setFrom(resultSet.getTimestamp("from_date"));
                reservation.setTill(resultSet.getTimestamp("to_date"));
                reservation.setPersonsCount(resultSet.getInt("p_count"));
                reservation.setTimestamp(resultSet.getTimestamp("time_stamp"));
                reservation.setStatus(resultSet.getBoolean("status"));
                reservation.setRoom(roomDAO.getById(resultSet.getLong("room_id")));
                reservation.setClient(clientDAO.getById(resultSet.getLong("client_id")));
            }
            return reservation;
        } catch (Throwable e) {
            System.out.println("Exception while execute ReservationDAOImpl.getById()");
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
                    .prepareStatement("delete from reservations where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute ReservationDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(Reservation reservation) throws DBException {
       /* if (reservation == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update reservations set from_date = ?, to_date = ?, p_count = ?, " +
                            "status = ?, room_id = ?, client_id = ? " + "where id = ?");

            preparedStatement.setTimestamp(1, reservation.getFrom());
            preparedStatement.setTimestamp(2, reservation.getTill());
            preparedStatement.setInt(3, reservation.getPersonsCount());
            preparedStatement.setBoolean(4, reservation.getStatus());
            preparedStatement.setLong(5, reservation.getRoom().getId());
            preparedStatement.setLong(6, reservation.getClient().getId());
            preparedStatement.setLong(7, reservation.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute ReservationDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }*/
    }

    public List<Reservation> getAll() throws DBException {
/*
        List<Reservation> reservations = new ArrayList<Reservation>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from reservations");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(resultSet.getLong("id"));
                reservation.setFrom(resultSet.getTimestamp("from_date"));
                reservation.setTill(resultSet.getTimestamp("to_date"));
                reservation.setPersonsCount(resultSet.getInt("p_count"));
                reservation.setTimestamp(resultSet.getTimestamp("time_stamp"));
                reservation.setStatus(resultSet.getBoolean("status"));
                reservation.setRoom(roomDAO.getById(resultSet.getLong("room_id")));
                reservation.setClient(clientDAO.getById(resultSet.getLong("client_id")));

                reservations.add(reservation);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list ReservationDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return reservations;*/
        return null;
    }




}
