package lv.javaguru.java2.core.database.jdbc.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.HotelDAO;
import lv.javaguru.java2.core.database.frontend.RoomClassDAO;
import lv.javaguru.java2.core.database.frontend.SearchDAO;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import lv.javaguru.java2.core.domain.frontend.RoomClass;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@WebAppConfiguration

public class SearchDAOImplTest {

    @Autowired
    private SearchDAO searchDAO;

    @Autowired
    private RoomClassDAO hotelClassDAO;

    @Autowired
    private HotelDAO hotelDAO;

    private RoomClass roomClass = new RoomClass((byte) 1, "Description about", "Brutal");
    private Hotel hotel = new Hotel("images/apartments/thumbs/stud150x100.png", "Putina street 10", "For poor person, .. students and other", (byte) 3);
    private Hotel hotel2 = new Hotel("images/apartments/thumbs/stud150x100.png", "Putina street 55", "Super mega hotel for rich person", (byte) 5);

    @Before
    public void setUp() throws DBException {
        hotelClassDAO.create(roomClass);
        hotelDAO.create(hotel);
        hotelDAO.create(hotel2);
    }

    @Test
    public void testSearchHotelByAddress() throws DBException {
        String searchSpec = "Putina";

        List<Hotel> hotels = searchDAO.searchHotel(searchSpec);

        assertTrue(hotels.stream().allMatch(h -> h.getAddress().contains(searchSpec)));
    }

    @Test
    public void testSearchHotelByDesc() throws DBException {
        String searchSpec = "poor person";

        List<Hotel> hotels = searchDAO.searchHotel(searchSpec);

        assertTrue(hotels.stream().allMatch(h -> h.getDescription().contains(searchSpec)));
    }
}