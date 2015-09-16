package lv.javaguru.java2.core.database.hibernate.backend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.hibernate.GenericDao;
import lv.javaguru.java2.core.domain.backend.Role;
import lv.javaguru.java2.core.domain.backend.User;
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

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@WebAppConfiguration

@Transactional
public class UserDAOImplTest {

    @Autowired
    @Qualifier("User_DAO")
    private GenericDao<User, Long> userDAO;
    
    @Autowired
    @Qualifier("Role_DAO")
    private GenericDao<Role, Long> roleDAO;

    @Before
    public void init() throws DBException {
        roleDAO.create(new Role("ADMIN", "Administrator role"));
    }

    @Test
    public void testCreate() throws DBException {
        User user = createUser("A", "B", "25878965", "test@test.com", "ac", "123", roleDAO.getByFieldName("label", "ADMIN"));
        
        userDAO.create(user);
        
        User userFromDb = userDAO.getById(user.getId());
        
        assertEquals(user.getName(), userFromDb.getName());
        assertEquals(user.getSurname(), userFromDb.getSurname());
        assertEquals(user.getPhone(), userFromDb.getPhone());
        assertEquals(user.getEmail(), userFromDb.getEmail());
        assertEquals(user.getUsername(), userFromDb.getUsername());
        assertEquals(user.getPassword(), userFromDb.getPassword());
        assertEquals(user.getRoleId(), userFromDb.getRoleId());
        
    }

    @Test
    public void testDelete() throws DBException {
        User user = createUser("A", "B", "25878965", "test@test.com", "ac", "123", roleDAO.getByFieldName("label", "ADMIN"));

        userDAO.create(user);
        Long userID = user.getId();
        assertNotNull(userDAO.getById(userID));
        
        userDAO.delete(user.getId());
        assertNull(userDAO.getById(userID));
    }

    @Test
    public void testUpdate() throws DBException {
        User user = createUser("A", "B", "25878965", "test@test.com", "ac", "123", roleDAO.getByFieldName("label", "ADMIN"));
        userDAO.create(user);
        
        user.setName("F");
        user.setEmail("test@javaguru.lv");
        
        userDAO.update(user);
        User userFromDb = userDAO.getById(user.getId());
        
        assertEquals("F", userFromDb.getName());
        assertEquals("test@javaguru.lv", userFromDb.getEmail());
    }

    @Test
    public void testMultipleUserCreation() throws DBException {
        User user = createUser("A", "B", "25878965", "test@test.com", "ac", "123", roleDAO.getByFieldName("label", "ADMIN"));
        User anotherUser = createUser("F", "B", "25878961", "test@javaguru.com", "ad", "123", roleDAO.getByFieldName("label", "ADMIN"));
        
        userDAO.create(user);
        userDAO.create(anotherUser);

        List<User> users = userDAO.getAll().stream()
                .filter(t -> t.getId() == user.getId() || t.getId() == anotherUser.getId())
                .collect(Collectors.toList());

        assertEquals(2, users.size());
    }
    
    private User createUser (String name, String surname, String phone, String email, String username, String password, Role role) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
        user.setRole(role);
        
        return user;
    }
}