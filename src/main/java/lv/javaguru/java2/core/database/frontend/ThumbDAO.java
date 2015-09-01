package lv.javaguru.java2.core.database.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.domain.frontend.Thumb;

import java.util.List;

public interface ThumbDAO {

    void create(Thumb th) throws DBException;

    Thumb getById(long id) throws DBException;

    Thumb getById(long id, String[] args) throws DBException;

    void delete(long id) throws DBException;

    void update(Thumb th) throws DBException;

    List<Thumb> getAll() throws DBException;
}
