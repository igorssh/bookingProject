package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.domain.frontend.Hotel;
import lv.javaguru.java2.core.generators.generics.GenericDaoImpl;
import org.springframework.stereotype.Repository;

@Repository("Hotel_DAO")
public class HotelGenericDAOImpl extends GenericDaoImpl<Hotel,Long> {
    public HotelGenericDAOImpl() {
        super(Hotel.class);
    }
}
