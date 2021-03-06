package cn.happy.servlet;

import cn.happy.bean.Easybuy_product;
import cn.happy.service.IProductService;
import cn.happy.service.impl.ProductServiceImpl;
import cn.happy.util.CategoryUtil;
import cn.happy.util.SomeConverts;
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
 *
 * Created by master on 17-8-28.
 */
@WebServlet(name = "AjaxProductServlet", urlPatterns = {"/UserServlet/AjaxProductServlet"})
public class AjaxProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String epp_id = request.getParameter("epp_id");
        IProductService service = new ProductServiceImpl();
        List<Easybuy_product> products = service.getProductsByParentId(epp_id);
        new SomeConverts().ajaxWrite(products, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
