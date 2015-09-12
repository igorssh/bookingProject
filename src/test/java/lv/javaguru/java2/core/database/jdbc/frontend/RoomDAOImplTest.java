package lv.javaguru.java2.core.database.jdbc.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.HotelDAO;
import lv.javaguru.java2.core.database.frontend.RoomClassDAO;
import lv.javaguru.java2.core.database.frontend.RoomDAO;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import lv.javaguru.java2.core.domain.frontend.Room;
import lv.javaguru.java2.core.domain.frontend.RoomClass;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Before;
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
public class RoomDAOImplTest {

    @Autowired
    private RoomClassDAO roomClassDAO;

    @Autowired
    private RoomDAO roomDAO;

    @Autowired
    private HotelDAO hotelDAO;

    private Hotel hotel = new Hotel("label1", "Address 1", "Description about", (byte) 3);
    private RoomClass roomClass = new RoomClass((byte) 2, "Description about", "Standart");

    private static final double DELTA = 1e-3;

    @Before
    public void setUp() throws DBException {
        hotelDAO.create(hotel);
        roomClassDAO.create(roomClass);
    }

    @Test
    public void testCreate() throws DBException {
        Room room = new Room(1, 2, 30.00, "Standard room", roomClass, hotel);
        roomDAO.create(room);

        Room roomFromDb = roomDAO.getById(room.getId());

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
        Long roomId = room.getId();
        assertNotNull(roomDAO.getById(roomId));

        roomDAO.delete(room.getId());
        assertNull(roomDAO.getById(roomId));
    }

    @Test
    public void testMultipleRoomCreation() throws DBException {
        Room room1 = new Room(1, 2, 30.00, "Standard room", roomClass, hotel);
        Room room2 = new Room(2, 2, 45.00, "Deluxe room", roomClass, hotel);

        roomDAO.create(room1);
        roomDAO.create(room2);

        List<Room> rooms = roomDAO.getAll().stream()
                .filter(r -> r.getId() == room1.getId() || r.getId() == room2.getId())
                .collect(Collectors.toList());
        assertEquals(2, rooms.size());
    }
}