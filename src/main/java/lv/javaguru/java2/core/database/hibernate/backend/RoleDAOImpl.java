package lv.javaguru.java2.core.database.hibernate.backend;

import lv.javaguru.java2.core.database.hibernate.GenericDaoImpl;
import lv.javaguru.java2.core.domain.backend.Role;
import org.springframework.stereotype.Repository;

@Repository("Role_DAO")
public class RoleDAOImpl extends GenericDaoImpl<Role, Long>{
    
    public RoleDAOImpl() {
        super(Role.class);
    }
}
