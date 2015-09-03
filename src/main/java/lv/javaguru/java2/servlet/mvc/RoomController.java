package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.HotelDAO;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

//import org.springframework.transaction.annotation.Transactional;

@Controller
public class RoomController implements MVCController {

    @Autowired
    HotelDAO hotelDAO;

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        try {
            String idString = req.getParameter("id");

            if (idString != null) {
                Hotel hotel = hotelDAO.getById(Long.parseLong(idString));
                return new MVCModel(hotel, "/rooms.jsp");
            } else {
                return new MVCModel(null, "/home.jsp");
            }

        } catch (DBException e) {
            return new MVCModel(null, "/home.jsp");
        }

    }
}
