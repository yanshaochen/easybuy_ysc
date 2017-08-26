package cn.happy.servlet;

import cn.happy.service.IAdminLoginService;
import cn.happy.service.impl.AdminLoginServiceImpl;
import cn.happy.util.Md5Util;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by master on 17-8-25.
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/AdminServlet/LoginServlet", "/UserServlet/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        //管理员登录
        if (type != null && type.equals("admin"))
            doAdminLogin(request, response);
    }

    private void doAdminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        IAdminLoginService service = new AdminLoginServiceImpl();
        boolean isAdmin = service.isAdmin(name, password);
        if (isAdmin) {
            request.getSession().setAttribute("admin_login_permission", name);
            request.getRequestDispatcher("/background_jsp/index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/easybuy.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
