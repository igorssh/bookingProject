package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.frontend.ClientDAO;
import lv.javaguru.java2.database.frontend.PaymentDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.frontend.Client;
import lv.javaguru.java2.domain.frontend.Payment;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentDAOImplTest {
    
    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private ClientDAO clientDAO = new ClientDAOImpl();
    private PaymentDAO paymentDAO = new PaymentDAOImpl();
    private Client client = createClient("Artur", "Ivanov", "artur.ivanov@gmail.com", "12345", "Maxima", "131085-15678", "400004534");
    private Client secondClient = createClient("Vadim", "Sidorov", "vadim.sidorov@gmail.com", "12345", "Maxima", "131085-15679", "500004534");
    private static final double DELTA = 1e-3;

    @Before
    public void setUp() throws Exception {
        databaseCleaner.cleanDatabase();
        clientDAO.create(client);
        clientDAO.create(secondClient);
    }

    @Test
    public void testCreate() throws Exception {
        Payment payment = new Payment(120.00, "Description", 1, "referent", client);
        paymentDAO.create(payment);
        
        Payment paymentFromDb = paymentDAO.getById(payment.getId());
        
        assertEquals(payment.getAmount(), paymentFromDb.getAmount(), DELTA);
        assertEquals(payment.getDescription(), paymentFromDb.getDescription());
        assertEquals(payment.getPaymentType(), paymentFromDb.getPaymentType());
        assertEquals(payment.getReferent(), paymentFromDb.getReferent());
        assertEquals(payment.getClient().getId(), paymentFromDb.getClient().getId());
    }

    @Test
    public void testDelete() throws Exception {
        Payment payment = new Payment(120.00, "Description", 1, "referent", client);
        paymentDAO.create(payment);
        
        assertNotNull(paymentDAO.getById(payment.getId()));
        
        paymentDAO.delete(payment.getId());
        
        assertNull(paymentDAO.getById(payment.getId()));
    }

    @Test
    public void testUpdate() throws Exception {
        Payment payment = new Payment(120.00, "Description", 1, "referent", client);
        paymentDAO.create(payment);
        
        payment.setAmount(125.00);
        payment.setDescription("Description2");
        payment.setPaymentType(2);
        payment.setReferent("referent2");
        payment.setClient(secondClient);
        
        paymentDAO.update(payment);
        
        Payment paymentFromDb = paymentDAO.getById(payment.getId());

        assertEquals(125.00, paymentFromDb.getAmount(), DELTA);
        assertEquals("Description2", paymentFromDb.getDescription());
        assertEquals(2, paymentFromDb.getPaymentType());
        assertEquals("referent2", paymentFromDb.getReferent());
        assertEquals(secondClient.getId(), paymentFromDb.getClient().getId());
    }
    
    @Test
    public void testMultipleCreate() throws Exception {
        Payment payment = new Payment(120.00, "Description", 1, "referent", client);    
        Payment secondPayment = new Payment(125.00, "Description2", 2, "referent2", secondClient);
        
        paymentDAO.create(payment);
        paymentDAO.create(secondPayment);
        
        assertEquals(2, paymentDAO.getAll().size());
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