package cn.happy.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by master on 17-8-22.
 */
@WebFilter(filterName = "AdminLoginFilter", urlPatterns = {"/background_jsp/*"}, initParams = {
        @WebInitParam(name = "excludedURL", value = "/servlet/LoginServlet")
})
public class AdminLoginFilter implements Filter {

    private Logger logger = Logger.getLogger(AdminLoginFilter.class);
    private Pattern excludedURL;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String servletPath = request.getServletPath();
        if (excludedURL.matcher(servletPath).matches()) {
            chain.doFilter(req, resp);
            return;
        }
        String login_permission = (String) request.getSession().getAttribute("login_permission");
        logger.debug("the admin permission is: " + login_permission);
        if (login_permission != null) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect(request.getContextPath() + "/easybuy.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        //get excludeUrl
        String initParameter = config.getInitParameter("excludedURL");
        if (initParameter != null && !initParameter.equals("")) {
            excludedURL = Pattern.compile(initParameter);
        }
    }

}
