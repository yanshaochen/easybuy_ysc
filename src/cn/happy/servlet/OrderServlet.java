package cn.happy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by master on 17-9-10.
 */
@WebServlet(name = "OrderServlet", urlPatterns = {"/UserServletF/OrderServlet"})
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] esc_ids = request.getParameterValues("esc_ids");
        String action = request.getParameter("action");
        System.out.println(esc_ids);
        System.out.println(action);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
