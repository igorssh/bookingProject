package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ClientDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.frontend.Client;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)

public class ClientDAOImplTest {
    
    @Autowired
    private ClientDAO clientDAO;

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
        assertNotNull(clientDAO.getById(client.getId()));

        clientDAO.delete(client.getId());
        assertNull(clientDAO.getById(client.getId()));
    }

    @Test
    public void testMultipleClientCreation() throws Exception {
        Client clientA = createClient("Artur", "Ivanov", "artur.ivanov@gmail.com", "12345", "Maxima", "131085-15678", "400004534");
        Client clientB = createClient("Artur", "Pirozhkov", "artur.pirozhkov@gmail.com", "54321", "Maxima", "070885-12345", "400004789");

        clientDAO.create(clientA);
        clientDAO.create(clientB);
        assertNotNull(clientDAO.getById(clientA.getId()));
        assertNotNull(clientDAO.getById(clientB.getId()));
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