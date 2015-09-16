package lv.javaguru.java2.core.database.hibernate.backend;

import lv.javaguru.java2.core.database.hibernate.GenericDao;
import lv.javaguru.java2.core.domain.backend.Permission;
import lv.javaguru.java2.core.domain.backend.Role;
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
public class PermissionDAOImplTest {

    @Autowired
    @Qualifier("Permission_DAO")
    private GenericDao<Permission, Long> permissionDAO;

    @Autowired
    @Qualifier("Role_DAO")
    private GenericDao<Role, Long> roleDAO;

    @Before
    public void setUp() throws Exception {
        roleDAO.create(new Role("ADMIN", "Administrator role"));
    }

    @Test
    public void testCreate() throws Exception {
        Permission permission = new Permission("READ", "Read permission", roleDAO.getByFieldName("label", "ADMIN"));
        permissionDAO.create(permission);

        Permission permissionFromDb = permissionDAO.getById(permission.getId());

        assertEquals(permission.getLabel(), permissionFromDb.getLabel());
        assertEquals(permission.getDesc(), permissionFromDb.getDesc());
        assertEquals(permission.getRoleId(), permissionFromDb.getRoleId());
    }

    @Test
    public void testDelete() throws Exception {
        Permission permission = new Permission("READ", "Read permission", roleDAO.getByFieldName("label", "ADMIN"));

        permissionDAO.create(permission);
        Long permissionId = permission.getId();
        
        assertNotNull(permissionDAO.getById(permissionId));

        permissionDAO.delete(permission.getId());
        assertNull(permissionDAO.getById(permissionId));
    }

    @Test
    public void testUpdate() throws Exception {
        Permission permission = new Permission("READ", "Read permission", roleDAO.getByFieldName("label", "ADMIN"));
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
        Permission readPermission = new Permission("READ", "Read permission", roleDAO.getByFieldName("label", "ADMIN"));
        Permission writePermission = new Permission("Write", "Write permission", roleDAO.getByFieldName("label", "ADMIN"));

        permissionDAO.create(readPermission);
        permissionDAO.create(writePermission);

        List<Permission> permissions = permissionDAO.getAll().stream()
                .filter(t -> t.getId() == readPermission.getId() || t.getId() == writePermission.getId())
                .collect(Collectors.toList());

        assertEquals(2, permissions.size());
    }
}