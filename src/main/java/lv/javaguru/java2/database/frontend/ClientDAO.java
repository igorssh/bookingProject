package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Client;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21
 */

public interface ClientDAO {

    void create(Client client) throws DBException;

    Client getById(long id) throws DBException;

    void delete(long id) throws DBException;

    void update(Client client) throws DBException;

    List<Client> getAll() throws DBException;
}
