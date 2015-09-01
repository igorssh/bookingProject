package lv.javaguru.java2.database.jdbc.frontend;

import static org.junit.Assert.*;

import java.util.List;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.HotelClassDAO;
import lv.javaguru.java2.domain.frontend.HotelClass;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)

public class HotelClassDAOImplTest {
    
    @Autowired
    private HotelClassDAO hotelClassDAO;

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
        assertNotNull(hotelClassDAO.getById(hotelClass.getId()));

        hotelClassDAO.delete(hotelClass.getId());
        assertNull(hotelClassDAO.getById(hotelClass.getId()));
    }

    @Test
    public void testMultipleHotelCreation() throws DBException {
        HotelClass hotelClass1 = new HotelClass(1, "Description about 1");
        HotelClass hotelClass2 = new HotelClass(2, "Description about 2");
        hotelClassDAO.create(hotelClass1);
        hotelClassDAO.create(hotelClass2);

        assertNotNull(hotelClassDAO.getById(hotelClass1.getId()));
        assertNotNull(hotelClassDAO.getById(hotelClass2.getId()));
    }
}
