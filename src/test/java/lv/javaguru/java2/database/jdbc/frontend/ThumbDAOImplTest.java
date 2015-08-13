package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.HotelClassDAO;
import lv.javaguru.java2.database.frontend.HotelDAO;
import lv.javaguru.java2.database.frontend.RoomDAO;
import lv.javaguru.java2.database.frontend.ThumbDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.frontend.Hotel;
import lv.javaguru.java2.domain.frontend.HotelClass;
import lv.javaguru.java2.domain.frontend.Room;
import lv.javaguru.java2.domain.frontend.Thumb;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)

public class ThumbDAOImplTest {

    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Autowired
    private ThumbDAO thumbDAO;

    @Autowired
    private HotelClassDAO hotelClassDAO;

    @Autowired
    @Qualifier("HotelDAO")
    private HotelDAO hotelDAO;

    @Autowired
    private RoomDAO roomDAO;
    
    private HotelClass hotelClass = new HotelClass(1, "Description about");
    private Hotel hotel = new Hotel("label1", "Address 1", "Description about");
    private Room room = new Room(1, 2, 30.00, "Standard room", hotelClass, hotel);


    @Before
    public void setUp() throws Exception {
        databaseCleaner.cleanDatabase();
        hotelDAO.create(hotel);
        hotelClassDAO.create(hotelClass);
        roomDAO.create(room);
    }

    @Test
    public void testCreate() throws DBException {
        Thumb thumb = new Thumb("Thumb 1", "Thumb for room", "Original", room);
        thumbDAO.create(thumb);

        Thumb thumbFromDb = thumbDAO.getById(thumb.getId());

        assertEquals(thumb.getLabel(), thumbFromDb.getLabel());
        assertEquals(thumb.getDesc(), thumbFromDb.getDesc());
        assertEquals(thumb.getOrig(), thumbFromDb.getOrig());
        assertEquals(thumb.getRoom().getId(), thumbFromDb.getRoom().getId());
    }

    @Test
    public void testUpdate() throws DBException {
        Thumb thumb = new Thumb("Thumb 1", "Thumb for room", "Original", room);
        thumbDAO.create(thumb);

        thumb.setLabel("Thumb 2");
        thumb.setDesc("Thumb for room 2");
        thumb.setOrig("Original 2");
        thumbDAO.update(thumb);

        Thumb thumbFromDb = thumbDAO.getById(thumb.getId());

        assertEquals(thumb.getLabel(), thumbFromDb.getLabel());
        assertEquals(thumb.getDesc(), thumbFromDb.getDesc());
        assertEquals(thumb.getOrig(), thumbFromDb.getOrig());
    }

    @Test
    public void testDelete() throws DBException {
        Thumb thumb = new Thumb("Thumb 1", "Thumb for room", "Original", room);

        thumbDAO.create(thumb);
        assertEquals(1, thumbDAO.getAll().size());

        thumbDAO.delete(thumb.getId());
        assertEquals(0, thumbDAO.getAll().size());
    }

    @Test
    public void testMultipleThumbCreation() throws Exception {
        Thumb thumb1 = new Thumb("Thumb 1", "Thumb for room 1", "Original 1", room);
        Thumb thumb2 = new Thumb("Thumb 2", "Thumb for room 2", "Original 2", room);

        thumbDAO.create(thumb1);
        thumbDAO.create(thumb2);

        assertEquals(2, thumbDAO.getAll().size());
    }
}