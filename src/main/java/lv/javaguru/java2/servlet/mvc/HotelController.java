package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.HotelDAO;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class HotelController implements MVCController {

    @Autowired
    HotelDAO hotelDAO;


    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        try {
            List<Hotel> hotels = hotelDAO.getAll();

            if (hotels.size() != 0) {
                return new MVCModel(hotels, "/apartments.jsp");
            } else {
                return new MVCModel(null, "/home.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/home.jsp");
        }
    }
}
