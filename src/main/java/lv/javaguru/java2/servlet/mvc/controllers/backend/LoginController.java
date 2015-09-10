package lv.javaguru.java2.servlet.mvc.controllers.backend;

import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;

import javax.servlet.http.HttpServletRequest;

public class LoginController implements MVCController {

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        // get login
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        /*UserDAO userDAO = new UserDAOImpl();
        try {
            User user = userDAO.getUserByLogin(login);
            if (user.getLastName().equals(password)) {
                return new MVCModel(null, "ok.jsp");
            } else {
                return new MVCModel(null, "noCorrectLogin.jsp");
            }
        } catch(DBException e) {
            return new MVCModel(null, "notCorrectLogin.jsp");
        }*/

        return new MVCModel(null, "home.jsp");
    }
}
