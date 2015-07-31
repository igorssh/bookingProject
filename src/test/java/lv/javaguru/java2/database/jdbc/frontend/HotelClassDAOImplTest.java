package lv.javaguru.java2.database.jdbc.frontend;

import static org.junit.Assert.*;

import java.util.List;

import lv.javaguru.java2.database.jdbc.DatabaseCleaner;

import org.junit.Before;
import org.junit.Test;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.HotelClass;

public class HotelClassDAOImplTest {
    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();

    private HotelClassDAOImpl apDAO = new HotelClassDAOImpl();


    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        HotelClass hotelClass = new HotelClass(1, "Description about");

        apDAO.create(hotelClass);

        HotelClass apFromDB = apDAO.getById(hotelClass.getId());
        assertNotNull(apFromDB);
        assertEquals(hotelClass.getId(), apFromDB.getId());
        assertEquals(hotelClass.getClassId(), apFromDB.getClassId());
        assertEquals(hotelClass.getDesc(), apFromDB.getDesc());
    }

    @Test
    public void testMultipleApartamentCreation() throws DBException {
        HotelClass ap1 = new HotelClass(1, "Description about 1");
        HotelClass ap2 = new HotelClass(2, "Description about 2");
        apDAO.create(ap1);
        apDAO.create(ap2);
        List<HotelClass> users = apDAO.getAll();
        assertEquals(2, users.size());
    }
}
