package lv.javaguru.java2.database.jdbc.frontend;

/**
 * Created by Aleksej_home on 2015.07.22..
 */
import static org.junit.Assert.*;

import java.util.List;

import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
//import lv.javaguru.java2.database.jdbc.ApartamentDAOImpl;
//import lv.javaguru.java2.database.jdbc.UserDAOImpl;
//import lv.javaguru.java2.domain.User;
import org.junit.Before;
import org.junit.Test;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.ApClass;

public class ApClassDAOImplTest {
    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();

    private ApClassDAOImpl apDAO = new ApClassDAOImpl();


    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        Short cb;
        ApClass ap = createApClass(cb = 1, "Description about");

        apDAO.create(ap);

        ApClass apFromDB = apDAO.getById(ap.getId());
        assertNotNull(apFromDB);
        assertEquals(ap.getId(), apFromDB.getId());
        assertEquals(ap.getClassId(), apFromDB.getClassId());
        assertEquals(ap.getDesc(), apFromDB.getDesc());
    }

    @Test
    public void testMultipleApClasstCreation() throws DBException {
        Short cb;
        ApClass ap1 = createApClass(cb = 1, "Description about 1");
        ApClass ap2 = createApClass(cb = 2, "Description about 2");
        apDAO.create(ap1);
        apDAO.create(ap2);
        List<ApClass> users = apDAO.getAll();
        assertEquals(2, users.size());
    }



    private ApClass createApClass(Short label,  String desc) {
        ApClass ap = new ApClass();
        ap.setClassId(label);
        ap.setDesc(desc);
        return ap;
    }



}
