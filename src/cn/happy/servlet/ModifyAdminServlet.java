package cn.happy.servlet;

import cn.happy.service.IAdminLoginService;
import cn.happy.service.impl.AdminLoginServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by master on 17-8-26.
 */
@WebServlet(name = "ModifyAdminServlet", urlPatterns = {"/AdminServlet/ModifyAdminServlet"})
public class ModifyAdminServlet extends HttpServlet {

    Logger logger = Logger.getLogger(ModifyAdminServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) request.getSession().getAttribute("admin_login_permission");
        String mpass = request.getParameter("mpass");
        String renewpass = request.getParameter("renewpass");
        IAdminLoginService service = new AdminLoginServiceImpl();
        boolean isAdmin = service.isAdmin(name, mpass);
        if (isAdmin) {
            boolean flag = service.setNewPassword(name, renewpass);
            if (flag)
                request.setAttribute("operate", "success");
            else
                logger.error("set new password failed:" + name);
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
