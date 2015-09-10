package lv.javaguru.java2.servlet.mvc.controllers.frontend;

import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ContactController implements MVCController {

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        return new MVCModel(null, "/contact.jsp");
    }
}
