package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.domain.frontend.Extra;
import lv.javaguru.java2.core.database.hibernate.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Aleksej_home on 2015.09.15..
 */
@Repository("Extra_DAO")
public class ExtraGenericDAOImpl extends GenericDaoImpl<Extra, Long> {
    public ExtraGenericDAOImpl() {
        super(Extra.class);
    }
}
