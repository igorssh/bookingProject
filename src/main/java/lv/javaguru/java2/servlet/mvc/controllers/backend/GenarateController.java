package lv.javaguru.java2.servlet.mvc.controllers.backend;

import lv.javaguru.java2.core.domain.frontend.Hotel;
import lv.javaguru.java2.core.generators.patterns.BuilderGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GenarateController {

    @Autowired
    BuilderGenerator builderGenerator;

    @RequestMapping(value = "generator", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request, HttpServletRequest response) {
        ModelAndView modelAndView = new ModelAndView("backend/sys/generator", "model", null);
        return modelAndView;
    }

    @RequestMapping(value = "generator", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request, HttpServletRequest response) {
        Map<String, Object> params = new HashMap<>();

        String clazz = request.getParameter("clazz");
        String pathc = request.getParameter("pathc");

        builderGenerator.writeCodeModel("generated", Hotel.class);

        params.put("clazz", clazz);
        params.put("pathc", pathc);
     
        ModelAndView modelAndView = new ModelAndView("backend/sys/generator", "model", params);
        return modelAndView;
    }
}
