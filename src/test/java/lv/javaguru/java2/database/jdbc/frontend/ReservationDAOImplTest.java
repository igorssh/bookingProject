package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.*;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.frontend.*;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)

public class ReservationDAOImplTest {

    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Autowired
    private ReservationDAO reservationDAO;

    @Autowired
    private HotelClassDAO hotelClassDAO;

    @Autowired
    @Qualifier("HotelDAO")
    private HotelDAO hotelDAO;

    @Autowired
    private RoomDAO roomDAO;

    @Autowired
    private ClientDAO clientDAO;

    private Hotel hotel = new Hotel("label1", "Address 1", "Description about");
    private HotelClass hotelClass = new HotelClass(1, "Description about");
    private Room room = new Room(1, 2, 30.00, "Standard room", hotelClass, hotel);
    private Client client = createClient("Artur", "Ivanov", "artur.ivanov@gmail.com", "12345", "Maxima", "131085-14578", "400004534");
    private Client secondClient = createClient("Vadim", "Sidorov", "vadim.sidorov@gmail.com", "12345", "Maxima", "131085-15679", "500004534");
    DateTime dt1 = new DateTime(2015, 8, 10, 12, 0, 0);
    Timestamp timestamp1 = new Timestamp(dt1.getMillis());

    DateTime dt2 = new DateTime(2015, 8, 11, 12, 0, 0);
    Timestamp timestamp2 = new Timestamp(dt2.getMillis());

    @Before
    public void setUp() throws DBException {
        databaseCleaner.cleanDatabase();
        hotelDAO.create(hotel);
        hotelClassDAO.create(hotelClass);
        roomDAO.create(room);
        clientDAO.create(client);
        clientDAO.create(secondClient);
    }

    @Test
    public void testCreate() throws DBException {
        Reservation reservation = createReservation(timestamp1, timestamp2, 2, true, room, client);
        reservationDAO.create(reservation);

        Reservation reservationFromDb = reservationDAO.getById(reservation.getId());

        assertEquals(reservation.getFrom(), reservationFromDb.getFrom());
        assertEquals(reservation.getTill(), reservationFromDb.getTill());
        assertEquals(reservation.getPersonsCount(), reservationFromDb.getPersonsCount());
        assertEquals(reservation.getRoom().getId(), reservationFromDb.getRoom().getId());
        assertEquals(reservation.getClient().getId(), reservationFromDb.getClient().getId());
    }

    @Test
    public void testDelete() throws DBException {
        Reservation reservation = createReservation(timestamp1, timestamp2, 2, true, room, client);

        reservationDAO.create(reservation);
        assertEquals(1, reservationDAO.getAll().size());

        reservationDAO.delete(reservation.getId());
        assertEquals(0, reservationDAO.getAll().size());
    }

    @Test
    public void testUpdate() throws DBException {
        Reservation reservation = createReservation(timestamp1, timestamp2, 2, true, room, client);
        reservationDAO.create(reservation);

        DateTime dt3 = new DateTime(2015, 8, 12, 12, 0, 0);
        Timestamp timestamp3 = new Timestamp(dt3.getMillis());

        reservation.setTill(timestamp3);
        reservation.setPersonsCount(3);
        reservation.setClient(secondClient);
        reservationDAO.update(reservation);

        Reservation reservationFromDb = reservationDAO.getById(reservation.getId());

        assertEquals(reservation.getTill(), reservationFromDb.getTill());
        assertEquals(reservation.getPersonsCount(), reservationFromDb.getPersonsCount());
        assertEquals(reservation.getClient().getId(), reservationFromDb.getClient().getId());
    }

    @Test
    public void testMultipleReservationCreation() throws DBException {
        Reservation reservation1 = createReservation(timestamp1, timestamp2, 2, true, room, client);
        Reservation reservation2 = createReservation(timestamp1, timestamp2, 3, true, room, secondClient);

        reservationDAO.create(reservation1);
        reservationDAO.create(reservation2);

        assertEquals(2, reservationDAO.getAll().size());
    }

    private Client createClient(String name, String surname, String email, String phone, String corp,
                                String personalNumber, String registryNumber) {
        Client client = new Client();
        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);
        client.setPhone(phone);
        client.setCorp(corp);
        client.setPersonalNumber(personalNumber);
        client.setRegistryNumber(registryNumber);

        return client;
    }

    private Reservation createReservation(Timestamp from, Timestamp till, int personsCount, boolean status, Room room, Client client) {
        Reservation reservation = new Reservation();
        reservation.setFrom(from);
        reservation.setTill(till);
        reservation.setPersonsCount(personsCount);
        reservation.setStatus(status);
        reservation.setRoom(room);
        reservation.setClient(client);

        return reservation;
    }
}