package cn.happy.servlet;

import cn.happy.bean.Easybuy_product;
import cn.happy.service.IProductService;
import cn.happy.service.impl.ProductServiceImpl;
import cn.happy.util.PageUtil;
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
 * Created by master on 17-8-31.
 */
@WebServlet(name = "AjaxSetProductServlet", urlPatterns = {"/AdminServlet/AjaxSetProductServlet"})
public class AjaxSetProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IProductService service = new ProductServiceImpl();
        PageUtil page = new PageUtil();
        page.setTotalCount(service.getTotalRecords());
        String num = request.getParameter("pageIndex");
        if (num != null && !num.equals("")) {
            page.setPageIndex(Integer.parseInt(num));
        } else {
            page.setPageIndex(1);
        }
        List<Easybuy_product> products = service.getProductsInPage(page);
        request.setAttribute("products", products);
        if (products != null) {
            products.get(0).setPageUtil(page);
            Gson gson = new Gson();
            String json = gson.toJson(products);
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
