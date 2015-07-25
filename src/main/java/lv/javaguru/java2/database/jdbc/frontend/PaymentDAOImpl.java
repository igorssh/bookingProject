package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.PaymentDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Payment;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Aleksej_home on 2015.07.22
 */

public class PaymentDAOImpl extends DAOImpl implements PaymentDAO {
    
    public void create(Payment payment) throws DBException {
        if (payment == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into payments values (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setDouble(1, payment.getMoney());
            preparedStatement.setString(2, payment.getDesc());
            preparedStatement.setShort(3, payment.getPaymentType());
            preparedStatement.setString(4, payment.getReferent());

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
            Payment pa = null;
            if (resultSet.next()) {
                pa = new Payment();
                pa.setId(resultSet.getLong("id"));
                pa.setMoney(resultSet.getDouble("money"));
                pa.setDesc(resultSet.getString("desc_text"));
                pa.setPaymentType(resultSet.getShort("pay_type"));
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
                    .prepareStatement("update payments set money = ?, desc_text = ?, pay_type = ?, referent = ? " +
                            "where id = ?");
            preparedStatement.setDouble(1, payment.getMoney());
            preparedStatement.setString(2, payment.getDesc());
            preparedStatement.setShort(3, payment.getPaymentType());
            preparedStatement.setString(4, payment.getReferent());
            preparedStatement.setLong(5, payment.getId());
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

        List<Payment> aps = new ArrayList<Payment>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from apartments");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Payment pa = new Payment();
                pa.setId(resultSet.getLong("id"));
                pa.setMoney(resultSet.getDouble("money"));
                pa.setDesc(resultSet.getString("desc_text"));
                pa.setPaymentType(resultSet.getShort("pay_type"));
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
