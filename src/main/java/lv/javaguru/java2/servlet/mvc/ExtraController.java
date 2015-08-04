package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ExtraDAO;
import lv.javaguru.java2.database.jdbc.frontend.ExtraDAOImpl;
import lv.javaguru.java2.domain.frontend.Extra;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ExtraController implements MVCController {

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        ExtraDAO extraDAO = new ExtraDAOImpl();
        try {
            List<Extra> extras = extraDAO.getAll();

            if (extras.size() != 0) {
                return new MVCModel(extras, "/extras.jsp");
            } else {
                return new MVCModel(null, "/home.jsp");
            }
        } catch(DBException e) {
            return new MVCModel(null, "/home.jsp");
        }
    }
}
