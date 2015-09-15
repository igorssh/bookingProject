package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.domain.frontend.Client;
import lv.javaguru.java2.core.generators.generics.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Aleksej_home on 2015.09.15..
 */
@Repository("Client_DAO")
public class ClientGenericDAOImpl extends GenericDaoImpl<Client, Long> {
    public ClientGenericDAOImpl() {
        super(Client.class);
    }
}
