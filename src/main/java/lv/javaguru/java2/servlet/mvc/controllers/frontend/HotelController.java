package lv.javaguru.java2.servlet.mvc.controllers.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.HotelDAO;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HotelController {

    @Autowired
    HotelDAO hotelDAO;

    @RequestMapping(value = "apartments", method = {RequestMethod.GET})
    public ModelAndView processRequest() {
        try {
            List<Hotel> hotels = hotelDAO.getAll();

            if (hotels.size() != 0) {
                return new ModelAndView("frontend/apartments", "model", hotels);
            } else {
                return new ModelAndView("frontend/home", "model", null);
            }
        } catch (DBException e) {
            return new ModelAndView("frontend/home", "model", null);
        }
    }
}
