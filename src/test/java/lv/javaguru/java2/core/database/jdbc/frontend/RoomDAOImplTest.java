package lv.javaguru.java2.core.database.jdbc.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.RoomClassDAO;
import lv.javaguru.java2.core.database.frontend.HotelDAO;
import lv.javaguru.java2.core.database.frontend.RoomDAO;
import lv.javaguru.java2.core.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import lv.javaguru.java2.core.domain.frontend.RoomClass;
import lv.javaguru.java2.core.domain.frontend.Room;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)

public class RoomDAOImplTest {

    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Autowired
    private RoomClassDAO roomClassDAO;

    @Autowired
    private RoomDAO roomDAO;

    @Autowired
    private HotelDAO hotelDAO;
    
    private Hotel hotel = new Hotel("label1", "Address 1", "Description about", (byte)3);
    private RoomClass roomClass = new RoomClass((byte)2, "Description about", "Standart");

    private static final double DELTA = 1e-3;

    @Before
    public void setUp() throws DBException {
        databaseCleaner.cleanDatabase();
        hotelDAO.create(hotel);
        roomClassDAO.create(roomClass);
    }

    @Test
    public void testCreate() throws DBException {
        String[] args = new String[2];

        args[0] = "getHotel";
        args[1] = "getRoomClass";
        //session.update(entity);
        Room room = new Room(1, 2, 30.00, "Standard room", roomClass, hotel);
        roomDAO.create(room);

       // Room roomFromDb = roomDAO.getById(room.getId());
        Room roomFromDb = roomDAO.getById(room.getId(),args);
       // Hibernate.initialize(roomFromDb.getRoomClass());
       // Hibernate.initialize(roomFromDb.getHotel());


       // System.out.println("Test proxyff: " + roomFromDb.getRoomClass());

        assertEquals(room.getRoomNumber(), roomFromDb.getRoomNumber());
        assertEquals(room.getPersonCount(), roomFromDb.getPersonCount());
        assertEquals(room.getPricePerDay(), roomFromDb.getPricePerDay(), DELTA);
        assertEquals(room.getDescription(), roomFromDb.getDescription());
        assertEquals(room.getRoomClass().getId(), roomFromDb.getRoomClass().getId());
        assertEquals(room.getHotel().getId(), roomFromDb.getHotel().getId());
    }

    @Test
    public void testUpdate() throws DBException {
        Room room = new Room(1, 2, 30.00, "Standard room", roomClass, hotel);
        roomDAO.create(room);

        room.setPricePerDay(45);
        room.setDescription("Deluxe room");
        roomDAO.update(room);

        Room roomFromDb = roomDAO.getById(room.getId());

        assertEquals(room.getPricePerDay(), roomFromDb.getPricePerDay(), DELTA);
        assertEquals(room.getDescription(), roomFromDb.getDescription());
    }

    @Test
    public void testDelete() throws DBException {
        Room room = new Room(1, 2, 30.00, "Standard room", roomClass, hotel);

        roomDAO.create(room);
        assertEquals(1, roomDAO.getAll().size());

        roomDAO.delete(room.getId());
        assertEquals(0, roomDAO.getAll().size());
    }

    @Test
    public void testMultipleRoomCreation() throws DBException {
        Room room1 = new Room(1, 2, 30.00, "Standard room", roomClass, hotel);
        Room room2 = new Room(2, 2, 45.00, "Deluxe room", roomClass, hotel);

        roomDAO.create(room1);
        roomDAO.create(room2);
        assertEquals(2, roomDAO.getAll().size());
    }
}