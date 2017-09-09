package cn.happy.servlet;

import cn.happy.bean.Easybuy_user;
import cn.happy.service.ICartService;
import cn.happy.service.impl.CartServiceImpl;
import cn.happy.util.CartUtil;
import cn.happy.util.SomeConverts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by master on 17-9-9.
 */
@WebServlet(name = "ConfirmCartServlet", urlPatterns = {"/UserServletF/ConfirmCartServlet"})
public class ConfirmCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("addOne")) {
            doAddOneUpdate(request, response);
        } else if (action != null && action.equals("subOne")) {
            doSubOneUpdate(request, response);
        } else if (action != null && action.equals("delOne")) {
            doDelOne(request, response);
        } else if (action != null && action.equals("show")) {
            doShow(request, response);
        }
    }

    private void doShow(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Easybuy_user user = (Easybuy_user) request.getSession().getAttribute("user_login_permission");
        ICartService service = new CartServiceImpl();
        CartUtil cartUtil = service.getCartByUser(user.getEu_id());
        request.getSession().removeAttribute("cartUtil");
        request.getSession().setAttribute("cartUtil", cartUtil);
        new SomeConverts().ajaxWrite(cartUtil, response);
    }

    private void doDelOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long esc_id = Long.parseLong(request.getParameter("esc_id"));
        ICartService service = new CartServiceImpl();
        boolean flag = service.deleteCartById(esc_id);
        response.getWriter().write(String.valueOf(flag));
    }

    private void doSubOneUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int esc_quantity = Integer.parseInt(request.getParameter("esc_quantity"));
        long esc_id = Long.parseLong(request.getParameter("esc_id"));
        ICartService service = new CartServiceImpl();
        boolean flag = service.updateCartByIdAndQuantity(esc_id, esc_quantity - 1);
        response.getWriter().write(String.valueOf(flag));
    }

    private void doAddOneUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int esc_quantity = Integer.parseInt(request.getParameter("esc_quantity"));
        long esc_id = Long.parseLong(request.getParameter("esc_id"));
        ICartService service = new CartServiceImpl();
        boolean flag = service.updateCartByIdAndQuantity(esc_id, esc_quantity + 1);
        response.getWriter().write(String.valueOf(flag));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
