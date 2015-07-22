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
import lv.javaguru.java2.domain.frontend.Apartament;

public class RoomDAOImplTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();

    private ApartamentDAOImpl apDAO = new ApartamentDAOImpl();


    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        Apartament ap = createApartament("label1", "Adress 1", "Description about");

        apDAO.create(ap);

        Apartament apFromDB = apDAO.getById(ap.getId());
        assertNotNull(apFromDB);
        assertEquals(ap.getId(), apFromDB.getId());
        assertEquals(ap.getLabel(), apFromDB.getLabel());
        assertEquals(ap.getAdress(), apFromDB.getAdress());
        assertEquals(ap.getDesc(), apFromDB.getDesc());
    }

    @Test
    public void testMultipleApartamentCreation() throws DBException {
        Apartament ap1 = createApartament("label 2", "Adress 2", "Description about 1");
        Apartament ap2 = createApartament("label 3", "Adress 3", "Description about 2");
        apDAO.create(ap1);
        apDAO.create(ap2);
        List<Apartament> users = apDAO.getAll();
        assertEquals(2, users.size());
    }



    private Apartament createApartament(String label, String adress, String desc) {
        Apartament ap = new Apartament();
        ap.setLabel(label);
        ap.setAdress(adress);
        ap.setDesc(desc);
        return ap;
    }


}
