package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ClientDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.frontend.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientDAOImplTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private ClientDAO clientDAO = new ClientDAOImpl();

    @Before
    public void setUp() throws Exception {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        Client client = createClient("Artur", "Ivanov", "artur.ivanov@gmail.com", "12345", "Maxima", "131085-15678", "400004534");

        clientDAO.create(client);

        Client clientFromDb = clientDAO.getById(client.getId());

        assertEquals(client.getName(), clientFromDb.getName());
        assertEquals(client.getSurname(), clientFromDb.getSurname());
        assertEquals(client.getEmail(), clientFromDb.getEmail());
        assertEquals(client.getPhone(), clientFromDb.getPhone());
        assertEquals(client.getCorp(), clientFromDb.getCorp());
        assertEquals(client.getPersonalNumber(), clientFromDb.getPersonalNumber());
        assertEquals(client.getRegistryNumber(), clientFromDb.getRegistryNumber());
    }

    @Test
    public void testUpdate() throws DBException {
        Client client = createClient("Artur", "Ivanov", "artur.ivanov@gmail.com", "12345", "Maxima", "131085-15678", "400004534");
        clientDAO.create(client);

        client.setName("Ivan");
        client.setSurname("Arturov");
        clientDAO.update(client);

        Client clientFromDb = clientDAO.getById(client.getId());

        assertEquals(client.getName(), clientFromDb.getName());
        assertEquals(client.getSurname(), clientFromDb.getSurname());
    }

    @Test
    public void testDelete() throws DBException {
        Client client = createClient("Artur", "Ivanov", "artur.ivanov@gmail.com", "12345", "Maxima", "131085-15678", "400004534");

        clientDAO.create(client);
        assertEquals(1, clientDAO.getAll().size());

        clientDAO.delete(client.getId());
        assertEquals(0, clientDAO.getAll().size());
    }

    @Test
    public void testMultipleClientCreation() throws Exception {
        Client clientA = createClient("Artur", "Ivanov", "artur.ivanov@gmail.com", "12345", "Maxima", "131085-15678", "400004534");
        Client clientB = createClient("Artur", "Pirozhkov", "artur.pirozhkov@gmail.com", "54321", "Maxima", "070885-12345", "400004789");

        clientDAO.create(clientA);
        clientDAO.create(clientB);
        assertEquals(2, clientDAO.getAll().size());
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
}