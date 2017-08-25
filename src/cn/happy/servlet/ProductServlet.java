package cn.happy.servlet;

import cn.happy.bean.Easybuy_product;
import cn.happy.service.ICategoryService;
import cn.happy.service.ITop10Service;
import cn.happy.service.impl.CategoryServiceImpl;
import cn.happy.service.impl.Top10ServiceImpl;
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
@WebServlet(name = "ProductServlet", urlPatterns = {"/servlet/ProductServlet"})
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //show category
        ICategoryService categoryService = new CategoryServiceImpl();
        List<CategoryUtil> categories = categoryService.getCategories();
        request.setAttribute("categories", categories);
        //show top10
        ITop10Service tops = new Top10ServiceImpl();
        List<Easybuy_product> top10 = tops.getTop10();
        request.setAttribute("top10", top10);
        //dispatch
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
