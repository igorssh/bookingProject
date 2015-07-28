package lv.javaguru.java2.database.jdbc.backend;

import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.backend.Role;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoleDAOImplTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private RoleDAOImpl roleDAO = new RoleDAOImpl();

    @Before
    public void setUp() throws Exception {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws Exception {
        Role role = new Role("ADMIN", "Administrator role");
        roleDAO.create(role);
        
        Role roleFromDb = roleDAO.getById(role.getId());
        
        assertEquals(role.getLabel(), roleFromDb.getLabel());
        assertEquals(role.getDesc(), roleFromDb.getDesc());
    }

    @Test
    public void testDelete() throws Exception {
        Role role = new Role("ADMIN", "Administrator role");
        roleDAO.create(role);
        
        assertEquals(roleDAO.getAll().size(), 1);
        
        roleDAO.delete(role.getId());
        
        assertEquals(roleDAO.getAll().size(), 0);
    }

    @Test
    public void testUpdate() throws Exception {
        Role role = new Role("ADMIN", "Administrator role");
        roleDAO.create(role);

        role.setLabel("Operator");
        role.setDesc("Operator role");

        roleDAO.update(role);
        Role roleFromDb = roleDAO.getById(role.getId());

        assertEquals("Operator", roleFromDb.getLabel());
        assertEquals("Operator role", roleFromDb.getDesc());
    }

    @Test
    public void testMultipleUserCreation() throws Exception {
        Role adminRole = new Role("ADMIN", "Administrator role");
        Role operatorRole = new Role("OPERATOR", "Operator role");
        
        roleDAO.create(adminRole);
        roleDAO.create(operatorRole);
        
        assertEquals(roleDAO.getAll().size(), 2);
    }
}