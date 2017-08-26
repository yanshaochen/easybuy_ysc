package cn.happy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by master on 17-8-26.
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/AdminServlet/LogoutServlet", "/UserServlet/LogoutServlet"})
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        //admin logout
        if (type != null && type.equals("admin")) {
            request.getSession().removeAttribute("admin_login_permission");
            response.sendRedirect("/easybuy/easybuy.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
