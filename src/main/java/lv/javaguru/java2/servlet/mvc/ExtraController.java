package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ExtraDAO;
import lv.javaguru.java2.domain.frontend.Extra;
import lv.javaguru.java2.domain.frontend.ExtrasObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class ExtraController implements MVCController {

    @Autowired
    ExtraDAO extraDAO;

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        try {

            List<Extra> allExtras = extraDAO.getAll();
            ExtrasObject extrasObject = new ExtrasObject(allExtras, allExtras.get(0));

            String idString = req.getParameter("id");

            if (idString != null) {
                extrasObject.setExtra(extraDAO.getById(Long.parseLong(idString)));
                return new MVCModel(extrasObject, "/extras.jsp");
            } else {
                return new MVCModel(extrasObject, "/extras.jsp");
            }
        } catch (DBException e) {
            return new MVCModel(null, "/home.jsp");
        }
    }
}
