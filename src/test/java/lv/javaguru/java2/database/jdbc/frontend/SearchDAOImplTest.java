package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.HotelClassDAO;
import lv.javaguru.java2.database.frontend.HotelDAO;
import lv.javaguru.java2.database.frontend.SearchDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.frontend.Hotel;
import lv.javaguru.java2.domain.frontend.HotelClass;
import lv.javaguru.java2.domain.frontend.Search;
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
    private HotelClassDAO hotelClassDAO;

    @Autowired
    private HotelDAO hotelDAO;

    private HotelClass hotelClass = new HotelClass(1, "Description about");
    private Hotel hotel = new Hotel("images/apartments/thumbs/stud150x100.png", "Putina street 10", "For poor person, .. students and other");

    @Before
    public void setUp() throws DBException {
        databaseCleaner.cleanDatabase();
        hotelClassDAO.create(hotelClass);
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