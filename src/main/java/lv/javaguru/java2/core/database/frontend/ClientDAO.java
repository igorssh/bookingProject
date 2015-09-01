package lv.javaguru.java2.core.database.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.domain.frontend.Client;

import java.util.List;

public interface ClientDAO {

    void create(Client client) throws DBException;

    Client getById(long id) throws DBException;

    void delete(long id) throws DBException;

    void update(Client client) throws DBException;

    List<Client> getAll() throws DBException;
}
