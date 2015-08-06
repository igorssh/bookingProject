package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ExtraDAO;
import lv.javaguru.java2.database.jdbc.frontend.ExtraDAOImpl;
import lv.javaguru.java2.domain.frontend.Extra;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.08.05..
 */
public class ExtraTmpController implements MVCController {
    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        ExtraDAO extraDAO = new ExtraDAOImpl();
        try {
          //  List<Extra> extras = extraDAO.getAll();
            String str;
            List<Extra> extraMenu = extraDAO.getAllThinExtras();
            Extra extra = extraDAO.getFirst();
            str = req.getParameter("id");

           if (str != null){
               extra = extraDAO.getById(Long.parseLong(str));
               extraMenu.add(extra);
               return new MVCModel(extraMenu, "/extras.jsp");
           }else {

               if (extraMenu.size() != 0) {
                   extraMenu.add(extra);

                   return new MVCModel(extraMenu, "/extras.jsp");
               } else {
                //   extraMenu.equals(extra);
                 //  extraMenu.get(5);
                   return new MVCModel(null, "/home.jsp");
               }
           }
        } catch(DBException e) {
            return new MVCModel(null, "/home.jsp");
        }
    }
}
