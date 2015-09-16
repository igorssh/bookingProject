package lv.javaguru.java2.core.database.hibernate.backend;

import lv.javaguru.java2.core.database.hibernate.GenericDaoImpl;
import lv.javaguru.java2.core.domain.backend.User;
import org.springframework.stereotype.Repository;

@Repository("User_DAO")
public class UserDAOImpl extends GenericDaoImpl<User, Long>{
    public UserDAOImpl() {
        super(User.class);
    }
}
