package cn.happy.servlet;

import cn.happy.bean.Easybuy_product_parent;
import cn.happy.service.ICategoryService;
import cn.happy.service.impl.CategoryServiceImpl;
import cn.happy.util.SomeConverts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by master on 17-9-2.
 */
@WebServlet(name = "AjaxGetParentOptionServlet", urlPatterns = {"/AdminServlet/AjaxGetParentOptionServlet"})
public class AjaxGetParentOptionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICategoryService service = new CategoryServiceImpl();
        List<Easybuy_product_parent> parents = service.getAllParents();
        new SomeConverts().ajaxWrite(parents, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
