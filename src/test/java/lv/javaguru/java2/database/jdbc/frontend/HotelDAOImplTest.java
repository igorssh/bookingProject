package lv.javaguru.java2.database.jdbc.frontend;

import static org.junit.Assert.*;

import java.util.List;

import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import org.junit.Before;
import org.junit.Test;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Hotel;

public class HotelDAOImplTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private HotelDAOImpl hotelDAO = new HotelDAOImpl();

    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        Hotel hotel = new Hotel("label1", "Address 1", "Description about");

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
        Hotel hotel = new Hotel("images/apartments/thumbs/drak150x100.png", "Address 1", "Description about 1");

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
        Hotel hotel = new Hotel("images/apartments/thumbs/drak150x100.png", "Address 1", "Description about 1");

        hotelDAO.create(hotel);

        assertEquals(1, hotelDAO.getAll().size());

        hotelDAO.delete(hotel.getId());
        assertEquals(0, hotelDAO.getAll().size());
    }

    @Test
    public void testMultipleApartmentCreation() throws DBException {
        Hotel hotel1 = new Hotel("label 2", "Address 2", "Description about 1");
        Hotel hotel2 = new Hotel("label 3", "Address 3", "Description about 2");
        hotelDAO.create(hotel1);
        hotelDAO.create(hotel2);
        List<Hotel> users = hotelDAO.getAll();
        assertEquals(2, users.size());
    }
}
