package lv.javaguru.java2.servlet.mvc.controllers.frontend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.database.frontend.ExtraDAO;
import lv.javaguru.java2.core.domain.frontend.Extra;
import lv.javaguru.java2.core.domain.frontend.ExtrasObject;
import lv.javaguru.java2.core.generators.generics.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ExtraController {

    @Autowired
    @Qualifier("Extra_DAO")
    GenericDao<Extra, Long> extraDAO;

    @RequestMapping(value = "extras", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest request) {
        try {
            List<Extra> allExtras = extraDAO.getAll();
            ExtrasObject extrasObject = new ExtrasObject();
            extrasObject.setExtras(allExtras);

            String idString = request.getParameter("id");

            if (idString != null) {
                extrasObject.setExtra(extraDAO.getById(Long.parseLong(idString)));
                return new ModelAndView("frontend/extras", "model", extrasObject);
            } else if (allExtras.size() != 0) {
                extrasObject.setExtra(allExtras.get(0));
                return new ModelAndView("frontend/extras", "model", extrasObject);
            } else {
                return new ModelAndView("frontend/extras", "model", null);
            }
        } catch (DBException e) {
            return new ModelAndView("frontend/home", "model", null);
        }
    }
}
