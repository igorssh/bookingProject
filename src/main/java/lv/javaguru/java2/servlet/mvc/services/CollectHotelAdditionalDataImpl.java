package lv.javaguru.java2.servlet.mvc.services;

import lv.javaguru.java2.core.generators.generics.GenericDao;
import lv.javaguru.java2.core.services.DBBehavior;
import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.HotelDAO;
import lv.javaguru.java2.core.domain.frontend.Hotel;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;


@Service
@Transactional
public class CollectHotelAdditionalDataImpl implements CollectHotelAdditionalData {

    @Autowired
    DBBehavior dbBehavior;

    @Autowired
    @Qualifier("Hotel_DAO")
    GenericDao<Hotel, Long> hotelDAO;

    @Override
    public Hotel processService(String id) throws DBException {
        try {
            Hotel hotel = null;
            Map<String, Object> params = new HashMap<>();
            if (id != null) {
                hotel = hotelDAO.getById(Long.parseLong(id));
            }
            //EntityManager entityManager = null;
           // Room rm = hotel.getHotelRooms().get(0);
           // Object unproxied = entityManager.unwrap(SessionImplementor.class).getPersistenceContext().unproxy(hotel.getHotelRooms());
           // Object unproxied  = entityManager.unwrap(SessionImplementor.class).getPersistenceContext().unproxy(proxy);
           // dbBehavior.ignoreLazy(hotel, new String[]{"getHotelRooms.getRoomClass"});
            Object obj = initializeAndUnproxy(hotel);
          //  dbBehavior.ignoreLazy(hotel, );
            params.put("currentHotel", hotel);
           // params.put("rooms", hotel.getHotelRooms());
            return hotel;
        }catch (NullPointerException e){
           System.out.println(e);
        }

        return null;
    }

    private static <T> T initializeAndUnproxy(T entity) {
        if (entity == null) {
            throw new
                    NullPointerException("Entity passed for initialization is null");
        }

        Hibernate.initialize(entity);
        if (entity instanceof HibernateProxy) {
            entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer()
                    .getImplementation();
        }
        return entity;
    }
}
