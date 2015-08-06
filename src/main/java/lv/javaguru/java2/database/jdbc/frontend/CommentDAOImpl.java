package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ClientDAO;
import lv.javaguru.java2.database.frontend.CommentDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class CommentDAOImpl extends DAOImpl implements CommentDAO {

    @Autowired
    ClientDAO clientDAO;

    public void create(Comment comment) throws DBException {
        if (comment == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into comments values (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, comment.getHead());
            preparedStatement.setString(2, comment.getDesc());
            preparedStatement.setTimestamp(3, comment.getTimestamp());
            preparedStatement.setLong(4, comment.getClient().getId());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                comment.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute CommentDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public Comment getById(long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from comments where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Comment comment = null;
            if (resultSet.next()) {
                comment = new Comment();
                comment.setId(resultSet.getLong("id"));
                comment.setHead(resultSet.getString("head"));
                comment.setTimestamp(resultSet.getTimestamp("time_stamp"));
                comment.setDesc(resultSet.getString("desc_text"));
                comment.setClient(clientDAO.getById(resultSet.getLong("client_id")));
            }
            return comment;
        } catch (Throwable e) {
            System.out.println("Exception while execute CommentDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void delete(long id) throws DBException {

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from comments where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute CommentDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(Comment comment) throws DBException {

        if (comment == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update comments set head = ?, desc_text = ?, client_id = ? " +
                            "where id = ?");
            preparedStatement.setString(1, comment.getHead());
            preparedStatement.setString(2, comment.getDesc());
            preparedStatement.setLong(3, comment.getClient().getId());
            preparedStatement.setLong(4, comment.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute CommentDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Comment> getAll() throws DBException {
        List<Comment> aps = new ArrayList<Comment>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from comments");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setId(resultSet.getLong("id"));
                comment.setHead(resultSet.getString("head"));
                comment.setDesc(resultSet.getString("desc_text"));
                comment.setClient(clientDAO.getById(resultSet.getLong("client_id")));
                aps.add(comment);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list CommentDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return aps;
    }



}
