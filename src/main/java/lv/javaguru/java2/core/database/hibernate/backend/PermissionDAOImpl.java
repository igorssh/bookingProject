package lv.javaguru.java2.core.database.hibernate.backend;

import lv.javaguru.java2.core.domain.backend.Permission;
import lv.javaguru.java2.core.database.hibernate.GenericDaoImpl;
import org.springframework.stereotype.Repository;

@Repository("Permission_DAO")
public class PermissionDAOImpl extends GenericDaoImpl<Permission, Long> {
    public PermissionDAOImpl() {
        super(Permission.class);
    }
}
