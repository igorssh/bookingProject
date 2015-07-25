package lv.javaguru.java2.database.frontend;

/**
 * Created by Aleksej_home on 2015.07.25..
 */
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Client;

import java.util.List;


public interface ClientDAO {

    void create(Client kli) throws DBException;

    Client getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Client kli) throws DBException;

    List<Client> getAll() throws DBException;

}
