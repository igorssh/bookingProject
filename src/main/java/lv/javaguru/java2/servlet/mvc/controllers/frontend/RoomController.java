package lv.javaguru.java2.servlet.mvc.controllers.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.servlet.mvc.services.CollectHotelAdditionalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RoomController {

    @Autowired
    CollectHotelAdditionalData hotelData;

    @RequestMapping(value = "rooms", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest request) {
        try {
            String idString = request.getParameter("id");
            if (idString != null) {
                return new ModelAndView("frontend/rooms", "model", hotelData.processService(idString));
            } else {
                return new ModelAndView("frontend/home", "model", null);
            }
        } catch (DBException e) {
            return new ModelAndView("frontend/home", "model", null);
        }
    }
}
