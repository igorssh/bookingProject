package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.domain.frontend.Comment;
import lv.javaguru.java2.core.database.hibernate.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Aleksej_home on 2015.09.15..
 */
@Repository("Comment_DAO")
public class CommentGenericDAOImpl extends GenericDaoImpl<Comment, Long> {
    public CommentGenericDAOImpl() {
        super(Comment.class);
    }
}
