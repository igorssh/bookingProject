package lv.javaguru.java2.servlet.mvc.controllers.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import lv.javaguru.java2.core.database.hibernate.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HotelController {

   // @Autowired(constructor=new GenericDao<Hotel, Long>(Class<Hotel> ))
    @Autowired
    @Qualifier("Hotel_DAO")
    GenericDao<Hotel, Long> genericDao;
   // GenericDao<Hotel, Long> genericDao = new GenericDaoImpl<Hotel, Long>(Hotel.class);


  //  HotelDAO hotel

    @RequestMapping(value = "hotels", method = {RequestMethod.GET})
    public ModelAndView processRequest() {
        try {
           // List<Hotel> hotels = hotelDAO.getAll();
            List<Hotel> hotels = genericDao.getAll();

            if (hotels.size() != 0) {
                return new ModelAndView("frontend/hotels", "model", hotels);
            } else {
                return new ModelAndView("frontend/home", "model", null);
            }
        } catch (DBException e) {
            return new ModelAndView("frontend/home", "model", null);
        }
    }
}
