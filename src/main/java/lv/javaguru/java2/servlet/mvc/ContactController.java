package lv.javaguru.java2.servlet.mvc;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ContactController implements MVCController {

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        return new MVCModel(null, "/home.jsp");
    }
}
