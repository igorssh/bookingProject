package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Comment;

import java.util.List;

public interface CommentDAO {

    void create(Comment comment) throws DBException;

    Comment getById(long id) throws DBException;

    void delete(long id) throws DBException;

    void update(Comment comment) throws DBException;

    List<Comment> getAll() throws DBException;
}
