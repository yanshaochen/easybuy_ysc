package cn.happy.servlet;

import cn.happy.service.IProductService;
import cn.happy.service.impl.ProductServiceImpl;
import cn.happy.util.ProductAndCategoryListUtil;
import cn.happy.util.SomeConverts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Created by master on 17-9-2.
 */
@WebServlet(name = "AjaxGetProductByIdServlet", urlPatterns = {"/AdminServlet/AjaxGetProductByIdServlet"})
public class AjaxGetProductByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ep_id = request.getParameter("ep_id");
        IProductService service = new ProductServiceImpl();
        ProductAndCategoryListUtil productAndCategoryList = service.getProductAndCategoryListUtil(ep_id);
        new SomeConverts().ajaxWrite(productAndCategoryList, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
