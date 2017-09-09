package cn.happy.servlet;

import cn.happy.bean.Easybuy_user;
import cn.happy.service.ICartService;
import cn.happy.service.impl.CartServiceImpl;
import cn.happy.util.CartUtil;
import cn.happy.util.MemcachedUtil;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 *
 * Created by master on 17-9-7.
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/UserServlet/CartServlet"})
public class CartServlet extends HttpServlet {
    private MemcachedUtil mc = MemcachedUtil.getInstance();
    Logger logger = Logger.getLogger(CartServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("addCart")) {
            doAddCart(request, response);
        }

    }

    private void doAddCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //get session
        Easybuy_user user = (Easybuy_user) request.getSession().getAttribute("user_login_permission");
        String ep_id = request.getParameter("ep_id");
        String quantity = request.getParameter("quantity");
        if (user == null) {
            //save to memCached when user not logged in
            ICartService service = new CartServiceImpl();
            Gson gson = new Gson();
            Cookie cookie = null;
            response.setContentType("text/plain");
            //get cookies,if cookies name "username" exist,get the specific cookie
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie item : cookies) {
                    if (item.getName().equals("username"))
                        cookie = item;
                }
            }
            //first request,the cookies does not contain name "username"
            if (cookie == null) {
                Random random = new Random();
                String username = String.valueOf(System.currentTimeMillis()) + String.valueOf(random.nextInt(9999) % (9000) + 1000);
                cookie = new Cookie("username", username);
                //create cart object,ok
                CartUtil cartUtil = service.initCartUtils(ep_id, quantity);
                //save in memCached,must add json form
                mc.add(username, gson.toJson(cartUtil));
                cookie.setMaxAge(60 * 60 * 24);
                response.addCookie(cookie);
                //set cartUtils to session
                request.getSession().setAttribute("cartUtil", cartUtil);
                response.sendRedirect(request.getContextPath() + "/UserServlet/ProductServlet?action=showDetail&ep_id=" + ep_id);
                return;
            }
            //cookie not null
            String username = cookie.getValue();
            //json to generic
            CartUtil cartUtil = gson.fromJson((String) mc.get(username), CartUtil.class);
            if (cartUtil != null) {
                service.addCart(cartUtil, ep_id, quantity);
                mc.replace(username, gson.toJson(cartUtil));
                cookie.setMaxAge(60 * 60 * 24);
                response.addCookie(cookie);
                request.getSession().removeAttribute("cartUtil");
                request.getSession().setAttribute("cartUtil", cartUtil);
                response.sendRedirect(request.getContextPath() + "/UserServlet/ProductServlet?action=showDetail&ep_id=" + ep_id);
            } else {//cartUtil cache is null
                cartUtil = service.initCartUtils(ep_id, quantity);
                //flush cookie and cache
                mc.set(username, gson.toJson(cartUtil));
                cookie.setMaxAge(60 * 60 * 24);
                response.addCookie(cookie);
                request.getSession().removeAttribute("cartUtil");
                request.getSession().setAttribute("cartUtil", cartUtil);
                response.sendRedirect(request.getContextPath() + "/UserServlet/ProductServlet?action=showDetail&ep_id=" + ep_id);
            }
        } else {
            //user is logged in,save to DB
            ICartService service = new CartServiceImpl();
            CartUtil cartUtil = service.getCartByUser(user.getEu_id());
            service.addCart(cartUtil, ep_id, quantity);
            //删除原有购物车,加入新的购物车
            boolean falg = service.setCartByUser(user.getEu_id(), cartUtil);
            if (falg) {
                request.getSession().removeAttribute("cartUtil");
                request.getSession().setAttribute("cartUtil", cartUtil);
                response.sendRedirect(request.getContextPath() + "/UserServlet/ProductServlet?action=showDetail&ep_id=" + ep_id);
            } else {
                logger.error("save cartUtil to DB failed");
                response.sendRedirect(request.getContextPath() + "/UserServlet/ProductServlet?action=showDetail&ep_id=" + ep_id);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
