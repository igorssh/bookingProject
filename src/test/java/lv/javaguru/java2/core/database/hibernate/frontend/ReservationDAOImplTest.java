package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.hibernate.GenericDao;
import lv.javaguru.java2.core.domain.frontend.*;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@WebAppConfiguration

@Transactional
public class ReservationDAOImplTest {

    @Autowired
    @Qualifier("Reservation_DAO")
    private GenericDao<Reservation, Long> reservationDAO;

    @Autowired
    @Qualifier("RoomClass_DAO")
    private GenericDao<RoomClass, Long> roomClassDAO;

    @Autowired
    @Qualifier("Hotel_DAO")
    private GenericDao<Hotel, Long> hotelDAO;

    @Autowired
    @Qualifier("Room_DAO")
    private GenericDao<Room, Long> roomDAO;

    @Autowired
    @Qualifier("Client_DAO")
    private GenericDao<Client, Long> clientDAO;

    private Hotel hotel = new Hotel("label1", "Address 1", "Description about", (byte) 3);
    private RoomClass roomClass = new RoomClass((byte) 1, "Description about", "Brutal");
    private Room room = new Room(1, 2, 30.00, "Standard room", roomClass, hotel);
    private Client client = createClient("Artur", "Ivanov", "artur.ivanov@gmail.com", "12345", "Maxima", "131085-14578", "400004534");
    private Client secondClient = createClient("Vadim", "Sidorov", "vadim.sidorov@gmail.com", "12345", "Maxima", "131085-15679", "500004534");
    LocalDate date1 = LocalDate.of(2015, 8, 11);
    LocalDate date2 = LocalDate.of(2015, 8, 12);

    @Before
    public void setUp() throws DBException {
        hotelDAO.create(hotel);
        roomClassDAO.create(roomClass);
        roomDAO.create(room);
        clientDAO.create(client);
        clientDAO.create(secondClient);
    }

    @Test
    public void testCreate() throws DBException {
        Reservation reservation = createReservation(date1, date2, 2, true, room, client);
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
        Reservation reservation = createReservation(date1, date2, 2, true, room, client);

        reservationDAO.create(reservation);
        Long reservationId = reservation.getId();
        assertNotNull(reservationDAO.getById(reservationId));

        reservationDAO.delete(reservationId);
        assertNull(reservationDAO.getById(reservationId));
    }

    @Test
    public void testUpdate() throws DBException {
        Reservation reservation = createReservation(date1, date2, 2, true, room, client);
        reservationDAO.create(reservation);

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
        Reservation reservation1 = createReservation(date1, date2, 2, true, room, client);
        Reservation reservation2 = createReservation(date1, date2, 3, true, room, secondClient);

        reservationDAO.create(reservation1);
        reservationDAO.create(reservation2);

        List<Reservation> reservations = reservationDAO.getAll().stream()
                .filter(r -> r.getId() == reservation1.getId() || r.getId() == reservation2.getId())
                .collect(Collectors.toList());

        assertEquals(2, reservations.size());
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

    private Reservation createReservation(LocalDate from, LocalDate till, int personsCount, boolean status, Room room, Client client) {
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