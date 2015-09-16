package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.domain.frontend.RoomClass;
import lv.javaguru.java2.core.database.hibernate.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Aleksej_home on 2015.09.15..
 */
@Repository("RoomClass_DAO")
public class RoomClassGenericDAOImpl extends GenericDaoImpl<RoomClass, Long>{
    public RoomClassGenericDAOImpl() {
        super(RoomClass.class);
    }
}
