package lv.javaguru.java2.core.database.jdbc.frontend;

import static org.junit.Assert.*;

import java.util.List;

import lv.javaguru.java2.core.database.frontend.RoomClassDAO;
import lv.javaguru.java2.core.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.domain.frontend.RoomClass;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)

public class RoomClassDAOImplTest {
    
    @Autowired
    private DatabaseCleaner databaseCleaner;
    
  /*  @Autowired
    private RoomClassDAOImpl roomClassDAO;*/

    @Autowired
    private RoomClassDAO roomClassDAO;


    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        RoomClass roomClass = new RoomClass((byte)1, "Description about", "Brutal");

        roomClassDAO.create(roomClass);

        RoomClass roomClassFromDB = roomClassDAO.getById(roomClass.getId());
        assertNotNull(roomClassFromDB);
        assertEquals(roomClass.getId(), roomClassFromDB.getId());
        assertEquals(roomClass.getClassId(), roomClassFromDB.getClassId());
        assertEquals(roomClass.getDesc(), roomClassFromDB.getDesc());
        assertEquals(roomClass.getClassName(), roomClassFromDB.getClassName());
    }

    @Test
    public void testUpdate() throws DBException {
        RoomClass roomClass = new RoomClass((byte)2, "Tourist village", "Standart");

        roomClassDAO.create(roomClass);

        roomClass.setClassId((byte) 3);
        roomClass.setDesc("Club hotel");
        roomClass.setClassName("Royal");
        roomClassDAO.update(roomClass);

        RoomClass roomClassFromDb = roomClassDAO.getById(roomClass.getId());

        assertEquals(roomClass.getClassId(), roomClassFromDb.getClassId());
        assertEquals(roomClass.getDesc(), roomClassFromDb.getDesc());
        assertEquals(roomClass.getClassName(), roomClassFromDb.getClassName());
    }

    @Test
    public void testDelete() throws DBException {
        RoomClass roomClass = new RoomClass((byte)1, "Description about", "Brutal");

        roomClassDAO.create(roomClass);
        assertEquals(1, roomClassDAO.getAll().size());

        roomClassDAO.delete(roomClass.getId());
        assertEquals(0, roomClassDAO.getAll().size());
    }

    @Test
    public void testMultipleHotelCreation() throws DBException {
        RoomClass ap1 = new RoomClass((byte)1, "Description about", "Brutal");
        RoomClass ap2 = new RoomClass((byte)2, "Tourist village", "Standart");
        roomClassDAO.create(ap1);
        roomClassDAO.create(ap2);
        List<RoomClass> users = roomClassDAO.getAll();
        assertEquals(2, users.size());
    }
}
