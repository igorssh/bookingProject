package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.core.Services.CollectHotelAdditionalData;
import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.HotelDAO;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
public class RoomController implements MVCController {

    @Autowired
    CollectHotelAdditionalData hotelData;

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        try {
            String idString = req.getParameter("id");
            Map<String, Object> params = new HashMap<>();

            if (idString != null) {
              //  Hotel hotel = hotelDAO.getById(Long.parseLong(idString));
             //  params =  hotelData.processService(idString);
               // return new MVCModel(hotelData.processService(idString), "/rooms.jsp");
                return new MVCModel(hotelData.processService(idString), "/rooms.jsp");
            } else {
                return new MVCModel(null, "/home.jsp");
            }

        } catch (DBException e) {
            return new MVCModel(null, "/home.jsp");
        }

    }
}
