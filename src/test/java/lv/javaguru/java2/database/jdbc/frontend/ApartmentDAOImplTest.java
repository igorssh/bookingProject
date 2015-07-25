package lv.javaguru.java2.database.jdbc.frontend;

/**
 * Created by Aleksej_home on 2015.07.25..
 */
import static org.junit.Assert.*;

import java.util.List;

import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
//import lv.javaguru.java2.database.jdbc.ApartmentDAOImpl;
//import lv.javaguru.java2.database.jdbc.UserDAOImpl;
//import lv.javaguru.java2.domain.User;
import org.junit.Before;
import org.junit.Test;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Apartment;



public class ApartmentDAOImplTest {


    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();

    private ApartmentDAOImpl apDAO = new ApartmentDAOImpl();


    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        Apartment ap = createApartment("label1", "Adress 1", "Description about");

        apDAO.create(ap);

        Apartment apFromDB = apDAO.getById(ap.getId());
        assertNotNull(apFromDB);
        assertEquals(ap.getId(), apFromDB.getId());
        assertEquals(ap.getLabel(), apFromDB.getLabel());
        assertEquals(ap.getAddress(), apFromDB.getAddress());
        assertEquals(ap.getDesc(), apFromDB.getDesc());
    }

    @Test
    public void testMultipleApartamentCreation() throws DBException {
        Apartment ap1 = createApartment("label 2", "Adress 2", "Description about 1");
        Apartment ap2 = createApartment("label 3", "Adress 3", "Description about 2");
        apDAO.create(ap1);
        apDAO.create(ap2);
        List<Apartment> users = apDAO.getAll();
        assertEquals(2, users.size());
    }



    private Apartment createApartment(String label, String adress, String desc) {
        Apartment ap = new Apartment();
        ap.setLabel(label);
        ap.setAddress(adress);
        ap.setDesc(desc);
        return ap;
    }



}
