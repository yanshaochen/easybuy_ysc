package cn.happy.servlet;

import cn.happy.service.ICategoryService;
import cn.happy.service.impl.CategoryServiceImpl;
import cn.happy.util.CategoryUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by master on 17-8-23.
 */
@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICategoryService categoryService = new CategoryServiceImpl();
        List<CategoryUtil> categories = categoryService.getCategories();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
