package lv.javaguru.java2.servlet.mvc.controllers.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.ExtraDAO;
import lv.javaguru.java2.core.domain.frontend.Extra;
import lv.javaguru.java2.core.domain.frontend.ExtrasObject;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ExtraController implements MVCController {

    @Autowired
    ExtraDAO extraDAO;

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        try {
            List<Extra> allExtras = extraDAO.getAll();
            ExtrasObject extrasObject = new ExtrasObject();
            extrasObject.setExtras(allExtras);

            String idString = req.getParameter("id");

            if (idString != null) {
                extrasObject.setExtra(extraDAO.getById(Long.parseLong(idString)));
                return new MVCModel(extrasObject, "/extras.jsp");
            } else if (allExtras.size() != 0) {
                extrasObject.setExtra(allExtras.get(0));
                return new MVCModel(extrasObject, "/extras.jsp");
            } else {
                return new MVCModel(null, "/home.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/home.jsp");
        }
    }
}
