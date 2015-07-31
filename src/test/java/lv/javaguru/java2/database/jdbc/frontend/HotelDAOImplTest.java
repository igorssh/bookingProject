package lv.javaguru.java2.database.jdbc.frontend;

/**
 * Created by Aleksej_home on 2015.07.22
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
import lv.javaguru.java2.domain.frontend.Hotel;

public class HotelDAOImplTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();

    private HotelDAOImpl apDAO = new HotelDAOImpl();


    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        Hotel hotel = new Hotel("label1", "Adress 1", "Description about");

        apDAO.create(hotel);

        Hotel apFromDB = apDAO.getById(hotel.getId());
        assertNotNull(apFromDB);
        assertEquals(hotel.getId(), apFromDB.getId());
        assertEquals(hotel.getLabel(), apFromDB.getLabel());
        assertEquals(hotel.getAddress(), apFromDB.getAddress());
        assertEquals(hotel.getDescription(), apFromDB.getDescription());
    }

    @Test
    public void testMultipleApartamentCreation() throws DBException {
        Hotel ap1 = createHotel("label 2", "Adress 2", "Description about 1");
        Hotel ap2 = createHotel("label 3", "Adress 3", "Description about 2");
        apDAO.create(ap1);
        apDAO.create(ap2);
        List<Hotel> users = apDAO.getAll();
        assertEquals(2, users.size());
    }



    private Hotel createHotel(String label, String adress, String desc) {
        Hotel hotel = new Hotel();
        hotel.setLabel(label);
        hotel.setAddress(adress);
        hotel.setDescription(desc);
        return hotel;
    }


}
