package cn.happy.servlet;

import cn.happy.bean.Easybuy_user;
import cn.happy.service.IAdminLoginService;
import cn.happy.service.ICartService;
import cn.happy.service.IUserValidateService;
import cn.happy.service.impl.AdminLoginServiceImpl;
import cn.happy.service.impl.CartServiceImpl;
import cn.happy.service.impl.UserValidateServiceImpl;
import cn.happy.util.CartUtil;
import cn.happy.util.Md5Util;
import cn.happy.util.MemcachedUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * Created by master on 17-8-25.
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/AdminServlet/LoginServlet", "/UserServlet/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private MemcachedUtil mc = MemcachedUtil.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        //管理员登录
        if (type != null && type.equals("admin")) {
            doAdminLogin(request, response);
            return;
        }
        //用户登录
        if (type != null && type.equals("user")) {
            doUserLogin(request, response);
        }
    }

    private void doUserLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("loginName");
        String password = request.getParameter("password");
        IUserValidateService service = new UserValidateServiceImpl();
        if (service.corrected(name, password)) {
            Easybuy_user user = service.getUserByUserName(name);
            //The bucket stops here(cookie and cache),这里的cartUtil必须是从数据库中获取的,必须携带ID信息
            CartUtil cartUtil = (CartUtil) request.getSession().getAttribute("cartUtil");//缓存中的数据
            if (cartUtil != null) {
                ICartService cartService = new CartServiceImpl();
                CartUtil cartUtilDB = cartService.getCartByUser(user.getEu_id());//数据库中的数据
                cartService.merge(cartUtilDB, cartUtil);//void方法,将cartUtil并入cartUtilDB
                cartService.setCartByUser(user.getEu_id(), cartUtilDB);
                CartUtil cartByUser = cartService.getCartByUser(user.getEu_id());
                request.getSession().setAttribute("cartUtil", cartByUser);
            } else {
                ICartService cartService = new CartServiceImpl();
                CartUtil cartUtil1 = cartService.getCartByUser(user.getEu_id());
                request.getSession().setAttribute("cartUtil", cartUtil1);
            }
            removeCookieAndCache(request, response);
            request.getSession().setAttribute("user_login_permission", user);
            request.getRequestDispatcher("/UserServlet/ProductServlet").forward(request, response);
        } else {
            request.setAttribute("status", "failed");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    private void removeCookieAndCache(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = null;
        //谁的请求中携带了名为username的cookie,就删除那个cookie,并且清除与之对应的缓存
        Cookie[] cookies = request.getCookies();
        for (Cookie item : cookies
                ) {
            if (item.getName().equals("username")) {
                cookie = item;
            }
        }
        if (cookie != null) {
            mc.delete(cookie.getValue());
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    private void doAdminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("admin_login_permission") != null) {
            request.getRequestDispatcher("/background_jsp/index.jsp").forward(request, response);
            return;
        }
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
