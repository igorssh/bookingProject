package lv.javaguru.java2.servlet.mvc.controllers.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.hibernate.GenericDao;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    @Qualifier("Hotel_DAO")
    GenericDao<Hotel, Long> hotelDao;

    @RequestMapping(value = "reservation", method = {RequestMethod.GET})
    public ModelAndView processRequest() throws DBException {
        List<Hotel> hotels = hotelDao.getAll();
        
        return new ModelAndView("frontend/reservation", "model", hotels);
    }
}
