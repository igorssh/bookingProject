package lv.javaguru.java2.servlet.mvc.controllers.backend;

import lv.javaguru.java2.core.domain.frontend.Hotel;
import lv.javaguru.java2.core.generators.patterns.BuilderGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class GenarateController {

    @Autowired
    BuilderGenerator builderGenerator;

    @RequestMapping(value = "generator", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request, HttpServletRequest response) {
       // ModelAndView modelAndView = new ModelAndView("backend/sys/generator", "model", null);

        Map<Integer, Class> domainList = new LinkedHashMap<>();
        Map<Integer, String > generationList = new LinkedHashMap<>();
       // Map<String, Object> customForm = new HashMap<>();
        int itr = 0;
       for (Class<? extends Object> dom : builderGenerator.getDomainsObjects()){
             domainList.put(itr, dom);
           itr++;
        }


        //customForm.put("object", Object.class);
        Map params = new HashMap();
      /*  builderGenerator.getDomainsObjects().forEach(
                (obj) -> {
                    domainList.put(obj.getSimpleName(), obj);
                });*/
        params.put("domainList", domainList);
        generationList.put(0, "BuilderAndFactory");
        generationList.put(1, "DTO");
        generationList.put(2,"Custom");

        //Collection<String> co = generationList.values();
      //  generationList
        ;
        params.put("generationList", generationList);

       // customForm.put("domainList", domainList);
       // customForm.put("generationList", generationList);
       // params.put("customForm", customForm);



        return new ModelAndView("backend/sys/generator", "model", params);
    }

    @RequestMapping(value = "generator", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request, HttpServletRequest response) {
        try {
            Map<String, Object> params = new HashMap<>();
            Map<String, Class> gal = new HashMap<>();
            Class cl = null;
            String es = request.getParameter("clazz");

            int itr = 0;
            for (Class<? extends Object> dom : builderGenerator.getDomainsObjects()){
                if (es.matches(dom.getSimpleName())){
                    cl = dom;
                    break;
                }
              //  gal.put(itr, dom);
                itr++;
            }

            String clazz = request.getParameter("clazz");
            String pathc = request.getParameter("pathc");



            if (cl != null)
            builderGenerator.writeCodeModel("generated", cl);


            params.put("clazz", es);
            params.put("pathc", pathc);
            ModelAndView modelAndView = new ModelAndView("backend/generated", "model", params);
            //  ModelAndView modelAndView = new ModelAndView("backend/generated", "model", params);
            return modelAndView;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
