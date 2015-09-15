package lv.javaguru.java2.core.database.jdbc.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import lv.javaguru.java2.core.domain.frontend.Room;
import lv.javaguru.java2.core.domain.frontend.RoomClass;
import lv.javaguru.java2.core.domain.frontend.Thumb;
import lv.javaguru.java2.core.generators.generics.GenericDao;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class ThumbDAOImplTest {

    @Autowired
    @Qualifier("Thumb_DAO")
    private GenericDao<Thumb, Long> thumbDAO;

    @Autowired
    @Qualifier("RoomClass_DAO")
    private GenericDao<RoomClass, Long> roomClassDAO;

    @Autowired
    @Qualifier("Hotel_DAO")
    private GenericDao<Hotel, Long> hotelDAO;

    @Autowired
    @Qualifier("Room_DAO")
    private GenericDao<Room, Long> roomDAO;
    
    private RoomClass roomClass = new RoomClass((byte)1, "Description about", "Brutal");
    private Hotel hotel = new Hotel("label1", "Address 1", "Description about", (byte)3);
    private Room room = new Room(1, 2, 30.00, "Standard room", roomClass, hotel);


    @Before
    public void setUp() throws Exception {
        hotelDAO.create(hotel);
        roomClassDAO.create(roomClass);
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
        Long thumbId = thumb.getId();
        assertNotNull(thumbDAO.getById(thumbId));

        thumbDAO.delete(thumb.getId());
        assertNull(thumbDAO.getById(thumbId));
    }

    @Test
    public void testMultipleThumbCreation() throws Exception {
        Thumb thumb1 = new Thumb("Thumb 1", "Thumb for room 1", "Original 1", room);
        Thumb thumb2 = new Thumb("Thumb 2", "Thumb for room 2", "Original 2", room);

        thumbDAO.create(thumb1);
        thumbDAO.create(thumb2);

        List<Thumb> thumbs = thumbDAO.getAll().stream()
                .filter(t -> t.getId() == thumb1.getId() || t.getId() == thumb2.getId())
                .collect(Collectors.toList());

        assertEquals(2, thumbs.size());
    }
}