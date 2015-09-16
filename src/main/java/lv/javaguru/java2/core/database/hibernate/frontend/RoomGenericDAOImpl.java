package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.domain.frontend.Room;
import lv.javaguru.java2.core.database.hibernate.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Aleksej_home on 2015.09.15..
 */
@Repository("Room_DAO")
public class RoomGenericDAOImpl extends GenericDaoImpl<Room, Long> {
    public RoomGenericDAOImpl() {
        super(Room.class);
    }
}
