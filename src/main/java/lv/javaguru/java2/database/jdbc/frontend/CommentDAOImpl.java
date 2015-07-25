package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.CommentDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.frontend.Comment;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Aleksej_home on 2015.07.22
 */

public class CommentDAOImpl extends DAOImpl implements CommentDAO {

    public void create(Comment comment) throws DBException {
        if (comment == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into comments values (default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, comment.getHead());
            preparedStatement.setString(2, comment.getDesc());
            preparedStatement.setTimestamp(3, comment.getTimestamp());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                comment.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public Comment getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from comments where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Comment com = null;
            if (resultSet.next()) {
                com = new Comment();
                com.setId(resultSet.getLong("id"));
                com.setHead(resultSet.getString("head"));
                com.setTimestamp(resultSet.getTimestamp("time_stamp"));
                com.setDesc(resultSet.getString("desc_text"));
            }
            return com;
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
                    .prepareStatement("delete from comments where id = ?");
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

    public void update(Comment com) throws DBException {

        if (com == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update comments set head = ?, desc_text = ? " +
                            "where id = ?");
            preparedStatement.setString(1, com.getHead());
            preparedStatement.setString(2, com.getDesc());
            preparedStatement.setLong(3, com.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
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
                Comment com = new Comment();
                com.setId(resultSet.getLong("id"));
                com.setHead(resultSet.getString("head"));
                com.setDesc(resultSet.getString("desc_text"));
                aps.add(com);
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
