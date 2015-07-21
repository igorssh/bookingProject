package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Comment;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21..
 */
public interface CommentDAO {

    void create(Comment com) throws DBException;

    Comment getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Comment com) throws DBException;

    List<Comment> getAll() throws DBException;
}
