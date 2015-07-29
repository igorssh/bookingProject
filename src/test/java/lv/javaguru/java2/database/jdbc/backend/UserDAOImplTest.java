package lv.javaguru.java2.database.jdbc.backend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.backend.RoleDAO;
import lv.javaguru.java2.database.backend.UserDAO;
import lv.javaguru.java2.database.jdbc.*;
import lv.javaguru.java2.domain.backend.Role;
import lv.javaguru.java2.domain.backend.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAOImplTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();

    private UserDAO userDAO = new UserDAOImpl();
    
    private RoleDAO roleDAO = new RoleDAOImpl();

    @Before
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
        roleDAO.create(new Role("ADMIN", "Administrator role"));
    }

    @Test
    public void testCreate() throws DBException {
        User user = createUser("A", "B", "25878965", "test@test.com", "ac", "123", roleDAO.getByRoleName("ADMIN"));
        
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
        User user = createUser("A", "B", "25878965", "test@test.com", "ac", "123", roleDAO.getByRoleName("ADMIN"));
        userDAO.create(user);
        
        assertEquals(1, userDAO.getAll().size());
        
        userDAO.delete(user.getId());
        assertEquals(0, userDAO.getAll().size());
    }

    @Test
    public void testUpdate() throws DBException {
        User user = createUser("A", "B", "25878965", "test@test.com", "ac", "123", roleDAO.getByRoleName("ADMIN"));
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
        User user = createUser("A", "B", "25878965", "test@test.com", "ac", "123", roleDAO.getByRoleName("ADMIN"));
        User anotherUser = createUser("F", "B", "25878961", "test@javaguru.com", "ad", "123", roleDAO.getByRoleName("ADMIN"));
        
        userDAO.create(user);
        userDAO.create(anotherUser);
        assertEquals(userDAO.getAll().size(), 2);
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