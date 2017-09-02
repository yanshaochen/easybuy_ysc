package cn.happy.servlet;

import cn.happy.bean.Easybuy_product_category;
import cn.happy.bean.Easybuy_product_child;
import cn.happy.service.ICategoryService;
import cn.happy.service.impl.CategoryServiceImpl;
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
 * Created by master on 17-9-1.
 */
@WebServlet(name = "AjaxClassificationQueryServlet", urlPatterns = {"/AdminServlet/AjaxClassificationQueryServlet"})
public class AjaxClassificationQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String epc_id = request.getParameter("epc_id");
        String epp_id = request.getParameter("epp_id");
        //category/parent
        if (epc_id != null && !epc_id.equals("")) {
            ICategoryService service = new CategoryServiceImpl();
            List<Easybuy_product_child> children = service.getChildrenByCategoryId(epc_id);
            new SomeConverts().ajaxWrite(children, response);
        } else if (epp_id != null && !epp_id.equals("")) {
            ICategoryService service = new CategoryServiceImpl();
            List<Easybuy_product_category> categories = service.getCategoriesByParentId(epp_id);
            new SomeConverts().ajaxWrite(categories, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
