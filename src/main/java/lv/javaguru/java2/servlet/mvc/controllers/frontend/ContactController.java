package lv.javaguru.java2.servlet.mvc.controllers.frontend;

import lv.javaguru.java2.core.generators.patterns.BuilderGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

    @Autowired
    BuilderGenerator builderGenerator;

    @RequestMapping(value = "contact", method = {RequestMethod.GET})
    public ModelAndView processRequest() {
        return new ModelAndView("frontend/contact", "model", null);
    }
}
