package lv.javaguru.java2.database.jdbc.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ClientDAO;
import lv.javaguru.java2.database.frontend.CommentDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.frontend.Client;
import lv.javaguru.java2.domain.frontend.Comment;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)

public class CommentDAOImplTest {

    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private ClientDAO clientDAO;

    private Client client = createClient("Artur", "Ivanov", "artur.ivanov@gmail.com", "12345", "Maxima", "131085-14578", "400004534");
    private Client secondClient = createClient("Vadim", "Sidorov", "vadim.sidorov@gmail.com", "12345", "Maxima", "131085-15679", "500004534");

    @Before
    public void setUp() throws DBException {
        databaseCleaner.cleanDatabase();
        clientDAO.create(client);
        clientDAO.create(secondClient);
    }

    @Test
    public void testCreate() throws DBException {
        Comment comment = new Comment("My first comment", "Hi, how are you?", client);

        commentDAO.create(comment);
        Comment commentFromDb = commentDAO.getById(comment.getId());

        assertEquals(comment.getHead(), commentFromDb.getHead());
        assertEquals(comment.getDesc(), commentFromDb.getDesc());
        assertEquals(comment.getClient().getId(), commentFromDb.getClient().getId());
    }

    @Test
    public void testDelete() throws DBException {
        Comment comment = new Comment("My first comment", "Hi, how are you?", client);

        commentDAO.create(comment);
        assertEquals(1, commentDAO.getAll().size());

        commentDAO.delete(comment.getId());
        assertEquals(0, commentDAO.getAll().size());
    }

    @Test
    public void testUpdate() throws DBException {
        Comment comment = new Comment("My first comment", "Hi, how are you?", client);
        commentDAO.create(comment);

        comment.setHead("My second comment");
        comment.setDesc("Hi, I'm fine!");
        comment.setClient(secondClient);
        commentDAO.update(comment);

        Comment commentFromDb = commentDAO.getById(comment.getId());

        assertEquals(comment.getHead(), commentFromDb.getHead());
        assertEquals(comment.getDesc(), commentFromDb.getDesc());
        assertEquals(secondClient.getId(), commentFromDb.getClient().getId());
    }

    @Test
    public void testMultipleCommentCreation() throws DBException {
        Comment comment = new Comment("My first comment", "Hi, how are you?", client);
        Comment secondComment = new Comment("My second comment", "Hi, I'm fine!", secondClient);

        commentDAO.create(comment);
        commentDAO.create(secondComment);

        assertEquals(2, commentDAO.getAll().size());
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