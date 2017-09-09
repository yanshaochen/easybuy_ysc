package cn.happy.servlet;

import cn.happy.bean.Easybuy_user;
import cn.happy.service.IUserValidateService;
import cn.happy.service.impl.UserValidateServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by master on 17-9-6.
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/UserServlet/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    Logger logger = Logger.getLogger(RegisterServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> param = new HashMap<>();
        param.put("eu_username", request.getParameter("loginName"));
        param.put("eu_password", request.getParameter("password"));
        param.put("eu_sex", request.getParameter("sex"));
        param.put("eu_email", request.getParameter("email"));
        param.put("eu_mobile", request.getParameter("mobile"));
        param.put("eu_identitycode", request.getParameter("identityCode"));
        param.put("eu_realname", request.getParameter("userName"));
        IUserValidateService service = new UserValidateServiceImpl();
        if (service.setUser(param)) {
            Easybuy_user user = service.getUserByUserName(param.get("eu_username"));
            request.getSession().setAttribute("user_login_permission", user);
            request.getRequestDispatcher("/UserServlet/ProductServlet").forward(request, response);
        } else {
            logger.error("user login failed");
            request.getRequestDispatcher("/UserServlet/ProductServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
