package lv.javaguru.java2.servlet.mvc.controllers.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReviewsController {

    @RequestMapping(value = "reviews", method = {RequestMethod.GET})
    public ModelAndView processRequest() {
        return new ModelAndView("frontend/reviews", "model", null);
    }
}
