package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.frontend.HotelClassDAO;
import lv.javaguru.java2.database.frontend.HotelDAO;
import lv.javaguru.java2.database.frontend.RoomDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.frontend.Hotel;
import lv.javaguru.java2.domain.frontend.HotelClass;
import lv.javaguru.java2.domain.frontend.Room;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomDAOImplTest {
    
    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private HotelClassDAO hotelClassDAO = new HotelClassDAOImpl();
    private RoomDAO roomDAO = new RoomDAOImpl();
    private HotelDAO hotelDAO = new HotelDAOImpl();
    private Hotel hotel = new Hotel("label1", "Adress 1", "Description about");
    private HotelClass hotelClass = new HotelClass(1, "Description about");

    private static final double DELTA = 1e-3;
    

    @Before
    public void setUp() throws Exception {
        databaseCleaner.cleanDatabase();
        hotelDAO.create(hotel);
        hotelClassDAO.create(hotelClass);
    }

    @Test
    public void testCreate() throws Exception {
        Room room = new Room(1, 2, 30.00, "Standart room", hotelClass, hotel);
        roomDAO.create(room);
        
        Room roomFromDb = roomDAO.getById(room.getId());

        assertEquals(room.getRoomNumber(), roomFromDb.getRoomNumber());
        assertEquals(room.getPersonCount(), roomFromDb.getPersonCount());
        assertEquals(room.getPricePerDay(), roomFromDb.getPricePerDay(), DELTA);
        assertEquals(room.getDescription(), roomFromDb.getDescription());
        assertEquals(room.getHotelClass().getId(), roomFromDb.getHotelClass().getId());
        assertEquals(room.getHotel().getId(), roomFromDb.getHotel().getId());
    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }
}