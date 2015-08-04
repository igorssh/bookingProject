package lv.javaguru.java2.servlet.mvc;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MVCFilter implements Filter {

    private Map<String, MVCController> controllers = new HashMap<String, MVCController>();

    public void init(FilterConfig filterConfig) throws ServletException {
        controllers.put("/apartments.jsp", new ApartmentController());
        controllers.put("/contact.jsp", new ContactController());
        controllers.put("/extras.jsp", new ExtraController());
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
