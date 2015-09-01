package lv.javaguru.java2.core.database.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.domain.frontend.Extra;

import java.util.List;

public interface ExtraDAO {

    void create(Extra extra) throws DBException;

    Extra getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Extra extra) throws DBException;

    List<Extra> getAll() throws DBException;
}
