package lv.javaguru.java2.servlet.mvc;


import lv.javaguru.java2.servlet.mvc.controllers.backend.GenarateController;
import lv.javaguru.java2.servlet.mvc.controllers.frontend.ContactController;
import lv.javaguru.java2.servlet.mvc.controllers.frontend.ExtraController;
import lv.javaguru.java2.servlet.mvc.controllers.frontend.HotelController;
import lv.javaguru.java2.servlet.mvc.controllers.frontend.RoomController;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MVCFilter implements Filter {

    private Map<String, MVCController> controllers = new HashMap<String, MVCController>();

    private static Logger logger = Logger.getLogger(MVCFilter.class.getName());

    private ApplicationContext springContext;
    
    

    public void init(FilterConfig filterConfig) throws ServletException {

        try {
            springContext =
                    new AnnotationConfigApplicationContext(SpringConfig.class);
        } catch (BeansException e) {
            logger.log(Level.INFO, "Spring context failed to start", e);
        }
        
        controllers.put("/views/frontend/apartments.jsp", getBean(HotelController.class));
        controllers.put("/views/frontend/contact.jsp", getBean(ContactController.class));
        controllers.put("/views/frontend/extras.jsp", getBean(ExtraController.class));
        controllers.put("/views/frontend/rooms.jsp", getBean(RoomController.class));
        controllers.put("/views/backend/sys/generator.jsp", getBean(GenarateController.class));
    }

    private MVCController getBean(Class clazz){
        return (MVCController) springContext.getBean(clazz);
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String contextURI = req.getServletPath();
        MVCController controller = controllers.get(contextURI);

        if (controller != null) {
            MVCModel model = controller.processRequest(req);

            req.setAttribute("model", model.getData());

            ServletContext context = req.getServletContext();
            RequestDispatcher requestDispatcher =
                    context.getRequestDispatcher(model.getJspName());
            requestDispatcher.forward(req, resp);
        }

        else filterChain.doFilter(request, response);
    }

    public void destroy() {

    }
}
