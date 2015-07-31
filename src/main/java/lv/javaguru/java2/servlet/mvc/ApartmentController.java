package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.HotelDAO;
import lv.javaguru.java2.database.jdbc.frontend.HotelDAOImpl;
import lv.javaguru.java2.domain.frontend.Hotel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ApartmentController implements MVCController {

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        HotelDAO hotelDAO = new HotelDAOImpl();
        try {
            List<Hotel> hotels = hotelDAO.getAll();

            if (hotels.size() != 0) {
                return new MVCModel(hotels, "/apartments.jsp");
            } else {
                return new MVCModel(null, "/home.jsp");
            }
        } catch(DBException e) {
            return new MVCModel(null, "/home.jsp");
        }
    }
}
