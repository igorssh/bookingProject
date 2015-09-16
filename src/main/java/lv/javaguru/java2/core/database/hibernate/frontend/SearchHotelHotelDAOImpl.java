package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.SearchHotelDAO;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchHotelHotelDAOImpl implements SearchHotelDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Hotel> searchHotel(String searchSpec) throws DBException {
        List<Hotel> hotels;

        hotels = this.searchHotelByAddress(searchSpec);
        if (hotels.size() == 0) {
            hotels = this.searchHotelByDesc(searchSpec);
        }
        return hotels;
    }

    @Override
    public List<Hotel> searchHotelByAddress(String searchSpec) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Hotel.class);
        return (List<Hotel>) criteria.add(Restrictions.like("address", searchSpec)).list();
    }

    @Override
    public List<Hotel> searchHotelByDesc(String searchSpec) throws DBException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Hotel.class);
        return (List<Hotel>) criteria.add(Restrictions.like("description", searchSpec)).list();
    }
}
