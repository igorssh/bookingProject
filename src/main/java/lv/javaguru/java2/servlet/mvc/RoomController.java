package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.HotelDAO;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
//import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RoomController implements MVCController{

    @Autowired
    HotelDAO hotelDAO;


    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        try {
            Map<String, Object> params = new HashMap<>();
            String idString = req.getParameter("id");

            if (idString != null) {
                Hotel hotel = hotelDAO.getById(Long.parseLong(idString), new String[]{"getHotelRooms"});
                params.put("currentHotel", hotel);
                params.put("allRooms", hotel.getHotelRooms());
               return new MVCModel(params, "/rooms.jsp");
            }else{
                return new MVCModel(null, "/home.jsp");
            }

        } catch (DBException e) {
            return new MVCModel(null, "/home.jsp");
        }

    }
}
