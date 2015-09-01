package lv.javaguru.java2.core.database.jdbc.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.RoomClassDAO;
import lv.javaguru.java2.core.database.frontend.HotelDAO;
import lv.javaguru.java2.core.database.frontend.SearchDAO;
import lv.javaguru.java2.core.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import lv.javaguru.java2.core.domain.frontend.RoomClass;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)

public class SearchDAOImplTest {
    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Autowired
    private SearchDAO searchDAO;

    @Autowired
    private RoomClassDAO hotelClassDAO;

    @Autowired
    private HotelDAO hotelDAO;

    private RoomClass roomClass = new RoomClass((byte)1, "Description about", "Brutal");
    private Hotel hotel = new Hotel("images/apartments/thumbs/stud150x100.png", "Putina street 10", "For poor person, .. students and other", (byte)3);

    @Before
    public void setUp() throws DBException {
        databaseCleaner.cleanDatabase();
        hotelClassDAO.create(roomClass);
        hotelDAO.create(hotel);
    }

    @Test
    public void testSearchHotelByAddress() throws DBException {
        String searchSpec = "Putina";

        List<Hotel> hotelsExpected = hotelDAO.getAll();

        List<Hotel> hotels = searchDAO.searchHotel(searchSpec);

        assertEquals(hotelsExpected.get(0).getLabel(), hotels.get(0).getLabel());
        assertEquals(hotelsExpected.get(0).getAddress(), hotels.get(0).getAddress());
        assertEquals(hotelsExpected.get(0).getDescription(), hotels.get(0).getDescription());
    }

    @Test
    public void testSearchHotelByDesc() throws DBException {
        String searchSpec = "poor person";

        List<Hotel> hotelsExpected = hotelDAO.getAll();

        List<Hotel> hotels = searchDAO.searchHotel(searchSpec);

        assertEquals(hotelsExpected.get(0).getLabel(), hotels.get(0).getLabel());
        assertEquals(hotelsExpected.get(0).getAddress(), hotels.get(0).getAddress());
        assertEquals(hotelsExpected.get(0).getDescription(), hotels.get(0).getDescription());
    }
}