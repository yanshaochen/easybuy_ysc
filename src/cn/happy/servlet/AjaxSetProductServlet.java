package cn.happy.servlet;

import cn.happy.bean.Easybuy_product;
import cn.happy.service.IProductService;
import cn.happy.service.impl.ProductServiceImpl;
import cn.happy.util.PageUtil;
import cn.happy.util.SomeConverts;

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
@WebServlet(name = "AjaxSetProductServlet", urlPatterns = {"/AdminServlet/AjaxSetProductServlet"})
public class AjaxSetProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ep_parent_id = request.getParameter("ep_parent_id");
        String ep_category_id = request.getParameter("ep_category_id");
        String ep_child_id = request.getParameter("ep_child_id");
        String searchKey = request.getParameter("searchKey");
        if (searchKey == null) {
            searchKey = "";
        } else {
            if (searchKey.equals(new String(searchKey.getBytes("ISO-8859-1"), "ISO-8859-1")))
                searchKey = new String(searchKey.getBytes("ISO-8859-1"), "utf-8");
        }
        IProductService service = new ProductServiceImpl();
        //set page
        PageUtil page = new PageUtil();
        String num = request.getParameter("pageIndex");
        if (num != null && !num.equals("")) {
            page.setPageIndex(Integer.parseInt(num));
        } else {
            page.setPageIndex(1);
        }
        //set products
        List<Easybuy_product> products;
        if (ep_child_id != null && !ep_child_id.equals("")) {
            page.setTotalCount(service.getTotalRecordsByChildId(ep_child_id, searchKey));
            products = service.getProductsInPageByChildId(page, ep_child_id, searchKey);
        } else if (ep_category_id != null && !ep_category_id.equals("")) {
            page.setTotalCount(service.getTotalRecordsByCategoryId(ep_category_id, searchKey));
            products = service.getProductsInPageByCategoryId(page, ep_category_id, searchKey);
        } else if (ep_parent_id != null && !ep_parent_id.equals("")) {
            page.setTotalCount(service.getTotalRecordsByParentId(ep_parent_id, searchKey));
            products = service.getProductsInPageByParentId(page, ep_parent_id, searchKey);
        } else {
            page.setTotalCount(service.getTotalRecords(searchKey));
            products = service.getProductsInPage(page, searchKey);
        }
        if (products.size() != 0) {
            products.get(0).setPageUtil(page);
        }
        new SomeConverts().ajaxWrite(products, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
