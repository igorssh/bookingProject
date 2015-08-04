package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

public class ContactController implements MVCController {

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        return new MVCModel(null, "/home.jsp");
    }
}
