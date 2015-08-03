package lv.javaguru.java2.database.jdbc.frontend;

import static org.junit.Assert.*;

import java.util.List;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.HotelClass;
import org.junit.Before;
import org.junit.Test;

public class HotelClassDAOImplTest {
    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private HotelClassDAOImpl hotelClassDAO = new HotelClassDAOImpl();


    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        HotelClass hotelClass = new HotelClass(1, "Description about");

        hotelClassDAO.create(hotelClass);

        HotelClass hotelClassFromDB = hotelClassDAO.getById(hotelClass.getId());
        assertNotNull(hotelClassFromDB);
        assertEquals(hotelClass.getId(), hotelClassFromDB.getId());
        assertEquals(hotelClass.getClassId(), hotelClassFromDB.getClassId());
        assertEquals(hotelClass.getDesc(), hotelClassFromDB.getDesc());
    }

    @Test
    public void testUpdate() throws DBException {
        HotelClass hotelClass = new HotelClass(1, "Tourist village");

        hotelClassDAO.create(hotelClass);

        hotelClass.setClassId(3);
        hotelClass.setDesc("Club hotel");
        hotelClassDAO.update(hotelClass);

        HotelClass hotelClassFromDb = hotelClassDAO.getById(hotelClass.getId());

        assertEquals(hotelClass.getClassId(), hotelClassFromDb.getClassId());
        assertEquals(hotelClass.getDesc(), hotelClassFromDb.getDesc());
    }

    @Test
    public void testDelete() throws DBException {
        HotelClass hotelClass = new HotelClass(1, "Tourist village");

        hotelClassDAO.create(hotelClass);
        assertEquals(1, hotelClassDAO.getAll().size());

        hotelClassDAO.delete(hotelClass.getId());
        assertEquals(0, hotelClassDAO.getAll().size());
    }

    @Test
    public void testMultipleHotelCreation() throws DBException {
        HotelClass ap1 = new HotelClass(1, "Description about 1");
        HotelClass ap2 = new HotelClass(2, "Description about 2");
        hotelClassDAO.create(ap1);
        hotelClassDAO.create(ap2);
        List<HotelClass> users = hotelClassDAO.getAll();
        assertEquals(2, users.size());
    }
}
