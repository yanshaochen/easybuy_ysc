package cn.happy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by master on 17-8-22.
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {

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
        Object login_permission = request.getSession().getAttribute("login_permission");
        if (login_permission != null) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
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
