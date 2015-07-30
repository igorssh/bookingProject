package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ApartmentDAO;
import lv.javaguru.java2.database.jdbc.frontend.ApartmentDAOImpl;
import lv.javaguru.java2.domain.frontend.Apartment;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ApartmentController implements MVCController {

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        ApartmentDAO apartmentDAO = new ApartmentDAOImpl();
        try {
            List<Apartment> apartments = apartmentDAO.getAll();

            if (apartments.size() != 0) {
                return new MVCModel(apartments, "/apartments.jsp");
            } else {
                return new MVCModel(null, "/home.jsp");
            }
        } catch(DBException e) {
            return new MVCModel(null, "/home.jsp");
        }
    }
}
