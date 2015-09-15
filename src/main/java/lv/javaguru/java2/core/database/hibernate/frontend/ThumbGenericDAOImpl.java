package lv.javaguru.java2.core.database.hibernate.frontend;

import lv.javaguru.java2.core.domain.frontend.Thumb;
import lv.javaguru.java2.core.generators.generics.GenericDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Aleksej_home on 2015.09.15..
 */
@Repository("Thumb_DAO")
public class ThumbGenericDAOImpl extends GenericDaoImpl<Thumb, Long> {
    public ThumbGenericDAOImpl() {
        super(Thumb.class);
    }
}
