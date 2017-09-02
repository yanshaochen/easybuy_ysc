package cn.happy.servlet;

import cn.happy.service.ICategoryService;
import cn.happy.service.impl.CategoryServiceImpl;
import cn.happy.util.ParentUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * Created by master on 17-8-31.
 */
@WebServlet(name = "SetProductsServlet", urlPatterns = {"/AdminServlet/SetProductsServlet"})
public class SetProductsServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(SliderServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        //show products
        if (action != null && action.equals("show")) {
            doShow(request, response);
            return;
        }
        if (action != null && action.equals("failed")) {
            request.setAttribute("operate", "set product operation failed");
            request.getRequestDispatcher("/info.jsp").forward(request, response);
        }
    }

    private void doShow(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ICategoryService categoryService = new CategoryServiceImpl();
        List<ParentUtil> parentUtils = categoryService.getParentUtils();
        request.setAttribute("parentUtils", parentUtils);
        request.getRequestDispatcher("/background_jsp/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
