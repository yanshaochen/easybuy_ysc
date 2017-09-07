package cn.happy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *
 * Created by master on 17-8-22.
 */
@WebFilter(filterName = "EncodeFilter", urlPatterns = {"/AdminServlet/*", "/UserServlet/*", "/UserServletF/*", "/jsp/*", "/background_jsp/*", "*.jsp"})
public class EncodeFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
