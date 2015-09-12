package lv.javaguru.java2.core.database.jdbc.backend;

import lv.javaguru.java2.core.domain.backend.Role;
import lv.javaguru.java2.servlet.mvc.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@WebAppConfiguration

public class RoleDAOImplTest {

    @Autowired
    private RoleDAOImpl roleDAO;

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
        Long roleId = role.getId();
        assertNotNull(roleDAO.getById(roleId));

        roleDAO.delete(roleId);
        assertNull(roleDAO.getById(roleId));
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

        List<Role> roles = roleDAO.getAll().stream()
                .filter(t -> t.getId() == adminRole.getId() || t.getId() == operatorRole.getId())
                .collect(Collectors.toList());

        assertEquals(2, roles.size());
    }
}