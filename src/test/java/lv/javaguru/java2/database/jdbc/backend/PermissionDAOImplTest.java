package lv.javaguru.java2.database.jdbc.backend;

import lv.javaguru.java2.database.backend.PermissionDAO;
import lv.javaguru.java2.database.backend.RoleDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.backend.Permission;
import lv.javaguru.java2.domain.backend.Role;
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

public class PermissionDAOImplTest {

    @Autowired
    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    
    @Autowired
    private PermissionDAO permissionDAO;
    
    @Autowired
    private RoleDAO roleDAO;

    @Before
    public void setUp() throws Exception {
        databaseCleaner.cleanDatabase();
        roleDAO.create(new Role("ADMIN", "Administrator role"));
    }

    @Test
    public void testCreate() throws Exception {
        Permission permission = new Permission("READ", "Read permission", roleDAO.getByRoleName("ADMIN"));
        permissionDAO.create(permission);
        
        Permission permissionFromDb = permissionDAO.getById(permission.getId());
        
        assertEquals(permission.getLabel(), permissionFromDb.getLabel());
        assertEquals(permission.getDesc(), permissionFromDb.getDesc());
        assertEquals(permission.getRoleId(), permissionFromDb.getRoleId());
    }

    @Test
    public void testDelete() throws Exception {
        Permission permission = new Permission("READ", "Read permission", roleDAO.getByRoleName("ADMIN"));
        permissionDAO.create(permission);
        
        assertEquals(permissionDAO.getAll().size(), 1);
        
        permissionDAO.delete(permission.getId());

        assertEquals(permissionDAO.getAll().size(), 0);
    }

    @Test
    public void testUpdate() throws Exception {
        Permission permission = new Permission("READ", "Read permission", roleDAO.getByRoleName("ADMIN"));
        permissionDAO.create(permission);
        
        permission.setLabel("WRITE");
        permission.setDesc("Write permission");
        
        permissionDAO.update(permission);
        Permission permissionFromDb = permissionDAO.getById(permission.getId());
        
        assertEquals("WRITE", permissionFromDb.getLabel());
        assertEquals("Write permission", permissionFromDb.getDesc());
    }

    @Test
    public void testMultipleUserCreation() throws Exception {
        Permission readPermission = new Permission("READ", "Read permission", roleDAO.getByRoleName("ADMIN"));
        Permission writePermission = new Permission("Write", "Write permission", roleDAO.getByRoleName("ADMIN"));

        permissionDAO.create(readPermission);
        permissionDAO.create(writePermission);

        assertEquals(permissionDAO.getAll().size(), 2);
    }
}