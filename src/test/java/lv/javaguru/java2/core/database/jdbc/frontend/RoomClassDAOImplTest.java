package lv.javaguru.java2.core.database.jdbc.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.domain.frontend.RoomClass;
import lv.javaguru.java2.core.generators.generics.GenericDao;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@WebAppConfiguration

public class RoomClassDAOImplTest {

    @Autowired
    @Qualifier("RoomClass_DAO")
    private GenericDao<RoomClass, Long> roomClassDAO;

    @Test
    public void testCreate() throws DBException {
        RoomClass roomClass = new RoomClass((byte) 1, "Description about", "Brutal");

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
        RoomClass roomClass = new RoomClass((byte) 2, "Tourist village", "Standart");

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
        RoomClass roomClass = new RoomClass((byte) 1, "Description about", "Brutal");

        roomClassDAO.create(roomClass);
        Long roomClassId = roomClass.getId();
        assertNotNull(roomClassDAO.getById(roomClassId));

        roomClassDAO.delete(roomClass.getId());
        assertNull(roomClassDAO.getById(roomClassId));
    }

    @Test
    public void testMultipleHotelCreation() throws DBException {
        RoomClass roomClassBrutal = new RoomClass((byte) 1, "Description about", "Brutal");
        RoomClass roomClassStandart = new RoomClass((byte) 2, "Tourist village", "Standart");
        roomClassDAO.create(roomClassBrutal);
        roomClassDAO.create(roomClassStandart);

        List<RoomClass> users = roomClassDAO.getAll().stream()
                .filter(r -> r.getId() == roomClassBrutal.getId() || r.getId() == roomClassStandart.getId())
                .collect(Collectors.toList());
        assertEquals(2, users.size());
    }
}
