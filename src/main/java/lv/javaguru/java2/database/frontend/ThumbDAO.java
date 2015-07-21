package lv.javaguru.java2.database.frontend;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.frontend.Thumb;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.21..
 */
public interface ThumbDAO {

    void create(Thumb th) throws DBException;

    Thumb getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Thumb th) throws DBException;

    List<Thumb> getAll() throws DBException;
}
