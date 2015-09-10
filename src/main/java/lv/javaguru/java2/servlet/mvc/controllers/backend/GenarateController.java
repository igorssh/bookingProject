package lv.javaguru.java2.servlet.mvc.controllers.backend;

import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.domain.frontend.Hotel;
import lv.javaguru.java2.core.generators.patterns.BuilderGenerator;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksej_home on 2015.09.08..
 */
@Controller
public class GenarateController implements MVCController {

    @Autowired
    BuilderGenerator builderGenerator;

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        try {
            //  System.out.println("lv.javaguru.java2.core.domain.patterns.generated");
            Map<String, Object> params = new HashMap<>();
            if (req.getMethod().equalsIgnoreCase("POST")) {
                String clazz = req.getParameter("clazz");
                String pathc = req.getParameter("pathc");

                builderGenerator.writeCodeModel("generated", Hotel.class);

                params.put("clazz", clazz);
                params.put("pathc", pathc);

                return new MVCModel(params, "/backend/sys/generator.jsp");
            } else {
                return new MVCModel(null, "/backend/sys/generator.jsp");
            }
        }catch (Exception e){
             e.printStackTrace();
            return new MVCModel(null, "/backend/sys/generator.jsp");
        }


    }
}
