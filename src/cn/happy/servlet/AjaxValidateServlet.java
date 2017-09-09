package cn.happy.servlet;

import cn.happy.service.IUserValidateService;
import cn.happy.service.impl.UserValidateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Created by master on 17-9-6.
 */
@WebServlet(name = "AjaxValidateServlet", urlPatterns = {"/UserServlet/AjaxValidateServlet"})
public class AjaxValidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserValidateService service = new UserValidateServiceImpl();
        String loginName = request.getParameter("loginName");
        if (service.ValidateByUser(loginName)) {
            response.getWriter().print(false);
        } else {
            response.getWriter().print(true);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
