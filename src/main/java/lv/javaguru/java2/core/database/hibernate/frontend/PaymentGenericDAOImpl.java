package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.domain.frontend.Payment;
import lv.javaguru.java2.core.generators.generics.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Aleksej_home on 2015.09.15..
 */
@Repository("Payment_DAO")
public class PaymentGenericDAOImpl extends GenericDaoImpl<Payment, Long>{
    public PaymentGenericDAOImpl() {
        super(Payment.class);
    }
}
