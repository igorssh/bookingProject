package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.frontend.ExtraDAO;
import lv.javaguru.java2.domain.frontend.Extra;
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
