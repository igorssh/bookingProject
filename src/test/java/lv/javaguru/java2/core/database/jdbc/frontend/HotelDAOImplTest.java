package lv.javaguru.java2.core.database.jdbc.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.HotelDAO;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@WebAppConfiguration

@Transactional
public class HotelDAOImplTest {

    @Autowired
    private HotelDAO hotelDAO;

    @Test
    public void testCreate() throws DBException {
        Hotel hotel = new Hotel("label1", "Address 1", "Description about", (byte) 3);

        hotelDAO.create(hotel);

        Hotel hotelFromDb = hotelDAO.getById(hotel.getId());
        assertNotNull(hotelFromDb);
        assertEquals(hotel.getId(), hotelFromDb.getId());
        assertEquals(hotel.getLabel(), hotelFromDb.getLabel());
        assertEquals(hotel.getAddress(), hotelFromDb.getAddress());
        assertEquals(hotel.getDescription(), hotelFromDb.getDescription());
    }

    @Test
    public void testUpdate() throws DBException {
        Hotel hotel = new Hotel("images/apartments/thumbs/drak150x100.png", "Address 1", "Description about 1", (byte) 5);

        hotelDAO.create(hotel);

        hotel.setLabel("images/apartments/thumbs/vanap150x100.png");
        hotel.setAddress("Address 2");
        hotel.setDescription("Description about 2");
        hotelDAO.update(hotel);

        Hotel hotelFromDb = hotelDAO.getById(hotel.getId());

        assertEquals(hotel.getLabel(), hotelFromDb.getLabel());
        assertEquals(hotel.getAddress(), hotelFromDb.getAddress());
        assertEquals(hotel.getDescription(), hotelFromDb.getDescription());
    }

    @Test
    public void testDelete() throws DBException {
        Hotel hotel = new Hotel("images/apartments/thumbs/drak150x100.png", "Address 1", "Description about 1", (byte) 3);

        hotelDAO.create(hotel);
        Long hotelId = hotel.getId();
        assertNotNull(hotelDAO.getById(hotelId));

        hotelDAO.delete(hotelId);
        assertNull(hotelDAO.getById(hotelId));
    }

    @Test
    public void testMultipleApartmentCreation() throws DBException {
        Hotel hotel1 = new Hotel("label 2", "Address 2", "Description about 1", (byte) 3);
        Hotel hotel2 = new Hotel("label 3", "Address 3", "Description about 2", (byte) 3);
        hotelDAO.create(hotel1);
        hotelDAO.create(hotel2);
        List<Hotel> hotels = hotelDAO.getAll().stream()
                .filter(h -> h.getId() == hotel1.getId() || h.getId() == hotel2.getId())
                .collect(Collectors.toList());

        assertEquals(2, hotels.size());
    }
}
