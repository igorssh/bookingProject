package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Payment;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21
 */

public interface PaymentDAO {

    void create(Payment payment) throws DBException;

    Payment getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Payment pa) throws DBException;

    List<Payment> getAll() throws DBException;
}
