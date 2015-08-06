package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ClientDAO;
import lv.javaguru.java2.database.frontend.PaymentDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class PaymentDAOImpl extends DAOImpl implements PaymentDAO {
    
    @Autowired
    private ClientDAO clientDAO;
    
    public void create(Payment payment) throws DBException {
        if (payment == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into payments values (default, ?, ?, ?, default, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setDouble(1, payment.getAmount());
            preparedStatement.setString(2, payment.getDescription());
            preparedStatement.setInt(3, payment.getPaymentType());
            preparedStatement.setString(4, payment.getReferent());
            preparedStatement.setLong(5, payment.getClient().getId());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                payment.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public Payment getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from payments where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Payment payment = null;
            if (resultSet.next()) {
                payment = new Payment();
                payment.setId(resultSet.getLong("id"));
                payment.setAmount(resultSet.getDouble("amount"));
                payment.setDescription(resultSet.getString("desc_text"));
                payment.setPaymentType(resultSet.getShort("pay_type"));
                payment.setTimestamp(resultSet.getDate("time_stamp"));
                payment.setReferent(resultSet.getString("referent"));
                payment.setClient(clientDAO.getById(resultSet.getLong("client_id")));
            }
            return payment;
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
                    .prepareStatement("delete from payments where id = ?");
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

    public void update(Payment payment) throws DBException {
        if (payment == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update payments set amount = ?, desc_text = ?, pay_type = ?, referent = ?, client_id =? " +
                            "where id = ?");
            preparedStatement.setDouble(1, payment.getAmount());
            preparedStatement.setString(2, payment.getDescription());
            preparedStatement.setInt(3, payment.getPaymentType());
            preparedStatement.setString(4, payment.getReferent());
            preparedStatement.setLong(5, payment.getClient().getId());
            preparedStatement.setLong(6, payment.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Payment> getAll() throws DBException {

        List<Payment> payments = new ArrayList<Payment>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from payments");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setId(resultSet.getLong("id"));
                payment.setAmount(resultSet.getDouble("amount"));
                payment.setDescription(resultSet.getString("desc_text"));
                payment.setPaymentType(resultSet.getShort("pay_type"));
                payment.setTimestamp(resultSet.getDate("time_stamp"));
                payment.setReferent(resultSet.getString("referent"));
                payment.setClient(clientDAO.getById(resultSet.getLong("client_id")));
                payments.add(payment);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return payments;
    }



}
