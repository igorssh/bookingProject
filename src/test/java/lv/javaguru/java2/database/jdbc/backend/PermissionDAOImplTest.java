package lv.javaguru.java2.database.jdbc.backend;

import lv.javaguru.java2.database.backend.PermissionDAO;
import lv.javaguru.java2.database.backend.RoleDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.backend.Permission;
import lv.javaguru.java2.domain.backend.Role;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PermissionDAOImplTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private PermissionDAO permissionDAO = new PermissionDAOImpl();
    private RoleDAO roleDAO = new RoleDAOImpl();

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