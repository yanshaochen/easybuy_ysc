package cn.happy.servlet;

import cn.happy.service.ICategoryService;
import cn.happy.service.impl.CategoryServiceImpl;
import cn.happy.util.CategoryUtil;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by master on 17-8-28.
 */
@WebServlet(name = "AjaxCategoryServlet", urlPatterns = {"/UserServlet/AjaxCategoryServlet"})
public class AjaxCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String epp_id = request.getParameter("epp_id");
        ICategoryService service = new CategoryServiceImpl();
        List<CategoryUtil> categories = service.getCategoriesByParentId(epp_id);
        if (categories != null) {
            Gson gson = new Gson();
            String json = gson.toJson(categories);
            response.setHeader("content-type", "text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(json);
            writer.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
